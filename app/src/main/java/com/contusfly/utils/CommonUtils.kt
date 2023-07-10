package com.contusfly.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AppOpsManager
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.os.Process
import android.provider.ContactsContract
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import android.widget.LinearLayout
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.contusfly.AppLifecycleListener
import com.mirrorflysdk.flycommons.LogMessage
import com.contusfly.R
import com.contusfly.TAG
import com.contusfly.activities.OtpActivity
import com.contusfly.chatTag.interfaces.DialogPositiveButtonClick
import com.contusfly.databinding.BottomSheetChatTagRemoveLayoutBinding
import com.contusfly.databinding.BottomSheetEditProfileImageBinding
import com.mirrorflysdk.utils.RequestCode
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import com.google.android.material.bottomsheet.BottomSheetDialog
import eu.janmuller.android.simplecropimage.CropImage
import java.io.File

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
open class CommonUtils {

    companion object {
        /**
         * @param context context required to get system service
         * @return true , if PIP is not disabled by the user
         */
        fun isPipModeAllowed(context: Context): Boolean {
            val appOpsManager: AppOpsManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                appOpsManager = context.getSystemService(Context.APP_OPS_SERVICE) as AppOpsManager
                return AppOpsManager.MODE_ALLOWED == appOpsManager.checkOpNoThrow(AppOpsManager.OPSTR_PICTURE_IN_PICTURE, Process.myUid(), context.packageName)
            }
            return false
        }

        /**
         * opens the pip mode setting for the current app
         *
         * @param context context
         */
        fun openPipModeSettings(context: Context) {
            val intent = Intent("android.settings.PICTURE_IN_PICTURE_SETTINGS",
                    Uri.parse("package:" + context.packageName))
            context.startActivity(intent)
        }

        /**
         * @param v view to get coordinates on screen
         * @return coordinates of the view on the screen
         */
        fun locateView(v: View?): Rect? {
            val coordinates = IntArray(2)
            if (v == null) return null
            try {
                v.getLocationOnScreen(coordinates)
            } catch (npe: NullPointerException) {
                //Happens when the view doesn't exist on screen anymore.
                return null
            }
            val location = Rect()
            location.left = coordinates[0]
            location.top = coordinates[1]
            return location
        }

        /**
         * This method converts dp unit to equivalent pixels, depending on device density.
         *
         * @param context Context to get resources and device specific display metrics
         * @param dp      A value in dp (density independent pixels) unit. Which we need to convert into pixels
         * @return A int value to represent px equivalent to dp depending on device density
         */
        fun convertDpToPixel(context: Context, dp: Int): Int {
            return dp * (context.resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)
        }

        /**
         * Checks if is net connected.
         *
         * @param context The instance of context
         * @return boolean True if is net connected
         */
        fun isNetConnected(context: Context): Boolean {
            val conMgr = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            return conMgr.activeNetworkInfo != null && conMgr.activeNetworkInfo!!.isConnected
        }

        /**
         * Sign out from the gPlus account.
         *
         * @param context the startupActivityContext of the calling parent.
         */
        fun navigateUserToLoggedOutUI(context: Context) {
            val handler = Handler(Looper.getMainLooper())
            handler.postDelayed({
                val mIntent = Intent(context, OtpActivity::class.java)
                mIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                context.startActivity(mIntent)
            }, 1000)
        }

        /**
         * Open the add-contact screen with pre-filled info. The received contact will be stored in
         * local contact. The [ContactMessage] will be used to parse the contact details
         * and to store the contact
         *
         * @param context        Activity context
         */
        fun addContactInMobile(context: Activity, contactNumber:String, contactName:String) {
            try {
                val intent = Intent(Intent.ACTION_INSERT)
                intent.type = ContactsContract.Contacts.CONTENT_TYPE
                intent.putExtra(ContactsContract.Intents.Insert.PHONE, contactNumber)
                intent.putExtra(ContactsContract.Intents.Insert.NAME, contactName)
                context.startActivityForResult(intent, Constants.CONTACT_REQ_CODE)
                AppLifecycleListener.deviceContactCount = 0
            } catch (e: Exception) {
                LogMessage.e(TAG, e)
            }
        }

