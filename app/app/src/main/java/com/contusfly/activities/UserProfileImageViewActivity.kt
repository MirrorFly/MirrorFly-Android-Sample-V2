package com.contusfly.activities

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.contusfly.databinding.ActivityUserProfileImageBinding
import com.contusfly.utils.Constants
import com.contusfly.utils.MediaUtils
import com.contusfly.utils.UserInterfaceUtils
import com.contusfly.views.SetDrawable
import com.mirrorflysdk.AppUtils

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class UserProfileImageViewActivity : AppCompatActivity() {

    private lateinit var userProfileImageBinding: ActivityUserProfileImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userProfileImageBinding = ActivityUserProfileImageBinding.inflate(layoutInflater)
        setContentView(userProfileImageBinding.root)
        setSupportActionBar(userProfileImageBinding.appBarLayout.toolbar)
        val profileName = intent.getStringExtra(Constants.GROUP_OR_USER_NAME)
        UserInterfaceUtils.setUpToolBar(this, userProfileImageBinding.appBarLayout.toolbar, supportActionBar, profileName)
        val view = userProfileImageBinding.userPhoto
        val setDrawable = SetDrawable(this)
        val icon = setDrawable.setDrawableForProfile(profileName)
        MediaUtils.loadImageWithGlideSecure(this, intent.getStringExtra("PROFILE"), view, icon)
    }

    /**
     * Another Activity comes in front of the activity
     */
    override fun onResume() {
        super.onResume()
        AppUtils.setApplicationVisible(true)
    }

    /**
     * The Activity comes to the foreground
     */
    override fun onPause() {
        super.onPause()
        AppUtils.setApplicationVisible(false)
    }
}