package com.contusfly.views

import android.animation.Animator
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.contusfly.*
import com.contusfly.chat.AndroidUtils
import com.contusfly.interfaces.ChatAttachmentLister
import com.contusfly.show
import com.mirrorflysdk.api.ChatManager

open class ChatAttachmentDialog(
    context: Context,
    val attachment: View,
    private val footerDivider: View,
    private val footerBottom: View,
    private val transparentView: View,
    private val chatAttachmentLister: ChatAttachmentLister?
) : Dialog(context, android.R.style.Theme_NoTitleBar) {

    private lateinit var dialogView: View

    private var isKeyboardOpened = false
    private var isGroupMemberListShowing = false
    private var screenHeight = 0

    private lateinit var firstAttachment: TextView
    private lateinit var secondAttachment: TextView
    private lateinit var thirdAttachment: TextView
    private lateinit var fourthAttachment: TextView
    private lateinit var fifthAttachment: TextView
    private lateinit var sixthAttachment: TextView

    private var availableAttachments = ArrayList<AttachmentTypes>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.chatview_attachment_controls)

        dialogView = findViewById(R.id.layout_attachment)
        dialogView.visibility = View.INVISIBLE

        setDialogBackground()

        window?.setFlags(
            WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
            WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
        )
        window?.setFlags(
            WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
            WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH
        )
        window?.setFlags(
            WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM,
            WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM
        )
        window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        setOnKeyListener(object : DialogInterface.OnKeyListener {
            override fun onKey(dialog: DialogInterface?, keyCode: Int, event: KeyEvent?): Boolean {
                if (keyCode == KeyEvent.KEYCODE_BACK) {
                    circularRevealDialog(false, dialogView, this@ChatAttachmentDialog)
                    return true
                }
                return false
            }
        })

        setOnShowListener {
            dialogView.post {
                circularRevealDialog(true, dialogView, this@ChatAttachmentDialog)
            }
        }

        initializeAttachments()
    }

    private fun initializeAttachments() {
        if (::dialogView.isInitialized) {
            firstAttachment = dialogView.findViewById(R.id.first_attachment)
            secondAttachment = dialogView.findViewById(R.id.second_attchment)
            thirdAttachment = dialogView.findViewById(R.id.third_attachment)
            fourthAttachment = dialogView.findViewById(R.id.fourth_attachment)
            fifthAttachment = dialogView.findViewById(R.id.fifth_attachment)
            sixthAttachment = dialogView.findViewById(R.id.sixth_attachment)

            setUpAvailableAttachments()
            setUpAttachmentListeners()
        }
    }

    private fun setUpAvailableAttachments() {
        availableAttachments = arrayListOf()

        makeViewsGone(firstAttachment, secondAttachment, thirdAttachment, fourthAttachment, fifthAttachment, sixthAttachment)
        val features = ChatManager.getAvailableFeatures()
        if (features.isDocumentAttachmentEnabled) {
            val textView = getAttachmentView()
            textView.show()
            textView.text = context.getText(R.string.label_document)
            textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_chat_documents, 0, 0)
            availableAttachments.add(AttachmentTypes.DOCUMENT)
        }

        if (features.isImageAttachmentEnabled || features.isVideoAttachmentEnabled) {
            val textView = getAttachmentView()
            textView.show()
            textView.text = context.getText(R.string.label_camera)
            textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_chat_camera, 0, 0)
            availableAttachments.add(AttachmentTypes.CAMERA)
            val galleryTextView = getAttachmentView()
            galleryTextView.show()
            galleryTextView.text = context.getText(R.string.label_gallery)
            galleryTextView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_chat_gallery, 0, 0)
            availableAttachments.add(AttachmentTypes.GALLERY)
        }

        if (features.isAudioAttachmentEnabled) {
            val textView = getAttachmentView()
            textView.show()
            textView.text = context.getText(R.string.label_audio)
            textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_chat_audio, 0, 0)
            availableAttachments.add(AttachmentTypes.AUDIO)
        }

        if (features.isContactAttachmentEnabled) {
            val textView = getAttachmentView()
            textView.show()
            textView.text = context.getText(R.string.label_contact)
            textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_chat_contacts, 0, 0)
            availableAttachments.add(AttachmentTypes.CONTACT)
        }

        if (features.isLocationAttachmentEnabled) {
            val textView = getAttachmentView()
            textView.show()
            textView.text = context.getText(R.string.label_location)
            textView.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_chat_location, 0, 0)
            availableAttachments.add(AttachmentTypes.LOCATION)
        }
    }

    private fun getAttachmentView(): TextView {
        return when (availableAttachments.size) {
            0 -> firstAttachment
            1 -> secondAttachment
            2 -> thirdAttachment
            3 -> fourthAttachment
            4 -> fifthAttachment
            5 -> sixthAttachment
            else -> firstAttachment
        }
    }

    private fun setUpAttachmentListeners() {
        firstAttachment.setOnClickListener {
            performClickAction(availableAttachments[0])
        }
        secondAttachment.setOnClickListener {
            performClickAction(availableAttachments[1])
        }
        thirdAttachment.setOnClickListener {
            performClickAction(availableAttachments[2])
        }
        fourthAttachment.setOnClickListener {
            performClickAction(availableAttachments[3])
        }
        fifthAttachment.setOnClickListener {
            performClickAction(availableAttachments[4])
        }
        sixthAttachment.setOnClickListener {
            performClickAction(availableAttachments[5])
        }
    }
    private fun performClickAction(attachmentTypes: AttachmentTypes) {
        when(attachmentTypes)  {
            AttachmentTypes.DOCUMENT -> chatAttachmentLister?.onAttachDocument()
            AttachmentTypes.CAMERA -> chatAttachmentLister?.onAttachCamera()
            AttachmentTypes.GALLERY -> chatAttachmentLister?.onAttachGallery()
            AttachmentTypes.AUDIO -> chatAttachmentLister?.onAttachAudio()
            AttachmentTypes.CONTACT -> chatAttachmentLister?.onAttachContact()
            AttachmentTypes.LOCATION -> chatAttachmentLister?.onAttachLocation()
        }
        circularRevealDialog(false, dialogView, this@ChatAttachmentDialog)
    }

    private fun setDialogBackground() {
        if (::dialogView.isInitialized) {
            if (isKeyboardOpened) {
                dialogView.background =
                    ContextCompat.getDrawable(context, R.drawable.attachement_keyboard_background)
                val lp = FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT
                )
                lp.setMargins(0, 0, 0, 0)
                dialogView.layoutParams = lp
            } else {
                dialogView.background =
                    ContextCompat.getDrawable(context, R.drawable.attachment_background)
                val lp = FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT
                )
                lp.setMargins(context.resources.getDimensionPixelSize(R.dimen.margin_12), 0, context.resources.getDimensionPixelSize(R.dimen.margin_12), 0)
                dialogView.layoutParams = lp
            }
        }

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_OUTSIDE) {
            circularRevealDialog(false, dialogView, this)
            return true
        }
        return false
    }

    private fun circularRevealDialog(isExpand: Boolean, view: View, dialog: Dialog) {
        if (isExpand) transparentView.show()
        val cx = (attachment.left + attachment.right) / 2
        val cy = if (isKeyboardOpened) (attachment.top + attachment.bottom) / 2 else view.height

        val finalRadius = view.width
        val anim: Animator = ViewAnimationUtils.createCircularReveal(
            view, cx, cy, if (isExpand) 0f else finalRadius.toFloat(),
            if (isExpand) finalRadius.toFloat() else 0f
        )
        anim.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) { /*No Implementation Needed*/
            }

            override fun onAnimationEnd(animation: Animator) {
                if (!isExpand) {
                    dialog.dismiss()
                    view.visibility = View.INVISIBLE
                    transparentView.gone()
                }
            }

            override fun onAnimationCancel(animation: Animator) { /*No Implementation Needed*/
            }

            override fun onAnimationRepeat(animation: Animator) { /*No Implementation Needed*/
            }

        })
        anim.duration = 300
        if (isExpand)
            view.visibility = View.VISIBLE
        anim.start()
    }

    fun showDialog(isKeyboardOpened: Boolean, screenHeight: Int, isGroupMemberListShowing:Boolean) {
        this.isKeyboardOpened = isKeyboardOpened
        this.screenHeight = screenHeight
        this.isGroupMemberListShowing = isGroupMemberListShowing
        updateWindowView()
        show()
        initializeAttachments()
    }

    private fun updateWindowView() {
        if (isKeyboardOpened) {
            val lp: WindowManager.LayoutParams = window!!.attributes
            lp.width = WindowManager.LayoutParams.MATCH_PARENT
            val rectf = Rect()
            footerBottom.getGlobalVisibleRect(rectf)
            lp.height = screenHeight  - rectf.centerY()
            lp.gravity = Gravity.BOTTOM
            lp.y = 0
            lp.dimAmount = 0f
        } else {
            val lp: WindowManager.LayoutParams = window!!.attributes
            lp.width = WindowManager.LayoutParams.MATCH_PARENT
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT
            lp.gravity = Gravity.BOTTOM
            val rectf = Rect()
            footerDivider.getGlobalVisibleRect(rectf)
            val y = rectf.centerY()
            lp.y = if (!isGroupMemberListShowing) screenHeight - y + AndroidUtils.dp(
                5f,
                context
            ) else 295
            lp.dimAmount = 0f
        }
        setDialogBackground()
    }
}

enum class AttachmentTypes {
    DOCUMENT, CAMERA, GALLERY, AUDIO, CONTACT, LOCATION
}