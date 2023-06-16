package com.contusfly.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.R
import com.contusfly.models.AttachmentMainModel


class AttachmentAdapter(private val attachmentMainModel: List<AttachmentMainModel>,
                        private val context: Context) : RecyclerView.Adapter<AttachmentAdapter.MyViewHolder>() {

    private var mListener1: RecyclerViewClickListenerType1? = null
    private var mListener2: RecyclerViewClickListenerType2? = null
    private var mListener3: RecyclerViewClickListenerType3? = null
    private var mListener4: RecyclerViewClickListenerType4? = null

    /**
     * Click listener for dialog elements
     */
    inner class MyViewHolder constructor(view: View) : RecyclerView.ViewHolder(view) {

        val cameralinearLayout: LinearLayout = view.findViewById(R.id.camera)
        val cameraTextView: TextView = view.findViewById(R.id.text_chat_camera)
        val cameraImageView: ImageView = view.findViewById(R.id.camera_attach)
        val videolinearLayout: LinearLayout = view.findViewById(R.id.video)
        val videoTextView: TextView = view.findViewById(R.id.text_chat_video)
        val videoImageView: ImageView = view.findViewById(R.id.video_attach)
        val gallerylinearLayout: LinearLayout = view.findViewById(R.id.gallery)
        val galleryTextView: TextView = view.findViewById(R.id.text_chat_gallery)
        val galleryImageView: ImageView = view.findViewById(R.id.gallery_attach)
        val locationlinearLayout: LinearLayout = view.findViewById(R.id.location)
        val locationTextView: TextView = view.findViewById(R.id.text_chat_location)
        val locationImageView: ImageView = view.findViewById(R.id.location_attach)

    }

    fun setmListener1(mListener1: RecyclerViewClickListenerType1?) {
        this.mListener1 = mListener1
    }

    fun setmListener2(mListener2: RecyclerViewClickListenerType2?) {
        this.mListener2 = mListener2
    }

    fun setmListener3(mListener3: RecyclerViewClickListenerType3?) {
        this.mListener3 = mListener3
    }

    fun setmListener4(mListener4: RecyclerViewClickListenerType4?) {
        this.mListener4 = mListener4
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): MyViewHolder {
        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        return MyViewHolder(layoutInflater.inflate(R.layout.attachment_view, viewGroup, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val attachmentMainModels = attachmentMainModel[position]
        holder.cameralinearLayout.setOnClickListener { v: View? -> mListener1!!.onItemClick1(v, position, attachmentMainModels.attachmentModels1.attachmentName) }
        holder.cameraTextView.text = attachmentMainModels.attachmentModels1.attachmentName
        holder.cameraImageView.setImageResource(attachmentMainModels.attachmentModels1.attachmentDrawable)
        holder.videolinearLayout.setOnClickListener { v: View? -> mListener2!!.onItemClick2(v, position, attachmentMainModels.attachmentModels2.attachmentName) }
        holder.videoTextView.text = attachmentMainModels.attachmentModels2.attachmentName
        holder.videoImageView.setImageResource(attachmentMainModels.attachmentModels2.attachmentDrawable)
        holder.gallerylinearLayout.setOnClickListener { v: View? -> mListener3!!.onItemClick3(v, position, attachmentMainModels.attachmentModels3.attachmentName) }
        holder.galleryTextView.text = attachmentMainModels.attachmentModels3.attachmentName
        holder.galleryImageView.setImageResource(attachmentMainModels.attachmentModels3.attachmentDrawable)
        holder.locationlinearLayout.setOnClickListener { v: View? -> mListener4!!.onItemClick4(v, position, attachmentMainModels.attachmentModels4.attachmentName) }
        holder.locationTextView.text = attachmentMainModels.attachmentModels4.attachmentName
        holder.locationImageView.setImageResource(attachmentMainModels.attachmentModels4.attachmentDrawable)
    }

    override fun getItemCount(): Int {
        return attachmentMainModel.size
    }

    /**
     * Listeners to get the click action on image item from recent chat view
     */
    @FunctionalInterface
    interface RecyclerViewClickListenerType1 {
        /**
         * Method for getting image item click action
         *
         * @param view     - Imageview
         * @param position - Itemview position
         */
        fun onItemClick1(view: View?, position: Int, selectedOption: String?)
    }

    @FunctionalInterface
    interface RecyclerViewClickListenerType2 {
        /**
         * Method for getting image item click action
         *
         * @param view     - Imageview
         * @param position - Itemview position
         */
        fun onItemClick2(view: View?, position: Int, selectedOption: String?)
    }

    @FunctionalInterface
    interface RecyclerViewClickListenerType3 {
        /**
         * Method for getting image item click action
         *
         * @param view     - Imageview
         * @param position - Itemview position
         */
        fun onItemClick3(view: View?, position: Int, selectedOption: String?)
    }

    @FunctionalInterface
    interface RecyclerViewClickListenerType4 {
        /**
         * Method for getting image item click action
         *
         * @param view     - Imageview
         * @param position - Itemview position
         */
        fun onItemClick4(view: View?, position: Int, selectedOption: String?)
    }

}