        @SuppressLint("StaticFieldLeak")
        private var bottomSheetDialog: BottomSheetDialog? = null

        /**
         * Show bottom list in the Alter dialog.
         *
         * @param context  Instance of Context
         * @param listener Instance of DialogInterface.OnClickListener
         */
        fun showBottomSheetView(context: Activity, hasRemovePhoto: Boolean, listener: DialogInterface.OnClickListener) {
            val bottomSheetEditProfileImageBinding : BottomSheetEditProfileImageBinding = BottomSheetEditProfileImageBinding.inflate(context.layoutInflater)
            bottomSheetDialog = BottomSheetDialog(context)
            bottomSheetDialog!!.setContentView(bottomSheetEditProfileImageBinding.root)
            val bottomSheetBehavior: BottomSheetBehavior<*> = BottomSheetBehavior.from(bottomSheetEditProfileImageBinding.root.parent as View)
            bottomSheetBehavior.setBottomSheetCallback(bottomSheetCallback)
            val textViewTakePhoto = bottomSheetEditProfileImageBinding.actionTake
            val textViewChooseFromGallery = bottomSheetEditProfileImageBinding.actionGallery
            val textViewRemovePhoto = bottomSheetEditProfileImageBinding.actionRemove
            val emptySpace = bottomSheetEditProfileImageBinding.space
            textViewRemovePhoto.visibility = if (hasRemovePhoto) View.VISIBLE else View.GONE
            emptySpace.visibility = if (hasRemovePhoto) View.GONE else View.VISIBLE
            textViewTakePhoto.setOnClickListener { _: View? ->
                listener.onClick(dialogInterface, R.id.action_take)
                bottomSheetDialog!!.dismiss()
            }
            textViewChooseFromGallery.setOnClickListener { _: View? ->
                listener.onClick(dialogInterface, R.id.action_gallery)
                bottomSheetDialog!!.dismiss()
            }
            textViewRemovePhoto.setOnClickListener { _: View? ->
                listener.onClick(dialogInterface, R.id.action_remove)
                bottomSheetDialog!!.dismiss()
            }
            bottomSheetDialog!!.show()
        }

        var dialogInterface: DialogInterface = object : DialogInterface {
            override fun cancel() {
                /*No Implementation Needed*/
            }

            override fun dismiss() {
                /*No Implementation Needed*/
            }
        }

