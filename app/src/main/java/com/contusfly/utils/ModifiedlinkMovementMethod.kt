package com.contusfly.utils

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.text.Selection
import android.text.Spannable
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.text.style.URLSpan
import android.util.Log
import android.view.MotionEvent
import android.view.ViewConfiguration
import android.widget.TextView
import com.contusfly.BuildConfig
import com.mirrorflysdk.api.models.ChatMessage
import com.mirrorflysdk.flycommons.LogMessage
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

class ModifiedlinkMovementMethod(
    var context: Context,
    var userJid: String,
    var selectedMessages: ArrayList<String>,
    var isLinkLongclick: Boolean
) :LinkMovementMethod() {

    private var onLongClickListener: OnLinkLongClickListener? = null
    private var onClickListener: OnLinkClickListener? = null
    private var onButtonClickListener: OnLinkClickStatusListener? = null

    private var chatmodel: ChatMessage? = null
    private var textview: TextView? = null

    override fun onTouchEvent(widget: TextView, buffer: Spannable, event: MotionEvent): Boolean {

        val action = event.action
        if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_DOWN) {
            Log.d(TAG, "onTouchEvent: one")

            var x = event.x.toInt()
            var y = event.y.toInt()
            x -= widget.totalPaddingLeft
            y -= widget.totalPaddingTop
            x += widget.scrollX
            y += widget.scrollY
            val layout = widget.layout
            val line = layout.getLineForVertical(y)
            val off = layout.getOffsetForHorizontal(line, x.toFloat())
            val link = buffer.getSpans(off, off + 1, ClickableSpan::class.java)
            if (link.isNotEmpty()) {
                if ((link[0] as URLSpan).url.contains("http") || (link[0] as URLSpan).url.contains("https") || (link[0] as URLSpan).url.contains("tel:")) {
                    longClickChecking(link,widget,event,action)
                }
                return true
            } else {
                Selection.removeSelection(buffer)
            }
        } else if (action == MotionEvent.ACTION_MOVE || action == MotionEvent.ACTION_CANCEL) {

            handler.removeCallbacks(mLongPressed)
        }


        return false
    }

    private fun longClickChecking(
        link: Array<ClickableSpan>,
        widget: TextView,
        event: MotionEvent,
        action: Int){

        try{

            if (event.getAction() == MotionEvent.ACTION_DOWN) {

                handler.postDelayed(
                    mLongPressed,
                    ViewConfiguration.getLongPressTimeout().toLong()
                )

            } else if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_MOVE) {

                handler.removeCallbacks(mLongPressed)

                urlSelectprocess(link,widget)
            }
        }catch(e:Exception){

            LogMessage.d(TAG,e.toString())
        }
    }

    private fun urlSelectprocess(link: Array<ClickableSpan>, widget: TextView): Boolean {

        try{

            if (!isLinkLongclick) {

                if (selectedMessages.size == 0) {

                    if ((link[0] as URLSpan).url.contains(BuildConfig.WEB_CHAT_LOGIN))
                        return ChatUtils.navigateToOnGoingCallPreviewScreen(
                            context,
                            userJid,
                            (link[0] as URLSpan).url
                        )
                    else link[0].onClick(widget)

                } else {

                    onClickListener!!.onClick(
                        textview, chatmodel!!.messageTextContent,
                        chatmodel!!)
                }

            } else {

                isLinkLongclick = false
                onButtonClickListener!!.onLinkClickStatus(isLinkLongclick)

            }


        }catch(e:Exception){

            LogMessage.e(TAG,e.toString())
        }

        return false
    }

    companion object {
        private val TAG = ModifiedlinkMovementMethod::class.java.simpleName
        fun expand(url: String?): String {
            val s3 = ""
            try {
                val connection = URL(url).openConnection() as HttpURLConnection
                connection.connect()
                val stream = connection.inputStream
                val reader = BufferedReader(InputStreamReader(stream))
                val responseStringBuilder = StringBuilder()
                var line: String
                while (reader.readLine().also { line = it } != null) {
                    responseStringBuilder.append(line)
                }
                Log.d(TAG, "expand: s3" + connection.url.toString())
            } catch (e: MalformedURLException) {
                Log.d(TAG, "expand: error$e")
                LogMessage.e(TAG, e)
            } catch (e: IOException) {
                LogMessage.e(TAG, e)
                Log.d(TAG, "expand: error$e")
            }
            return s3
        }
    }

    val handler: Handler = Handler(Looper.myLooper()!!)
    var mLongPressed = Runnable {
        isLinkLongclick = true
        onLongClickListener!!.onLongClick(
            textview, chatmodel!!.messageTextContent,
            chatmodel!!,isLinkLongclick
        )
    }

    fun setOnclicklistener(
        view: TextView,
        listener: OnLinkLongClickListener,
        model: ChatMessage,
        linkClickListener: OnLinkClickListener,
        linkbuttonclickstatusListener: OnLinkClickStatusListener
    ) {
        onLongClickListener = listener
        chatmodel = model
        textview = view
        onClickListener = linkClickListener
        onButtonClickListener = linkbuttonclickstatusListener
    }

    interface OnLinkLongClickListener {

        fun onLongClick(
            textView: TextView?,
            url: String?,
            view: ChatMessage,
            onclickLinkStatus: Boolean
        ): Boolean
    }

    interface OnLinkClickListener {

        fun onClick(textView: TextView?, url: String?, view: ChatMessage): Boolean
    }

    interface OnLinkClickStatusListener {

        fun onLinkClickStatus(clickStatus: Boolean): Boolean
    }

}