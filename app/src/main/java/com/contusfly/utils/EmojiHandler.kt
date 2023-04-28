package com.contusfly.utils

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.contusfly.R
import io.github.rockerhieu.emojicon.EmojiconsFragment

/**
 * This Class Which handle emoji keypad and the normal keypad
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
class EmojiHandler(context: AppCompatActivity) {
    /**
     * Fragment manager for inflating emoji fragment
     */
    private val fragmentManager: FragmentManager

    /**
     * Emoji is showing or not
     */
    var isEmojiShowing = false
        private set

    var isBlackTheme = false

    var mEmojiKeyBoardListener: EmojiKeyBoardListener? = null

    /**
     * Input manager to handle the soft keypad
     */
    private val inputManager: InputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

    /**
     * Instance of the emoji fragment view
     */
    private val fragmentCView: View

    /**
     * Icon for getting Emoji keypad
     */
    private var icon: ImageView? = null

    /**
     * This flag is used to inflate the fragment at first time
     */
    private var isInflated = false

    /**
     * Denotes the handling activity
     */
    private var handledFrom: String? = null

    /**
     * Set the icon image view which might be keypad or icon
     *
     * @param imageView Instance of the ImageView
     */
    fun setIconImageView(imageView: ImageView?) {
        icon = imageView
    }

    /**
     * Set the handling activity
     *
     * @param handledFrom Instance of the ImageView
     */
    fun setHandledFrom(handledFrom: String?) {
        this.handledFrom = handledFrom
    }

    /**
     * Set the keypad
     *
     * @param view View of the edit text
     */
    fun setKeypad(view: View) {
        val getemojishowing = !isEmojiShowing
        changeKeyboardLayout(getemojishowing, view)
    }

    /**
     * change the keypad based on Emoji or text
     *
     * @param showEmoticons    True if emoji keypad going to display
     * @param emojiconEditText View for the edit text
     */
    private fun changeKeyboardLayout(showEmoticons: Boolean, emojiconEditText: View) {
        if (showEmoticons) {
            inputManager.hideSoftInputFromWindow(emojiconEditText.windowToken, 0)
            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed({ viewEmoji() }, 100)
            icon!!.setImageResource(R.drawable.ic_input_keypad)
        } else {
            hideEmoji()
            emojiconEditText.requestFocus()
            inputManager.showSoftInput(emojiconEditText, 0)
        }
    }

    /**
     * View the emoji keypad
     */
    private fun viewEmoji() {
        if (!isInflated) {
            isInflated = true
            fragmentManager.beginTransaction()
                    .replace(R.id.emojicons, EmojiconsFragment.newInstance(false))
                    .commit()
        }
        isEmojiShowing = true
        mEmojiKeyBoardListener?.onKeyBoardStateChanged(isEmojiShowing)
        fragmentCView.visibility = View.VISIBLE
    }

    /**
     * View the emoji keypad
     */
    fun hideEmoji() {
        isEmojiShowing = false
        mEmojiKeyBoardListener?.onKeyBoardStateChanged(isEmojiShowing)
        fragmentCView.visibility = View.GONE
        if (isBlackTheme)
        icon!!.setImageResource(R.drawable.ic_emoji_black)
        else
        icon!!.setImageResource(R.drawable.ic_input_emoji)
    }

    /**
     * Attach the keypad listener to handle soft keypad is open state or close state
     *
     * @param yourEditText Edit text for the Emoji
     */
    fun attachKeyboardListeners(yourEditText: EditText) {
        yourEditText.setOnClickListener { view: View? ->
            if (isEmojiShowing) {
                fragmentCView.visibility = View.GONE
                if (isBlackTheme)
                    icon!!.setImageResource(R.drawable.ic_emoji_black)
                else
                    icon!!.setImageResource(R.drawable.ic_input_emoji)
                isEmojiShowing = false
                mEmojiKeyBoardListener?.onKeyBoardStateChanged(isEmojiShowing)
            }
        }
    }

    fun setIsBlackTheme(isBlackTheme: Boolean) {
        this.isBlackTheme = isBlackTheme
    }

    fun setEmojiKeyBoardListener(emojiKeyBoardListener: EmojiKeyBoardListener) {
        this.mEmojiKeyBoardListener = emojiKeyBoardListener
    }

    companion object {
        /**
         * Get the length of the string with emoji characters
         *
         * @param text Text for count
         * @return int length of the string
         */
        fun getEmojiCharLength(text: String): Int {
            var n = 0
            var i = 0
            while (i < text.length) {
                val cp = text.codePointAt(i)
                i += Character.charCount(cp)
                ++n
            }
            return n
        }
    }

    /**
     * Constructor of EmojiHandler for assigning and initializing the objects.
     *
     * @param context Instance of the Activity
     */
    init {
        fragmentCView = context.findViewById(R.id.emojicons)
        fragmentManager = context.supportFragmentManager
    }

    interface EmojiKeyBoardListener {
        fun onKeyBoardStateChanged(isOpened: Boolean)
    }
}