        var bottomSheetCallback: BottomSheetCallback = object : BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                if (newState == BottomSheetBehavior.STATE_HIDDEN) bottomSheetDialog!!.dismiss()
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                /*No Implementation Needed*/
            }
        }

        /**
         * Crop the image from the Any size of image at Square.
         *
         * @param context Instance of Context
         * @param file    Instance of File
         */
        fun cropImage(context: Activity, file: File) {
            val intent = Intent(context, CropImage::class.java)
            intent.putExtra(CropImage.IMAGE_PATH, file.path)
            intent.putExtra(CropImage.SCALE, true)
            intent.putExtra(CropImage.ASPECT_X, 5)
            intent.putExtra(CropImage.ASPECT_Y, 5)
            context.startActivityForResult(intent, RequestCode.CROP_IMAGE)
        }

        /**
         * Get the jabber id of the user
         *
         * @param user    User name
         * @return String Jabber id
         */
        fun getJidFromUser(user: String?): String? {
            return user + "@" + SharedPreferenceManager.getString(Constants.XMPP_DOMAIN)
        }

        fun chatTagRemoveBottomDialogShow(mContext: Context, buttonclick: DialogPositiveButtonClick){

            val metrics = mContext.resources.displayMetrics
            val screenWidth = (metrics.widthPixels * 0.100).toInt()
            val binding = BottomSheetChatTagRemoveLayoutBinding.inflate(LayoutInflater.from(mContext))
            var view= binding.root
            val dialog= BottomSheetDialog(mContext, R.style.DialogSlideAnim)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(view)
            dialog.setCanceledOnTouchOutside(true)
            dialog.setCancelable(true)
            dialog.window!!.attributes.windowAnimations= R.style.SlideDialogAnimation
            dialog.window!!.setLayout(screenWidth, LinearLayout.LayoutParams.WRAP_CONTENT)
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.behavior.state= BottomSheetBehavior.STATE_EXPANDED
            dialog.behavior.isHideable=false
            dialog.behavior.isDraggable=false
            dialog.show()

            binding.removeChatTag.setOnClickListener {

                buttonclick.onItemClickListener(View.OnClickListener {  })
                dialog.dismiss()
            }

        }


        fun scrollToCenter(
            layoutManager: LinearLayoutManager,
            recyclerList: RecyclerView,
            clickPosition: Int
        ) {
            val smoothScroller: RecyclerView.SmoothScroller? =
                createSnapScroller(recyclerList, layoutManager)
            if (smoothScroller != null) {
                smoothScroller.setTargetPosition(clickPosition)
                layoutManager.startSmoothScroll(smoothScroller)
            }
        }

        // This number controls the speed of smooth scroll
        private const val MILLISECONDS_PER_INCH = 70f

        private const val DIMENSION = 2
        private const val HORIZONTAL = 0
        private const val VERTICAL = 1

        @Nullable
        private fun createSnapScroller(
            mRecyclerView: RecyclerView,
            layoutManager: RecyclerView.LayoutManager): LinearSmoothScroller? {
            return if (layoutManager !is RecyclerView.SmoothScroller.ScrollVectorProvider) {
                null
            } else object : LinearSmoothScroller(mRecyclerView.getContext()) {
                protected override fun onTargetFound(
                    targetView: View,
                    state: RecyclerView.State,
                    action: Action
                ) {
                    val snapDistances = calculateDistanceToFinalSnap(layoutManager, targetView)
                    val dx = snapDistances[HORIZONTAL]
                    val dy = snapDistances[VERTICAL]
                    val time: Int =
                        calculateTimeForDeceleration(Math.max(Math.abs(dx), Math.abs(dy)))
                    if (time > 0) {
                        action.update(dx, dy, time, mDecelerateInterpolator)
                    }
                }

                protected override fun calculateSpeedPerPixel(displayMetrics: DisplayMetrics): Float {
                    return MILLISECONDS_PER_INCH / displayMetrics.densityDpi
                }
            }
        }


        private fun calculateDistanceToFinalSnap(
            @NonNull layoutManager: RecyclerView.LayoutManager,
            @NonNull targetView: View
        ): IntArray {
            val out = IntArray(DIMENSION)
            if (layoutManager.canScrollHorizontally()) {
                out[HORIZONTAL] = distanceToCenter(
                    layoutManager, targetView,
                    OrientationHelper.createHorizontalHelper(layoutManager)
                )
            }
            if (layoutManager.canScrollVertically()) {
                out[VERTICAL] = distanceToCenter(
                    layoutManager, targetView,
                    OrientationHelper.createHorizontalHelper(layoutManager)
                )
            }
            return out
        }


        private fun distanceToCenter(
            @NonNull layoutManager: RecyclerView.LayoutManager,
            @NonNull targetView: View, helper: OrientationHelper
        ): Int {
            val childCenter: Int = (helper.getDecoratedStart(targetView)
                    + helper.getDecoratedMeasurement(targetView) / 2)
            val containerCenter: Int
            containerCenter = if (layoutManager.getClipToPadding()) {
                helper.getStartAfterPadding() + helper.getTotalSpace() / 2
            } else {
                helper.getEnd() / 2
            }
            return childCenter - containerCenter
        }

    }
}