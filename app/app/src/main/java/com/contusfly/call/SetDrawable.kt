package com.contusfly.call

import android.content.Context
import android.graphics.drawable.Drawable
import com.mirrorflysdk.flycommons.ChatType
import com.contusfly.getChatType
import com.contusfly.getColourCode
import com.contusfly.getDisplayName
import com.contusfly.utils.Constants
import com.contusfly.views.BaseDrawable
import com.contusfly.views.CustomDrawable
import com.mirrorflysdk.api.contacts.ProfileDetails

class SetDrawable : BaseDrawable {

    constructor(context: Context) {
        this.context = context
    }

    constructor(context: Context, profileDetails: ProfileDetails?) {
        this.context = context
        this.profileDetails = profileDetails
    }

    fun setDrawableForProfile(name: String): Drawable {
        var name = name
        val icon = CustomDrawable(context!!)
        name = name.trim { it <= ' ' }.replace("\\s+".toRegex(), " ")
        val initialname = name.split(" ".toRegex()).toTypedArray()
        return if (initialname.size == 1) {
            val username = initialname[0]
            if (username.length == 1) {
                val firstletter = initialname[0][0].toString()
                icon.setText(firstletter.toUpperCase())
                icon.setDrawableProfileColour(com.contus.call.R.color.light_blue)
                icon
            } else {
                val firstletter = initialname[0][0].toString()
                val secondletter = initialname[0][1].toString()
                icon.setText(firstletter.toUpperCase() + secondletter.toUpperCase())
                icon.setDrawableProfileColour(com.contus.call.R.color.light_blue)
                icon
            }
        } else {
            val firstletter = initialname[0][0].toString()
            val secondletter = initialname[1][0].toString()
            icon.setText(firstletter.toUpperCase() + secondletter.toUpperCase())
            icon.setDrawableProfileColour(com.contus.call.R.color.light_blue)
            icon
        }
    }

    @Synchronized
    fun setDrawableForGroupCall(nameString: String?, drawableSize: Float, isProfile: Boolean): Drawable? {
        var name = nameString ?: return null
        if (profileDetails?.getChatType() == ChatType.TYPE_CHAT) {
            val icon = CustomDrawable(context!!, drawableSize)
            if (name.isNullOrBlank()) {
                //default
                setDrawableProfileColour(icon, isProfile)
                icon.setText("")
                return icon
            }
            name = name.trim { it <= ' ' }
            val initialName = name.split("\\s+".toRegex()).toTypedArray()
            return if (initialName.size == 1) {
                val username = initialName[0].trim { it <= ' ' }
                when {
                    username.isEmpty() -> {
                        setDrawableProfileColour(icon, isProfile)
                        icon.setText("")
                        icon
                    }
                    username.length == 1 -> {
                        icon.setText(username.toUpperCase())
                        setDrawableProfileColour(icon, isProfile)
                        icon
                    }
                    else -> {
                        icon.setText(getProfileNameIcon(username))
                        setDrawableProfileColour(icon, isProfile)
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
                setDrawableProfileColour(icon, isProfile)
                icon
            }
        }
        return null
    }

    private fun setDrawableProfileColour(icon: CustomDrawable, isProfile: Boolean) {
        if (isProfile) icon.setDrawableProfileColour(com.contus.call.R.color.colorSecondary) else icon.setDrawableColour(profileDetails?.getDisplayName()!!.getColourCode())
    }

    private fun isEmojiOnly(string: String): Boolean {
        return Constants.emojiPattern.matcher(string).find()
    }

    private fun getProfileNameIcon(username: String): String {
        var profileLetters = username.substring(0, 2)
        if (isEmojiOnly(profileLetters)) {
            profileLetters = if (isEmojiOnly(username.substring(0, 4))) username.substring(0, 4) else username.substring(0, 3)
        }
        return profileLetters.toUpperCase()
    }
}