package com.contusfly.adapters.holders

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatTextView
import com.contusfly.R

/**
 * This class is used to provide data and views in a [RecyclerView]
 * for the file-type messages posted in the chat conversation window.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 3.0
 */
class FileSentViewHolder(val mainView: View) : SenderNameHolder(mainView) {

    /**
     * File Name space view
     */
    var spaceView: View = mainView.findViewById(R.id.space_view)

    /**
     * view to display the file sent layout
     */
    var fileSentViewLayout: View = mainView.findViewById(R.id.layout_file_sent_view)

    /**
     * view to display the upload layout
     */
    var fileUploadViewLayout: RelativeLayout = mainView.findViewById(R.id.layout_file_upload)

    /**
     * view to display the carbon download layout
     */
    var fileCarbonDownloadView: RelativeLayout? = mainView.findViewById(R.id.layout_file_carbon_retry)

    /**
     * view to display the progress layout
     */
    var fileUploadCancelLayout: RelativeLayout = mainView.findViewById(R.id.layout_file_progress)

    /**
     * ImageView display the file picture
     */
    var filePictureImage: ImageView = mainView.findViewById(R.id.image_file_picture)

    /**
     * CustomTextView display file Name text
     */
    var fileNameText: AppCompatTextView = mainView.findViewById(R.id.text_file_name)

    /**
     * Progress dialog
     */
    var fileUploadProgress: ProgressBar = mainView.findViewById(R.id.progress_file_upload)

    /**
     * Progress buffer dialog
     */
    val fileUploadProgressBuffer: ProgressBar = mainView.findViewById(R.id.progress_file_upload_buffer)

    /**
     * CustomTextView display the file size text
     */
    var fileSizeText: AppCompatTextView = mainView.findViewById(R.id.text_file_size)

    /**
     * ImageView display the file favourite Image
     */
    var fileFavoriteImage: ImageView = mainView.findViewById(R.id.image_file_favorite)

    /**
     * ImageView display the file status Image
     */
    var fileStatusImage: ImageView = mainView.findViewById(R.id.image_file_status)

    /**
     * CustomTextView display the file sent time text
     */
    var fileSentTimeText: AppCompatTextView = mainView.findViewById(R.id.text_file_sent_time)

    /**
     * ImageView display the file status Image
     */
    val imgFileForward: ImageView? = mainView.findViewById(R.id.send_img_forward)

    val viewDiver: View? = mainView.findViewById(R.id.view_divider)

}