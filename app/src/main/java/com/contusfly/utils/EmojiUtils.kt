package com.contusfly.utils

import android.content.Context
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.BackgroundColorSpan
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.emoji.widget.EmojiAppCompatTextView
import com.contusfly.R
import com.contusfly.views.CustomTextView
import com.contusfly.views.MessageTextView
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.utils.Utils
import java.text.BreakIterator

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
object EmojiUtils {

    /**
     * Sets the emoji text after decode the UTF-8 method.
     *
     * @param textView The instance of the CustomTextView
     * @param text     The text to set in the view
     */
    fun setEmojiText(textView: TextView, text: String?) {
        try {
            textView.text = Utils.getUtfDecodedText(text)
        } catch (e: Exception) {
            textView.text = text
            LogMessage.e(e)
        }
    }

    /**
     * Sets the emoji text after decode the UTF-8 method.
     *
     * @param txtView The instance of the TextView
     * @param text     The text to set in the view
     */
    fun setEllipsisText(txtView: TextView, text: String?) {
        txtView.text = Utils.getUtfDecodedText(text)
        txtView.viewTreeObserver.addOnGlobalLayoutListener { ChatMessageUtils.fixEmojiAfterEllipses(txtView) }
    }

    /**
     * Sets the emoji text after decode the UTF-8 method.
     *
     * @param textView The instance of the MessageTextView
     * @param text     The text to set in the view
     */
    fun setMessageTextWithEllipsis(textView: MessageTextView, text: String) {
        textView.text = text
    }

