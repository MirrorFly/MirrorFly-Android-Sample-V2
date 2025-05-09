package com.contusfly.quickShare

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.R
import com.contusfly.databinding.FragmentFilesDialogBinding
import com.contusfly.models.FileObject
import com.contusfly.views.CustomRecyclerView
import com.mirrorflysdk.utils.Utils
import java.util.*

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class FilesDialogFragment : DialogFragment() {

    private lateinit var filesDialogBinding: FragmentFilesDialogBinding

    private var filesList: CustomRecyclerView? = null
    private var fileListAdapter: FileListAdapter? = null
    private var mainList: ArrayList<FileObject>? = null
    private var mCallback: DialogFragmentInterface? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        filesDialogBinding = FragmentFilesDialogBinding.inflate(inflater, container, false)
        mainList = requireArguments().getParcelableArrayList("filelist")
        Log.d("FILE_LIST_FDF", Utils.getGSONInstance().toJson(mainList))
        fileListAdapter = FileListAdapter(requireContext())
        fileListAdapter!!.setDataList(mainList)
        initView(filesDialogBinding)
        return filesDialogBinding.root
    }

    private fun initView(filesBinding: FragmentFilesDialogBinding) {
        filesList = filesBinding.fileList
        filesList!!.layoutManager = LinearLayoutManager(context)
        filesList!!.adapter = fileListAdapter
        filesList!!.addItemDecoration(
            DividerItemDecoration(
                filesList!!.context,
                DividerItemDecoration.VERTICAL
            )
        )
        if (mainList!!.size == 1) filesBinding.okBtn.text = getString(R.string.action_remove)
        filesBinding.okBtn.setOnClickListener(View.OnClickListener { _: View? ->
            for (fileObject in mainList!!) {
                mCallback!!.removeFile(fileObject)
            }
            dismiss()
        })
        filesBinding.cancelBtn.setOnClickListener (View.OnClickListener { _: View? -> mCallback!!.exitShare() })
        enableSwipeToDelete()
    }

    private fun enableSwipeToDelete() {
        val swipeToDeleteCallback: SwipeToDeleteCallback = object : SwipeToDeleteCallback(requireContext()) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, i: Int) {
                val position = viewHolder.layoutPosition
                mCallback!!.removeFile(mainList!![position])
                fileListAdapter!!.removeItem(position)
                if (mainList!!.isEmpty()) {
                    dismiss()
                }
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(filesList)
    }

    companion object {
        /**
         * The constructor used to create and initialize a new instance of this class object, with the
         * specified initialization parameters.
         *
         * @return a new object created by calling the constructor of this object representation.
         */
        @JvmStatic
        fun newInstance(mainList: List<FileObject>?): FilesDialogFragment {
            val myFragment = FilesDialogFragment()
            val args = Bundle()
            args.putParcelableArrayList("filelist", mainList as ArrayList<out Parcelable?>?)
            myFragment.arguments = args
            return myFragment
        }
    }

    interface DialogFragmentInterface {
        fun removeFile(fileObject: FileObject?)
        fun exitShare()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mCallback = try {
            context as? DialogFragmentInterface ?: throw ClassCastException("$context must implement OnHeadlineSelectedListener")
        } catch (e: ClassCastException) {
            throw ClassCastException("$context must implement OnHeadlineSelectedListener")
        }
    }
}