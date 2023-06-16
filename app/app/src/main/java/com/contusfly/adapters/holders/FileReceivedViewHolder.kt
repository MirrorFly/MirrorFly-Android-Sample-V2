package com.contusfly.adapters.holders

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatTextView
import com.contusfly.R

/**
 * This class is used to provide data and views in a [RecyclerView] for the file-type messages
 * received in the chat conversation window.
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 3.0
 */
class FileReceivedViewHolder(val mainView: View) : SenderNameHolder(mainView) {

    var spaceView: View = mainView.findViewById(R.id.space_view)
    var fileReceivedViewLayout: View = mainView.findViewById(R.id.layout_file_received_view)
    var fileDownloadLayout: RelativeLayout = mainView.findViewById(R.id.layout_file_download)
    var fileCancelLayout: RelativeLayout = mainView.findViewById(R.id.layout_file_cancel)
    var filePictureImage: ImageView = mainView.findViewById(R.id.image_file_picture)
    var fileNameText: AppCompatTextView = mainView.findViewById(R.id.text_file_name)
    var fileDownloadProgress: ProgressBar = mainView.findViewById(R.id.progress_file_download)
    val fileDownloadProgressBuffer: ProgressBar = mainView.findViewById(R.id.progress_file_download_buffer)
    var fileSizeText: AppCompatTextView = mainView.findViewById(R.id.text_file_size)
    var fileFavoriteImage: ImageView = mainView.findViewById(R.id.image_file_favorite)
    var fileReceivedTimeText: AppCompatTextView = mainView.findViewById(R.id.text_file_received_time)
    var imgFileForward: ImageView? = mainView.findViewById(R.id.send_img_forward)
    val viewDiver: View? = mainView.findViewById(R.id.view_divider)

}