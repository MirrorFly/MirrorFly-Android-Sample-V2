package com.contusfly.adapters.holders

import android.view.View
import android.widget.*
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.emoji.widget.EmojiAppCompatTextView
import com.contusfly.R
import com.contusfly.views.RoundRectCornerImageView
import io.github.rockerhieu.emojicon.EmojiconTextView

open class BaseReceivedViewHolder(view: View) : SenderNameHolder(view) {
    /**
     * Gets {@see #imgStarred}
     *
     * @return [.imgStarred]
     */
    /**
     * Image starred
     */
    val imgStarred: ImageView = view.findViewById(R.id.ic_star_rv)

    /**
     * Receiver Chat view
     */
    val viewReceiver: View = view.findViewById(R.id.view_chat_rev_img)

    /**
     * time of the chat view
     */
    val txtRevTime: AppCompatTextView = view.findViewById(R.id.text_receive_time)

    /**
     * Size of the chat image
     */
    val txtImgSize: AppCompatTextView = view.findViewById(R.id.text_file_size)

    /**
     * Retry image view
     */
    val txtRetryView: AppCompatTextView = view.findViewById(R.id.text_receiver_retry)

    /**
     * Chat image
     */
    val imgRevImage: RoundRectCornerImageView = view.findViewById(R.id.image_receive_item)

    /**
     * The progress bar for download showing.
     */
    val progressRev: ProgressBar = view.findViewById(R.id.progress_image_receive)

    /**
     * The download progress buffer for download beginning.
     */
    val downloadProgressBuffer: ProgressBar = view.findViewById(R.id.download_progress_buffer)

    /**
     * The view download.
     */
    val viewDownload: View = view.findViewById(R.id.view_receive_download)

    /**
     * Chat view
     */
    val viewRowItem: View = view.findViewById(R.id.row_chat_image)

    /**
     * Cancel download image view
     */
    val cancelDownload: ImageView = view.findViewById(R.id.img_download_cancel)

    /**
     * Download progress view
     */
    val viewDownloadProgress: RelativeLayout = view.findViewById(R.id.view_receive_download_progress)

    /**
     * Space to add when the previous message is different
     */
    val space: View = view.findViewById(R.id.space_view)

    /**
     * View receiver chat caption
     */
    val viewRevImageCaption: View = view.findViewById(R.id.view_rev_image_caption)


    val imageRevLayout: RelativeLayout? = view.findViewById(R.id.view_receive_image)

    /**
     * Receiver caption for image
     */
    val txtRevChatCaption: EmojiconTextView = viewRevImageCaption.findViewById(R.id.txt_caption_rev_chat)

    /**
     * Sent caption for image
     */
    val txtRevCaptionTime: AppCompatTextView = viewRevImageCaption.findViewById(R.id.caption_text_receive_time)

    /**
     * Sent caption star for image
     */
    val txtRevCaptionStar: ImageView = viewRevImageCaption.findViewById(R.id.ic_star_rv)

    val txtTranslatedText: EmojiAppCompatTextView = viewRevImageCaption.findViewById(R.id.txt_caption_rev_chat_translated)

    val translatedlinearlayout: LinearLayout? = viewRevImageCaption.findViewById(R.id.translated_layout)

    val layoutTranslatedText: RelativeLayout = viewRevImageCaption.findViewById(R.id.rl_root_layout)

    val viewRevImageBalloon: ImageView = view.findViewById(R.id.ic_balloon)

    /**
     * Video view for forward
     */
    val receivedImageForward: ImageView? = view.findViewById(R.id.received_img_forward)

}