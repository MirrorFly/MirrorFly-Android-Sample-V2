package com.contusfly.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.contusfly.TAG
import com.contusfly.constants.MobileApplication


/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
object SharedPreferenceManager {

    private val masterKey: MasterKey = MasterKey.Builder(MobileApplication.getContext())
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val nonEncryptedPreferences: SharedPreferences =  MobileApplication.getContext().getSharedPreferences(Constants.SHAREDPREFERENCE_STORAGE_NAME, Context.MODE_PRIVATE)

    val sharedPreferences: SharedPreferences = EncryptedSharedPreferences.create(
            MobileApplication.getContext(),
            Constants.SHAREDPREFERENCE_ENCRYPTED_STORAGE_NAME,
            masterKey, // masterKey created above
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM).apply {
            if (nonEncryptedPreferences.all.isNotEmpty() && this.all.isEmpty()) {
                // migrate non encrypted shared preferences
                // to encrypted shared preferences and clear them once finished.
                nonEncryptedPreferences.copyTo(this)
                nonEncryptedPreferences.clear()
            }
        }

    private var editor = sharedPreferences.edit()


    /**
     * Set Boolean in preference.
     *
     * @param key   the key
     * @param value the value
     */
    fun setBoolean(key: String?, value: Boolean) {
        editor.putBoolean(key, value)
        editor.commit()
    }

    /**
     * Get Boolean from preference.
     *
     * @param key the key
     * @return boolean Value from preference
     */
    fun getBoolean(key: String?): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }

    /**
     * Set String in preference.
     *
     * @param key   the key
     * @param value the value
     */
    fun setString(key: String?, value: String?) {
        editor.putString(key, value)
        editor.commit()
    }

    /**
     * Get the string from preference.
     *
     * @param key the key
     * @return String Value from preference
     */
    fun getString(key: String?): String {
        return sharedPreferences.getString(key, Constants.EMPTY_STRING).toString()
    }

    /**
     * Set int in preference.
     *
     * @param key   the key
     * @param value the value
     */
    fun setInt(key: String?, value: Int) {
        editor.putInt(key, value)
        editor.commit()
    }

    /**
     * Get the int from preference.
     *
     * @param key the key
     * @return Int Value from preference
     */
    fun getInt(key: String?): Int {
        return sharedPreferences.getInt(key, 0)
    }

    fun getCurrentUserJid(): String {
        return getString("username") + "@" + com.mirrorflysdk.flycommons.Constants.getDomain()
    }

    /**
     * Clear all preference.
     */
    fun clearAllPreference(isFromLogout: Boolean = false) {
        val versionName: String = getString(Constants.APP_VERSION)
        val token: String = getString(Constants.FIRE_BASE_TOKEN)
        val askPermission = getBoolean(Constants.ASK_PERMISSION)
        val showLabel = getBoolean(Constants.SHOW_LABEL)
        val translationEnabled = getBoolean(Constants.GOOGLE_TRANSLATION_CHECKED)
        val translateLanguage =  getString(Constants.GOOGLE_LANGUAGE_NAME)
        val translateLanguageCode =  getString(Constants.GOOGLE_TRANSLATION_LANGUAGE_CODE)
        val autoDownloadEnabled =  getBoolean(Constants.MEDIA_AUTO_DOWNLOAD)
        val notificationUri =  getString(Constants.NOTIFICATION_URI)
        val notificationSound =  getBoolean(Constants.NOTIFICATION_SOUND)
        val notificationPopup =  getBoolean(Constants.NOTIFICATION_POPUP)
        val notificationVibration =  getBoolean(Constants.VIBRATION)
        val muteNotification =  getBoolean(Constants.MUTE_NOTIFICATION)
        val storagePermissionAsked =  getBoolean(Constants.STORAGE_PERMISSION_ASKED)
        val cameraPermissionAsked =  getBoolean(Constants.CAMERA_PERMISSION_ASKED)
        val recordAudioPermissionAsked =  getBoolean(Constants.RECORD_AUDIO_PERMISSION_ASKED)
        val phoneStatePermissionAsked =  getBoolean(Constants.READ_PHONE_STATE_PERMISSION_ASKED)
        val audioRecordPermissionAsked =  getBoolean(Constants.AUDIO_RECORD_PERMISSION_ASKED)
        val contactPermissionAsked =  getBoolean(Constants.CONTACT_PERMISSION_ASKED)
        val contactSavePermissionAsked =  getBoolean(Constants.CONTACT_SAVE_PERMISSION_ASKED)
        val locationPermissionAsked =  getBoolean(Constants.LOCATION_PERMISSION_ASKED)
        editor.clear()
        editor.commit()
        setString(Constants.APP_VERSION, versionName)
        setString(Constants.FIRE_BASE_TOKEN, token)
        setBoolean(Constants.ASK_PERMISSION, askPermission)
        setBoolean(Constants.STORAGE_PERMISSION_ASKED, storagePermissionAsked)
        setBoolean(Constants.CAMERA_PERMISSION_ASKED, cameraPermissionAsked)
        setBoolean(Constants.RECORD_AUDIO_PERMISSION_ASKED, recordAudioPermissionAsked)
        setBoolean(Constants.READ_PHONE_STATE_PERMISSION_ASKED, phoneStatePermissionAsked)
        setBoolean(Constants.AUDIO_RECORD_PERMISSION_ASKED, audioRecordPermissionAsked)
        setBoolean(Constants.CONTACT_PERMISSION_ASKED, contactPermissionAsked)
        setBoolean(Constants.CONTACT_SAVE_PERMISSION_ASKED, contactSavePermissionAsked)
        setBoolean(Constants.LOCATION_PERMISSION_ASKED, locationPermissionAsked)
        if (isFromLogout) {
            setBoolean(Constants.SHOW_LABEL, showLabel)
            setBoolean(Constants.GOOGLE_TRANSLATION_CHECKED, translationEnabled)
            setString(Constants.GOOGLE_LANGUAGE_NAME, translateLanguage)
            setString(Constants.GOOGLE_TRANSLATION_LANGUAGE_CODE, translateLanguageCode)
            setBoolean(Constants.MEDIA_AUTO_DOWNLOAD, autoDownloadEnabled)
            setString(Constants.NOTIFICATION_URI, notificationUri)
            setBoolean(Constants.NOTIFICATION_SOUND, notificationSound)
            setBoolean(Constants.NOTIFICATION_POPUP, notificationPopup)
            setBoolean(Constants.VIBRATION, notificationVibration)
            setBoolean(Constants.MUTE_NOTIFICATION, muteNotification)
        }
    }
}

private fun SharedPreferences.copyTo(dest: SharedPreferences) {
    for (entry in all.entries) {
        val key = entry.key
        val value: Any? = entry.value
        dest.set(key, value)
    }
}

private fun SharedPreferences.set(key: String, value: Any?) {
    when (value) {
        is String? -> edit { it.putString(key, value) }
        is Int -> edit { it.putInt(key, value.toInt()) }
        is Boolean -> edit { it.putBoolean(key, value) }
        is Float -> edit { it.putFloat(key, value.toFloat()) }
        is Long -> edit { it.putLong(key, value.toLong()) }
        else -> {
            LogMessage.v(TAG, "Unsupported Type: $value")
        }
    }
}

private fun SharedPreferences.clear() {
    edit { it.clear() }
}

inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
    val editor = this.edit()
    operation(editor)
    editor.apply()
}

