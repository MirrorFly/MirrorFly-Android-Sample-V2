package com.contusfly.groupmention

import android.content.Context
import com.contusfly.utils.ChatUtils.isMine
import android.text.SpannableStringBuilder
import android.text.SpannableString
import com.mirrorflysdk.api.models.ReplyParentChatMessage
import android.text.style.ClickableSpan
import android.text.TextPaint
import android.text.Spannable
import android.text.style.ForegroundColorSpan
import android.text.Spanned
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.contusfly.R
import com.contusfly.TAG
import com.contusfly.getDisplayName
import com.contusfly.views.RoundedBackgroundColorSpan
import com.mirrorflysdk.api.contacts.ProfileDetails
import com.mirrorflysdk.api.models.ChatMessage
import com.mirrorflysdk.flycommons.LogMessage
import com.mirrorflysdk.utils.ChatUtils.getUserFromJid
import java.util.ArrayList
import java.util.regex.Pattern

object MentionUtils {

    private val MENTION1 = Pattern.compile("[" + "@" + "]\\[(.*?)\\]") // @[?]


    fun formatMentionText(
        context: Context,
        message: ChatMessage,
        mentionClickable: Boolean
    ): SpannableStringBuilder {
        val texts = context.getString(R.string.chat_text)
        val textMessage = message.getMessageTextContent() + texts + texts
        return convertMessageToMentionFormat(message, textMessage, mentionClickable, context)
    }


    fun getMentionedUserId( context: Context,
                             mentionedMessage: ChatMessage,
                             mentionClickable: Boolean
    ): SpannableStringBuilder {
        val texts = context.getString(R.string.chat_text)
        val textMessage = mentionedMessage.messageTextContent + texts + texts
        return mentionUserIdSearchAvoid(mentionedMessage, textMessage, mentionClickable, context)
    }

    private fun mentionUserIdSearchAvoid(message: ChatMessage, mentionedText: String?,
                                         mentionClickable: Boolean, context: Context?): SpannableStringBuilder {
        var count = 0
        var displayText = SpannableStringBuilder(mentionedText)
        if (!message.mentionedUsersIds.isEmpty()) {
            val mentionedSpannableString = SpannableString(mentionedText)
            val matcher = MENTION1.matcher(mentionedSpannableString)
            val destinations: MutableList<CharSequence> = ArrayList()
            while (matcher.find()) {
                val mentionedUser = message.mentionedUsersIds[count]
                if (count < message.mentionedUsersIds.size && mentionedUser != null) {
                    val isMentionedCurrentUser = isMine(message.mentionedUsersIds[count].jid)
                    val trigger = "@"
                    val spannable: SpannableString
                    val name = mentionedUser.getDisplayName()
                    spannable = SpannableString(trigger + name)
                    setSpanColorText(spannable, context, isMentionedCurrentUser)
                    count = count + 1
                    setMentionClickable(mentionClickable, spannable)
                    destinations.add(spannable)
                }
            }

            var mentionedUserNames=""
            for (i in destinations){
                if (mentionedUserNames == "")
                    mentionedUserNames += i
                else
                    mentionedUserNames+= " $i"
            }

            displayText = SpannableStringBuilder.valueOf(mentionedUserNames)
        }
        return displayText
    }

    fun formatMentionTextForMediaCaption(
        context: Context,
        message: ChatMessage,
        caption: String,
        mentionClickable: Boolean
    ): SpannableStringBuilder {
        val texts = context.getString(R.string.chat_text)
        val mediaCaption = caption + texts + texts
        return convertMessageToMentionFormat(message, mediaCaption, mentionClickable, context)
    }


    fun formatUnSentMentionText(
        mentionedUsersIds: java.util.ArrayList<ProfileDetails?>?, mentionedText: String?,
        context: Context?,
        chatMessageEditText: MentionEditGroupText
    ): SpannableStringBuilder {
        val texts = context!!.getString(R.string.chat_text)
        val textMessage = mentionedText + texts + texts
        return convertMessageToUnsentMessageMentionFormat(mentionedUsersIds, textMessage, context,chatMessageEditText)
    }

    fun convertMessageToUnsentMessageMentionFormat(
        mentionedUsersIds: java.util.ArrayList<ProfileDetails?>?, mentionedText: String?,
        context: Context?,
        chatMessageEditText: MentionEditGroupText
    ): SpannableStringBuilder {
        var count = 0
        var displayText = SpannableStringBuilder(mentionedText)
        if (!mentionedUsersIds!!.isEmpty()) {
            val mentionedSpannableString = SpannableString(mentionedText)
            val matcher = MENTION1.matcher(mentionedSpannableString)
            val sources: MutableList<String> = ArrayList()
            val destinations: MutableList<CharSequence> = ArrayList()
            while (matcher.find()) {
                try {
                    val mentionedUser = mentionedUsersIds?.get(count)
                    if (count < mentionedUsersIds!!.size && mentionedUser != null) {
                        var mention = mentionedUsersIds.get(count)
                        val userId = getUserFromJid(mention!!.jid)
                        val mentionUser = MentionUser(userId)
                        var spannable = chatMessageEditText.unSentedMessageAddMentionSpan(
                            mention.getDisplayName(),
                            mentionUser
                        )
                        val isMentionedCurrentUser = isMine(mentionedUsersIds[count]!!.jid)
                        setSpanColorText(spannable, context, isMentionedCurrentUser)
                        count = count + 1
                        destinations.add(spannable)
                        sources.add(matcher.group(0))
                    }
                }catch (e:Exception){
                    LogMessage.e(TAG,e.toString())
                }
            }

            displayText = TextUtils.replace(
                mentionedSpannableString,
                sources.toTypedArray(),
                destinations.toTypedArray()
            )
        }
        return displayText
    }


