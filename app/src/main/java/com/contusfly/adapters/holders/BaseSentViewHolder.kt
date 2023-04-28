package com.contusfly.adapters.holders

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.emoji.widget.EmojiAppCompatTextView
import com.contusfly.R
import com.contusfly.views.RoundRectCornerImageView
import io.github.rockerhieu.emojicon.EmojiconTextView

open class BaseSentViewHolder(view: View) : SenderNameHolder(view) {
    /**
     * Sender View of the Chat
     */
    val viewSender: View = view.findViewById(R.id.view_chat_send_img)

    /**
     * Time of the chat
     */
    val txtSendTime: AppCompatTextView = view.findViewById(R.id.text_message_sent_time)
    /**
     * Gets {@see #imgSentStarred}
     *
     * @return [.imgSentStarred]
     */
    /**
     * Image starred
     */
    val imgSentStarred: ImageView = view.findViewById(R.id.ic_star)

    val imgSentBalloon: ImageView = view.findViewById(R.id.ic_balloon)

    /**
     * Uploading, downloading progress var
     */
    val progressSender: ProgressBar = view.findViewById(R.id.progress_send_image)

    /**
     * Image view of the sender
     */
    val imageSenderImg: RoundRectCornerImageView = view.findViewById(R.id.image_send_item)

    val imageSenderLayout: RelativeLayout? = view.findViewById(R.id.view_chat_send_img_lay)

    /**
     * Delivery Status of the message
     */
    val imgSenderStatus: ImageView = view.findViewById(R.id.image_message_status)

    /**
     * Size of the chat image
     */
    val txtImgSize: AppCompatTextView = view.findViewById(R.id.text_file_size)

    /**
     * Size of the carbon chat image
     */
    val txtCarbonImgSize: AppCompatTextView = view.findViewById(R.id.text_file_size)

    /**
     * Retry image view
     */
    val txtRetryView: AppCompatTextView = view.findViewById(R.id.text_retry)

    /**
     * Chat view
     */
    val viewRowItem: View = view.findViewById(R.id.row_chat_image)

    /**
     * Cancel upload image view
     */
    val cancelUpload: ImageView = view.findViewById(R.id.img_upload_cancel)

    /**
     * Upload progress view
     */
    val viewUploadProgress: RelativeLayout = view.findViewById(R.id.view_send_upload_progress)

    /**
     * Space to add when the previous message is different
     */
    val space: View = view.findViewById(R.id.space_view)

    /**
     * View sent chat caption
     */
    val viewSendImageCaption: View = view.findViewById(R.id.view_sent_image_caption)

    /**
     * Sent caption for image
     */
    val txtChatSentCaption: EmojiconTextView = viewSendImageCaption.findViewById(R.id.txt_caption_sent_chat)

    /**
     * Chat type of the view
     */
    val imgSentImageCaptionStatus: ImageView = viewSendImageCaption.findViewById(R.id.caption_image_send_status)

    /**
     * Sent caption for image
     */
    val txtSentCaptionTime: AppCompatTextView = viewSendImageCaption.findViewById(R.id.caption_text_send_image_time)

    /**
     * Sent caption star for image
     */
    val imgSentCaptionStar: ImageView = viewSendImageCaption.findViewById(R.id.ic_star)

    /**
     * The view sent carbon media download.
     */
    val viewSentCarbonDownload: View = view.findViewById(R.id.view_sent_carbon_download)

    /**
     * Uploading, downloading progress var
     */
    val progressSenderRotation: ProgressBar = view.findViewById(R.id.progress_send_image_rotate)

    /**
     * Image view for forward
     */
    val imgSentForward: ImageView? = view.findViewById(R.id.send_img_forward)

}