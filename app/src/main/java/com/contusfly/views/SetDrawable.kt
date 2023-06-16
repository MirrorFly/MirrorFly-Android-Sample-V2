package com.contusfly.views

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.contusfly.R
import com.contusfly.utils.Constants
import com.mirrorflysdk.api.contacts.ProfileDetails

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class SetDrawable : BaseDrawable {


    constructor(context: Context) {
        this.context = context
    }

    constructor(context: Context, profileDetails: ProfileDetails?) {
        this.context = context
        this.profileDetails = profileDetails
    }

    fun setDrawableForProfile(name: String?): Drawable {
        var nameValue = name
        val icon = CustomDrawable(context!!)
        if (nameValue.isNullOrBlank()) {
            //default
            icon.setDrawableColour(R.color.colorSecondary)
            icon.setText("")
            return icon
        }
        nameValue = nameValue.trim { it <= ' ' }
        val initialName = nameValue.split("\\s+".toRegex()).toTypedArray()
        return if (initialName.size == 1) {
            val username = initialName[0].trim { it <= ' ' }
            when {
                username.isEmpty() -> {
                    icon.setDrawableColour(R.color.colorSecondary)
                    icon.setText("")
                    icon
                }
                username.length == 1 -> {
                    icon.setText(username.toUpperCase())
                    icon.setDrawableProfileColour(R.color.colorSecondary)
                    icon
                }
                else -> {
                    icon.setText(getProfileNameIcon(username))
                    icon.setDrawableProfileColour(R.color.colorSecondary)
                    icon
                }
            }
        } else {
            var firstletter = ""
            if (initialName[0].trim { it <= ' ' }.isNotEmpty()) {
                firstletter = String(Character.toChars(initialName[0].trim { it <= ' ' }.codePointAt(0)))
            }
            var secondletter = ""
            if (initialName[1].trim { it <= ' ' }.isNotEmpty()) {
                secondletter = String(Character.toChars(initialName[1].trim { it <= ' ' }.codePointAt(0)))
            }
            icon.setText(firstletter.toUpperCase() + secondletter.toUpperCase())
            icon.setDrawableProfileColour(R.color.colorSecondary)
            icon
        }
    }


    fun setDrawableForCustomName(name: String): Drawable {
        val icon = CustomDrawable(context!!, R.color.color_black)
        icon.setDrawableColour(ContextCompat.getColor(context!!, R.color.color_white))
        icon.setText(name)
        return icon
    }

    private fun isEmojiOnly(string: String): Boolean? {
        return Constants.emojiPattern.matcher(string).find()
    }

    private fun getProfileNameIcon(username: String): String {
        var profileLetters = username.substring(0, 2)
        if (isEmojiOnly(profileLetters) == true) {
            profileLetters = if (isEmojiOnly(username.substring(0, 4)) == true) username.substring(0, 4) else username.substring(0, 3)
        }
        return profileLetters.toUpperCase()
    }
}