    private fun convertMessageToMentionFormat(
        message: ChatMessage, mentionedText: String?,
        mentionClickable: Boolean, context: Context?
    ): SpannableStringBuilder {
        var count = 0
        var displayText = SpannableStringBuilder(mentionedText)
        if (!message.mentionedUsersIds.isEmpty()) {
            val mentionedSpannableString = SpannableString(mentionedText)
            val matcher = MENTION1.matcher(mentionedSpannableString)
            val sources: MutableList<String> = ArrayList()
            val destinations: MutableList<CharSequence> = ArrayList()
            while (matcher.find()) {
                val mentionedUser = message.mentionedUsersIds[count]
                if (count < message.mentionedUsersIds.size && mentionedUser != null) {
                    val isMentionedCurrentUser = isMine(message.mentionedUsersIds[count].jid)
                    val trigger = "@"
                    val spannable: SpannableString
                    val name = mentionedUser.getDisplayName()
                    spannable = SpannableString(trigger + name)
                    setSpanColorText(spannable, context, isMentionedCurrentUser)
                    count = count + 1
                    setMentionClickable(mentionClickable, spannable)
                    destinations.add(spannable)
                    sources.add(matcher.group(0))
                }
            }

            displayText = TextUtils.replace(
                mentionedSpannableString,
                sources.toTypedArray(),
                destinations.toTypedArray()
            )
        }
        return displayText
    }

    fun formatMentionTextForReplyParent(
        context: Context,
        replyParentMessage: ReplyParentChatMessage,
        mentionClickable: Boolean
    ): SpannableStringBuilder {
        var count = 0
        val texts = context.getString(R.string.chat_text)
        val replyMentionText = replyParentMessage.getMessageTextContent() + texts + texts
        var displayText = SpannableStringBuilder(replyMentionText)
        if (!replyParentMessage.mentionedUsersIds.isEmpty()) {
            val replyMentionSpannableString = SpannableString(replyMentionText)
            val matcher = MENTION1.matcher(replyMentionSpannableString)
            val replySources: MutableList<String> = ArrayList()
            val replyDestinations: MutableList<CharSequence> = ArrayList()
            while (matcher.find()) {
                val replyMentionUser = replyParentMessage.mentionedUsersIds[count]
                if (count < replyParentMessage.mentionedUsersIds.size && replyMentionUser != null) {
                    val isMentionedCurrentUser = isMine(
                        replyParentMessage.mentionedUsersIds[count].jid
                    )
                    val trigger = "@"
                    val spannable: SpannableString
                    val name = replyMentionUser.getDisplayName()
                    spannable = SpannableString(trigger + name)
                    setSpanColorText(spannable, context, isMentionedCurrentUser)
                    count = count + 1
                    setMentionClickable(mentionClickable, spannable)
                    replyDestinations.add(spannable)
                    replySources.add(matcher.group(0))
                }
            }

            displayText = TextUtils.replace(
                replyMentionSpannableString,
                replySources.toTypedArray(),
                replyDestinations.toTypedArray()
            )
        }
        return displayText
    }

    private fun setMentionClickable(mentionClickable: Boolean, spannable: SpannableString) {
        if (mentionClickable) {
            spannable.setSpan(object : ClickableSpan() {
                override fun onClick(widget: View) {
                    /** Not used for now  */
                }

                override fun updateDrawState(paint: TextPaint) {
                    paint.isUnderlineText = false
                }
            }, 0, spannable.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
    }

    fun getMentionTextForRecentChat(
        context: Context,
        message: ChatMessage
    ): SpannableStringBuilder {
        var count = 0
        val text = SpannableString(message.getMessageTextContent())
        var displayableText = SpannableStringBuilder(text)
        if (!message.mentionedUsersIds.isEmpty()) {
            val mentionSpannableString = SpannableString(text)
            val matchers = MENTION1.matcher(mentionSpannableString)
            val recentChatSources: MutableList<String> = ArrayList()
            val recentChatDestinations: MutableList<CharSequence> = ArrayList()
            while (matchers.find()) {
                val recentChatMentionUser = message.mentionedUsersIds[count]
                if (count < message.mentionedUsersIds.size && recentChatMentionUser != null) {
                    val trigger = "@"
                    val spannable = SpannableString(trigger + recentChatMentionUser.getDisplayName())
                    spannable.setSpan(
                        ForegroundColorSpan(ContextCompat.getColor(context, R.color.color_blue)),
                        0, spannable.length, Spanned.SPAN_EXCLUSIVE_INCLUSIVE
                    )
                    count += 1
                    recentChatDestinations.add(spannable)
                    recentChatSources.add(matchers.group(0))
                }
            }

            displayableText = TextUtils.replace(
                mentionSpannableString,
                recentChatSources.toTypedArray(),
                recentChatDestinations.toTypedArray()
            )
        }
        return displayableText
    }

    public fun setSpanColorText(
        spannableString: SpannableString,
        context: Context?,
        isMentionedCurrentUser: Boolean
    ) {
        if (!isMentionedCurrentUser) {
            spannableString.setSpan(
                ForegroundColorSpan(ContextCompat.getColor(context!!, R.color.color_blue)),
                0, spannableString.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        } else {
            spannableString.setSpan(
                RoundedBackgroundColorSpan(
                    ContextCompat.getColor(context!!, R.color.mention_tag_text_color),
                    ContextCompat.getColor(
                        context, R.color.mention_tag_bg_color
                    ),
                    ResourcesCompat.getFont(context, R.font.sf_ui_display_medium)!!
                ), 0, spannableString.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
    }
}