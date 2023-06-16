package com.contusfly.mediapicker.ui

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.text.Html
import android.util.Log
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import com.contusfly.mediapicker.R
import com.contusfly.mediapicker.databinding.ActivityMediaPickerBinding
import com.contusfly.mediapicker.helper.ImagePickerUtils
import com.contusfly.mediapicker.helper.MediaPreviewIntent
import com.contusfly.mediapicker.model.Image
import com.contusfly.mediapicker.utils.PickerConstants
import com.contusfly.mediapicker.viewmodel.MediaViewModel
import java.io.File
import java.io.FileOutputStream

class MediaPickerActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMediaPickerBinding
    private var actionBar: ActionBar? = null

    private var directoryName: String? = null

    private var actionMode: ActionMode? = null
    private var doneMenuItem: MenuItem? = null

    val mediaViewModel: MediaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMediaPickerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViews()
        setObservers()
    }

    private fun setUpViews() {
        setSupportActionBar(binding.toolbar)

        actionBar = supportActionBar

        supportActionBar?.title = String.format(
            getString(R.string.folder_list_title),
            intent.extras!!.getString(PickerConstants.SEND_TO, PickerConstants.EMPTY_STRING)
        )
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_black)

        ImagePickerUtils.maxFileRestriction = intent.extras!!.getInt(
            PickerConstants.MAX_MEDIA_SELECTION_RESTRICTION,
            ImagePickerUtils.maxFileRestriction
        )

        val navController = findNavController(R.id.nav_host_fragment_content_media_picker)
        val listener = AppBarConfiguration.OnNavigateUpListener { navController.navigateUp() }
        appBarConfiguration =
            AppBarConfiguration.Builder().setFallbackOnNavigateUpListener(listener).build()
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
        navController.addOnDestinationChangedListener { _, destination, arguments ->
            setUpTitle(destination, arguments)
        }

        directoryName = (if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
            if (Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()) Environment.getExternalStorageDirectory() else filesDir
        } else externalMediaDirs.first()).toString() + File.separator + PickerConstants.LOCAL_PATH
            .replace(" ", "") +
                File.separator + PickerConstants.IMAGE_LOCAL_PATH + File.separator + PickerConstants.MSG_SENT_PATH
    }

    private fun setUpTitle(destination: NavDestination, arguments: Bundle?) {
        when (destination.id) {
            R.id.ImageListFragment -> {
                arguments?.let {
                    actionBar?.title = ImageListFragmentArgs.fromBundle(it).folderName
                }
            }
            R.id.FolderListFragment -> {
                actionBar?.title = String.format(
                    getString(R.string.folder_list_title),
                    intent.extras!!.getString(PickerConstants.SEND_TO, PickerConstants.EMPTY_STRING)
                )
            }
        }
    }

    private fun setObservers() {
        mediaViewModel.isMultiSelectEnable.observe(this, {
            if (it)
                enableMultipleSelection()
        })

        mediaViewModel.isItemSelected.observe(this, {
            it?.let {
                moveToPreviewScreen(arrayListOf(it))
            }
        })

        mediaViewModel.isItemMultiSelected.observe(this, {
            if (it)
                handleActionMode(actionMode, true)
        })

        mediaViewModel.isMaximumSelected.observe(this, {
            Toast.makeText(
                this,
                String.format(
                    getString(R.string.message_max_limit_restriction),
                    ImagePickerUtils.maxFileRestriction
                ),
                Toast.LENGTH_SHORT
            ).show()
        })

        mediaViewModel.isItemSizeNotPermitted.observe(this, {
            Toast.makeText(
                this,
                String.format(
                    getString(R.string.media_max_limit_restriction),
                    if (it) ImagePickerUtils.maxVideoFileSizeRestriction else ImagePickerUtils.maxImageFileSizeRestriction
                ),
                Toast.LENGTH_SHORT
            ).show()
        })

        mediaViewModel.isItemExtensionNotPermitted.observe(this, {
            Toast.makeText(
                this,
                    getString(R.string.message_unsupported_file),
                Toast.LENGTH_SHORT
            ).show()
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_media_picker)
        if (!navController.navigateUp()) { // When in start destination
            onBackPressed()
        }
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    private fun enableMultipleSelection() {
        if (actionMode != null) return
        actionMode = binding.toolbar.startActionMode(object :
            ActionMode.Callback {
            override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
                mode.menuInflater?.inflate(R.menu.image_list_multi_select_menu, menu)
                doneMenuItem = menu.findItem(R.id.action_select_done)
                doneMenuItem?.title =
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                        Html.fromHtml(
                            "<font color='#4879F9'>DONE</font>",
                            Html.FROM_HTML_MODE_LEGACY
                        )
                    else Html.fromHtml("<font color='#4879F9'>DONE</font>")
                handleActionMode(mode, false)
                return true
            }

            override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                return false
            }

            override fun onActionItemClicked(mode: ActionMode?, item: MenuItem): Boolean {
                item.isEnabled = true
                return onActionMenuClick(item.itemId)
            }

            override fun onDestroyActionMode(mode: ActionMode?) {
                mode?.finish()
                actionMode = null
                mediaViewModel.clearSelectedItems()
                mediaViewModel.enableMultiSelect(false)
            }
        })
    }

    private fun handleActionMode(actionMode: ActionMode?, isClear: Boolean) {
        if (isClear && mediaViewModel.selectedPhotoMediaList.isEmpty())
            actionMode?.finish()
        else {
            actionMode?.let {
                actionMode.title =
                    if (mediaViewModel.selectedPhotoMediaList.isEmpty()) getString(R.string.multi_select_title) else String.format(getString(R.string.multi_selected_title), mediaViewModel.selectedPhotoMediaList.size, ImagePickerUtils.maxFileRestriction)

                doneMenuItem?.isVisible = mediaViewModel.selectedPhotoMediaList.isNotEmpty()
            }
        }
    }

    private fun onActionMenuClick(itemId: Int): Boolean {
        return when (itemId) {
            R.id.action_select_done -> {
                moveToPreviewScreen(mediaViewModel.selectedMediaList)
                false
            }
            else -> false
        }
    }

    fun pickMediaFromOtherApp(packageName: String) {
        val gallery = Intent(Intent.ACTION_PICK)
        gallery.setDataAndType(
            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            "image/*"
        )
        gallery.setPackage(packageName)
        externalMediaPickerResult.launch(gallery)
    }

    private var externalMediaPickerResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // There are no request codes
                val intent: Intent? = result.data

                intent?.data?.let {
                    val directory = File(directoryName!!)
                    if (!directory.exists()) directory.mkdir()
                    val mFileTemp = ImagePickerUtils.getFile(directoryName, ".jpg")
                    val inputStream = contentResolver.openInputStream(it)
                    val fileOutputStream = FileOutputStream(mFileTemp)
                    inputStream?.let {
                        ImagePickerUtils.copyStream(inputStream, fileOutputStream)
                        fileOutputStream.close()
                        inputStream.close()
                        val imageDetail = Image(0, mFileTemp.path,0, false)
                        moveToPreviewScreen(arrayListOf(imageDetail))
                    }
                }
            }
        }

    private fun moveToPreviewScreen(selectedImages: ArrayList<Image>) {
        selectedImages.forEach {
            Log.d("selectedImages", "selectedImages before path:${it.path}")
        }
        val mediaPreviewIntent = Intent(
            this,
            MediaPreviewIntent.instance?.mediaClass
        )
        mediaPreviewIntent.putExtra(
            "user_jid",
            MediaPreviewIntent.instance?.toUser
        )
        mediaPreviewIntent.putExtra("from_gallery", true)
        mediaPreviewIntent.putParcelableArrayListExtra(
            "selected_images",
            selectedImages
        )
        mediaPreviewIntent.putExtra("is_image", true)
        previewScreenResult.launch(mediaPreviewIntent)
    }

    private var previewScreenResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // There are no request codes
                val intent: Intent? = result.data
                intent?.let {
                   val remainingList = it.getSerializableExtra("remaining_list") as ArrayList<Image>
                    if (remainingList.size != 0){
                        mediaViewModel.addRemainingList(remainingList)
                    }
                }
            }
        }

}