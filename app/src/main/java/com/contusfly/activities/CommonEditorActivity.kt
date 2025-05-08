package com.contusfly.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import com.contusfly.*
import com.contusfly.databinding.ActivityCommonEditorBinding
import com.contusfly.utils.Constants
import com.contusfly.utils.CustomLengthFilter
import com.contusfly.utils.EmojiHandler
import com.contusfly.utils.UserInterfaceUtils
import com.mirrorflysdk.AppUtils
import com.mirrorflysdk.utils.RequestCode
import com.mirrorflysdk.utils.Utils
import com.mirrorflysdk.views.CustomToast
import io.github.rockerhieu.emojicon.EmojiconGridFragment
import io.github.rockerhieu.emojicon.EmojiconsFragment
import io.github.rockerhieu.emojicon.emoji.Emojicon

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class CommonEditorActivity : BaseActivity(), View.OnClickListener,
        EmojiconsFragment.OnEmojiconBackspaceClickedListener, EmojiconGridFragment.OnEmojiconClickedListener {

    private lateinit var commonEditorBinding: ActivityCommonEditorBinding

    private val TAG = CommonEditorActivity::class.java.simpleName

    companion object {

        /**
         * Max count of text length
         */
        private var maxCount = 0

        /**
         * The text view to show the remaining count of status
         */
        @SuppressLint("StaticFieldLeak")
        private var statusCount: TextView? = null

        /**
         * The editor text view here can handle the typing text
         */
        private lateinit var editorEditText: AppCompatEditText

        private lateinit var viewFooter: LinearLayout
    }

    /**
     * Instance of the EmojiHandler to access the emoji and text keypad
     */
    private lateinit var emojiHandler: EmojiHandler

    /**
     * Type of editing screen from the activity
     */
    private var type = 0

    /**
     * Store onclick time to avoid double click
     */
    private var lastClickTime: Long = 0

    private var groupJid: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        commonEditorBinding = ActivityCommonEditorBinding.inflate(layoutInflater)
        setContentView(commonEditorBinding.root)

        setSupportActionBar(commonEditorBinding.toolBar.toolbar)
        supportActionBar?.title = getString(R.string.title_user_name)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        UserInterfaceUtils.initializeCustomToolbar(this, commonEditorBinding.toolBar.toolbar)
        commonEditorBinding.toolBar.toolbar.navigationIcon?.applySrcInColorFilter(ContextCompat.getColor(this, R.color.dashboard_toolbar_text_color))

        getIntentData()
        clickListeners()
        setInitialData()
    }

    /*
    * Set Initial Data */
    @SuppressLint("ClickableViewAccessibility")
    private fun setInitialData() {
        statusCount = commonEditorBinding.statusCount
        emojiHandler = EmojiHandler(this)
        emojiHandler.setIconImageView(commonEditorBinding.imageSmiley)

        editorEditText = commonEditorBinding.editStatus
        viewFooter = commonEditorBinding.viewFooter
        editorEditText.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxCount))
        editorEditText.setOnTouchListener { _: View?, _: MotionEvent? ->
            if (emojiHandler.isEmojiShowing) {
                emojiHandler.hideEmoji()
            }
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
            false
        }
        emojiHandler.attachKeyboardListeners(editorEditText)
        emojiHandler.setHandledFrom(TAG)
        val fa: Array<CustomLengthFilter?> = arrayOfNulls(1)
        /**
         * Set maximum count for an text editor in text filter
         */
        /**
         * Set maximum count for an text editor in text filter
         */
        fa[0] = CustomLengthFilter(maxCount)
        editorEditText.filters = fa
        editorEditText.addTextChangedListener(EditTextChangeListener())
        setMsg(intent.getStringExtra(Constants.MSG_TYPE_TEXT), intent.getStringExtra(Constants.HINT))
    }

    /*
    * Get Intent Data from Activity */
    private fun getIntentData() {
        val intent = intent
        if (intent != null) {
            supportActionBar?.title = Utils.returnEmptyStringIfNull(intent.getStringExtra(Constants.TITLE))
            type = intent.getIntExtra(Constants.TYPE, 0)
            maxCount = intent.getIntExtra(Constants.TEXT_COUNT, Constants.MAX_NAME_COUNT)
            groupJid = intent.getStringExtra(Constants.USER_JID) ?: Constants.EMPTY_STRING
            if (intent.hasExtra(Constants.TEXT_COUNT)) maxCount = intent.getIntExtra(Constants.TEXT_COUNT, Constants.MAX_TEXT_COUNT)
            else if (type == Constants.GROUP_NAME_UPDATE) maxCount = intent.getIntExtra(Constants.TEXT_COUNT, Constants.MAX_GROUP_NAME_COUNT)
        }
    }

    /*
    * Click Listeners for Views */
    private fun clickListeners() {
        commonEditorBinding.textOk.setOnClickListener(this)
        commonEditorBinding.textCancel.setOnClickListener(this)
        commonEditorBinding.rootView.setOnClickListener(this)
        commonEditorBinding.imageSmiley.setOnClickListener(this)
        commonEditorBinding.toolBar.toolbar.setOnClickListener(this)
    }

    /**
     * Sets the Message status encoded text so we need to decoded the text
     *
     * @param status Status of the Edit text
     * @param hint   Hint of the Edit text
     */
    private fun setMsg(status: String?, hint: String?) {
        editorEditText.hint = Utils.returnEmptyStringIfNull(hint)
        editorEditText.setText(Utils.returnEmptyStringIfNull(status))
        editorEditText.setSelection(editorEditText.text!!.length)
    }

    override fun onClick(v: View?) {
        /*
         * Store onclick time to avoid double click on cancel and ok buttons
         * */

        /*
         * Store onclick time to avoid double click on cancel and ok buttons
         * */
        if (SystemClock.elapsedRealtime() - lastClickTime < 1000) return
        lastClickTime = SystemClock.elapsedRealtime()

        when(v) {
            commonEditorBinding.textCancel -> {
                setResult(RESULT_CANCELED)
                finish()
            }
            commonEditorBinding.textOk -> {
                validateAndFinish()
            }
            commonEditorBinding.imageSmiley -> {
                emojiHandler.setKeypad(editorEditText)
            }
            commonEditorBinding.rootView,commonEditorBinding.toolBar.toolbar -> {
                if (emojiHandler.isEmojiShowing) emojiHandler.hideEmoji()
                val view = currentFocus
                Utils.hideSoftInput(this, view)
                editorEditText.clearFocus()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                if (emojiHandler.isEmojiShowing) {
                    emojiHandler.hideEmoji()
                    finish()
                }
                else super.onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        if (editorEditText.requestFocus()){
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        }
        if (emojiHandler.isEmojiShowing) emojiHandler.hideEmoji()
    }

    override fun onRestart() {
        super.onRestart()
        if (editorEditText.hasFocus()) {
            val inputMethodManager = this.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
        }
    }

    override fun onPause() {
        super.onPause()
        val inputMethodManager = this.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        val view = this.currentFocus
        /**
         * Hide the soft keypad if opened
         */
        /**
         * Hide the soft keypad if opened
         */
        if (inputMethodManager.isActive && view != null) inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    /*
    * Validate the User inputs and finish the Activity */
    private fun validateAndFinish() {
        val text = editorEditText.text.toString().trim { it <= ' ' }
        var isValid = false
        when (type) {
            RequestCode.STATUS_UPDATE -> {
                if (AppUtils.isNetConnected(this)) {
                    if (text.isNotEmpty()) isValid = true
                    else CustomToast.show(this, getString(R.string.error_status_empty))
                } else {
                    CustomToast.show(this, getString(R.string.msg_no_internet))
                    finish()
                }
            }
            Constants.GROUP_NAME_UPDATE -> isValid = true
            RequestCode.NAME_UPDATE -> isValid = updateName(text)
            else -> validateMoreAndFinish(text)
        }
        if (isValid) {
            setResult(RESULT_OK, Intent().putExtra(Constants.TITLE, text))
            finish()
        }
    }

    /**
     * Validate and finish the user busy status
     *
     * @param text User edit field text value
     */
    private fun validateMoreAndFinish(text: String) {
        var isValid = false
        if (type == Constants.TYPE_USER_BUSY_STATUS) {
            if(!AppUtils.isNetConnected(context)){
                CustomToast.show(this, getString(R.string.error_check_internet))
                return
            }
            if (text.isNotEmpty()) isValid = true else CustomToast.show(this, getString(R.string.error_busy_status_empty))
        }
        if (isValid) {
            setResult(RESULT_OK, Intent().putExtra(Constants.TITLE, text))
            finish()
        }
    }

    /**
     * Update the name from the Profile view
     *
     * @param text Name of the user
     * @return Boolean, True if the Name is valid
     */
    private fun updateName(text: String): Boolean {
        if (text.isEmpty()) {
            CustomToast.show(this, getString(R.string.error_username_empty))
            return false
        } else if (!profileNameCharValidation(text)) {
            CustomToast.show(this, getString(R.string.error_username_too_short))
            return false
        }
        return true
    }

    override fun onEmojiconBackspaceClicked(v: View?) {
        EmojiconsFragment.backspace(editorEditText)
    }

    override fun onEmojiconClicked(emojicon: Emojicon?) {
        EmojiconsFragment.input(editorEditText, emojicon)
    }

    override fun onBackPressed() {
        /**
         * Checks if emoji keypad showing
         */
        if (emojiHandler.isEmojiShowing) emojiHandler.hideEmoji()
        else super.onBackPressed()
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        return super.dispatchTouchEvent(ev)
    }

    /**
     * When an object of a type is attached to an Editable, its methods will
     * be called when the text is changed.
     */
    private class EditTextChangeListener : TextWatcher {
        private var beforeChanged: String? = null
        var start = 0
        var count = 0
        var after = 0

        /**
         * This method is called to notify you that, within `s`,
         * the `count` characters beginning at `start`
         * are about to be replaced by new text with length `after`.
         * It is an error to attempt to make changes to `s` from
         * this callback.
         */
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            beforeChanged = s.toString()
            this.start = start
            this.count = count
            this.after = after
        }

        /**
         * This method is called to notify you that, within `s`,
         * the `count` characters beginning at `start`
         * have just replaced old text that had length `before`.
         * It is an error to attempt to make changes to `s` from
         * this callback.
         */
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            beforeChanged = s.toString()
            if (s.toString().trim({ it <= ' ' }).isEmpty())
            {
                viewFooter.visibility = View.GONE
            }
            else
            {
                viewFooter.visibility = View.VISIBLE
            }

        }

        /**
         * This method is called to notify you that, somewhere within
         * `s`, the text has been changed.
         * It is legitimate to make further changes to `s` from
         * this callback, but be careful not to get yourself into an infinite
         * loop, because any changes you make will cause this method to be
         * called again recursively.
         * (You are not told where the change took place because other
         * afterTextChanged() methods may already have made other changes
         * and invalidated the offsets.  But if you need to know here,
         * you can use [Spannable.setSpan] in [.onTextChanged]
         * to mark your place and then look up from here where the span
         * ended up.
         */
        override fun afterTextChanged(s: Editable) {
            val textLength = EmojiHandler.getEmojiCharLength(editorEditText.text.toString())
            val length: Int = maxCount - textLength
            statusCount?.text = length.toString()
            /**
             * Checks if the text length leads maximum character length
             */
            if (textLength > maxCount) {
                beforeChanged = s.toString()
                val sortedString = beforeChanged!!.dropLast(textLength - maxCount)
                editorEditText.setText(sortedString)
                editorEditText.setSelection(editorEditText.text.toString().length)
            }
        }
    }

    override fun onAdminBlockedOtherUser(jid: String, type: String, status: Boolean) {
        super.onAdminBlockedOtherUser(jid, type, status)
        if (groupJid == jid && status) {
            showToast(getString(R.string.group_block_message_label))
            val dashboardIntent = Intent(applicationContext, DashboardActivity::class.java)
            dashboardIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(dashboardIntent)
            finish()
        }
    }

    override fun onSuperAdminDeleteGroup(groupJid: String, groupName: String) {
        super.onSuperAdminDeleteGroup(groupJid, groupName)
        if (this.groupJid == groupJid) {
            CustomToast.show(context, getString(R.string.deleted_by_super_admin, groupName))
            startDashboardActivity(this)
            finish()
        }
        clearDeletedGroupChatNotification(groupJid, context)
    }
}