    /**
     * Sets the emoji text after decode the UTF-8 method and highlight the search text.
     *
     * @param textView   The instance of the CustomTextView
     * @param text       The text to set in the view
     * @param startIndex Starting position to highlight the text
     * @param stopIndex  Ending position to highlight the text
     */
    fun setEmojiTextAndHighLightSearchText(textView: CustomTextView, text: String?, startIndex: Int, stopIndex: Int) {
        try {
            val userText = Utils.getUtfDecodedText(text!!.replace("%", "%25"))
            val textToHighlight: Spannable = SpannableString(userText)
            if (startIndex != -1 && stopIndex != -1) textToHighlight.setSpan(ForegroundColorSpan(Color.BLUE), startIndex, stopIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            textView.text = textToHighlight
        } catch (e: java.lang.Exception) {
            LogMessage.e(e)
        }
    }

    fun setEmojiTextAndHighLightSearchText(context: Context?, textView: TextView,
                                           text: String?, startIndex: Int, stopIndex: Int) {
        try {
            val userText = Utils.getUtfDecodedText(text)
            val textToHighlight: Spannable = SpannableString(userText)
            if (startIndex != -1 && stopIndex != -1) textToHighlight.setSpan(BackgroundColorSpan(ContextCompat.getColor(context!!, R.color.search_highlight)),
                    startIndex, stopIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            textView.text = textToHighlight
        } catch (e: java.lang.Exception) {
            LogMessage.e(e)
        }
    }

    fun setEmojiTextAndHighLightSearchTextForMention(context: Context?, textView: TextView,
                                           text: String?, startIndex: Int, stopIndex: Int,mentionedUserName: SpannableStringBuilder
    ) {
        try {
            val deliMeter="@"
            val userText = Utils.getUtfDecodedText(text)
            val textToHighlight: Spannable = SpannableString(userText)

            val mentionedUserStringArray = mentionedUserName.split("[\\n$deliMeter]".toRegex()).toTypedArray()

            for (i in 1 until  mentionedUserStringArray.size){
                val indexElement = mentionedUserStringArray[i]
                val index = textToHighlight.indexOf(indexElement)
                textToHighlight.setSpan(ForegroundColorSpan(ContextCompat.getColor(context!!, R.color.color_blue)),
                    index-1, index+indexElement.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
            if (startIndex != -1 && stopIndex != -1) textToHighlight.setSpan(BackgroundColorSpan(ContextCompat.getColor(context!!, R.color.search_highlight)),
                startIndex, stopIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            textView.text = SpannableStringBuilder.valueOf(textToHighlight)
        } catch (e: java.lang.Exception) {
            LogMessage.e(e)
        }
    }

    fun setEmojiTextAndHighLightSearchContact(context: Context?, textView: TextView,
                                              text: String?, startIndex: Int, stopIndex: Int) {
        try {
            var profileName:String? = try {
                Utils.getUtfDecodedText(text)
            }catch (e: java.lang.Exception){
                text
            }
            val textToHighlight: Spannable = SpannableString(profileName)
            if (startIndex != -1 && stopIndex != -1)
                textToHighlight.setSpan(ForegroundColorSpan(ContextCompat.getColor(context!!, com.contus.call.R.color.blue)), startIndex, stopIndex, Spannable.SPAN_INTERMEDIATE)
            textView.text = textToHighlight
        } catch (e: java.lang.Exception) {
            LogMessage.e(e)
        }
    }


    fun setEmojiTextAndHighLightSearchContact(context: Context?, textView: EmojiAppCompatTextView,
                                           text: String?, startIndex: Int, stopIndex: Int) {
        try {
            var userText:String?
            try {
                userText = Utils.getUtfDecodedText(text)
            }catch (e: java.lang.Exception){
                userText = text
            }
            val textToHighlight: Spannable = SpannableString(userText)
            if (startIndex != -1 && stopIndex != -1)
                textToHighlight.setSpan(ForegroundColorSpan(ContextCompat.getColor(context!!, com.contus.call.R.color.blue)), startIndex, stopIndex, Spannable.SPAN_INTERMEDIATE)
            textView.text = textToHighlight
        } catch (e: java.lang.Exception) {
            LogMessage.e(e)
        }
    }

    /**
     * Sets the emoji text after decode the UTF-8 method and highlight the search text.
     *
     * @param textView   The instance of the CustomTextView
     * @param text       The text to set in the view
     * @param startIndex Starting position to highlight the text
     * @param stopIndex  Ending position to highlight the text
     */
    fun setMediaTextHighLightSearched(context: Context?, textView: TextView, text: String?, startIndex: Int, stopIndex: Int) {
        try {
            val userText = Utils.getUtfDecodedText(text)
            val textToHighlight: Spannable = SpannableString(userText)
            if (startIndex != -1 && stopIndex != -1) textToHighlight.setSpan(BackgroundColorSpan(ContextCompat.getColor(context!!, R.color.search_highlight)),
                    startIndex, stopIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            textView.text = textToHighlight
        } catch (e: java.lang.Exception) {
            LogMessage.e(e)
        }
    }

    fun setMediaTextHighLightSearchedForMention(context: Context?, textView: TextView, text: String?, startIndex: Int, stopIndex: Int, mentionedUserName: SpannableStringBuilder) {
        try {
            val deliMeter="@"
            val userText = Utils.getUtfDecodedText(text)
            val textToHighlight: Spannable = SpannableString(userText)
            val mentionedUserStringArray = mentionedUserName.split("[\\n$deliMeter]".toRegex()).toTypedArray()
            for (i in 1 until  mentionedUserStringArray.size){
                if(mentionedUserStringArray[i].isNotEmpty()) {
                    val indexElement = mentionedUserStringArray[i]
                    val index = textToHighlight.indexOf(indexElement)
                    textToHighlight.setSpan(
                        ForegroundColorSpan(ContextCompat.getColor(context!!, R.color.color_blue)),
                        index - 1, index + indexElement.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                }
            }
            if (startIndex != -1 && stopIndex != -1) textToHighlight.setSpan(BackgroundColorSpan(ContextCompat.getColor(context!!, R.color.search_highlight)),
                startIndex, stopIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

            textView.text = SpannableStringBuilder.valueOf(textToHighlight)
        } catch (e: java.lang.Exception) {
            LogMessage.e(e)
        }
    }

    /**
     * Sets the emoji text after decode the UTF-8 method and highlight the search text.
     *
     * @param textView   The instance of the CustomTextView
     * @param text       The text to set in the view
     * @param startIndex Starting position to highlight the text
     * @param stopIndex  Ending position to highlight the text
     */
    fun setEmojiTextAndHighLightSearchText(textView: EmojiAppCompatTextView, text: String?, startIndex: Int, stopIndex: Int) {
        try {
            val userText = Utils.getUtfDecodedText(text)
            val textToHighlight: Spannable = SpannableString(userText)
            if (startIndex != -1 && stopIndex != -1) textToHighlight.setSpan(ForegroundColorSpan(Color.BLUE), startIndex, stopIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            textView.text = textToHighlight
        } catch (e: java.lang.Exception) {
            LogMessage.e(e)
        }
    }

    /**
     * Sets the emoji text after decode the UTF-8 method and highlight the search text.
     *
     * @param textView   The instance of the CustomTextView
     * @param text       The text to set in the view
     * @param startIndex Starting position to highlight the text
     * @param stopIndex  Ending position to highlight the text
     */
    fun setTextHighLightSearched(textView: EmojiAppCompatTextView, text: String?, startIndex: Int, stopIndex: Int) {
        try {
            val userText = Utils.getUtfDecodedText(text)
            val textToHighlight: Spannable = SpannableString(userText)
            if (startIndex != -1 && stopIndex != -1) textToHighlight.setSpan(ForegroundColorSpan(Color.BLUE), startIndex, stopIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            textView.text = textToHighlight
        } catch (e: java.lang.Exception) {
            LogMessage.e(e)
        }
    }

    /**
     * Count Emoji & text character number. Available with JDK 8 or higher
     *
     * @param value
     * @return
     */


    fun getGraphemeLength(value: String?): Int {
        val it = BreakIterator.getCharacterInstance()
        it.setText(value)
        var count = 0
        while (it.next() != BreakIterator.DONE) {
            count++
        }
        return count
    }


}