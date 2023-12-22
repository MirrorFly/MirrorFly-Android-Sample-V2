package com.contusfly.utils

import android.net.Uri
import com.contusfly.BuildConfig
import java.util.regex.Pattern

/**
 *
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
class Constants {

    /*
    * Variable Declaration */
    companion object {


        /*
                * Below Keys are using in App level */
        const val SHAREDPREFERENCE_STORAGE_NAME = "Contus"
        const val SHAREDPREFERENCE_ENCRYPTED_STORAGE_NAME = "Contus Encrypted"
        const val EMPTY_STRING = ""
        const val APP_VERSION = "app_version"
        const val FIRE_BASE_TOKEN = "firebase_token"
        const val MUTE_NOTIFICATION = "mute_notification"
        const val NOTIFICATION_ID = 123
        const val ACTIVITY_REQ_CODE = 111
        const val MAX_NAME_COUNT = 30
        const val VIDEO_DURATION_LIMIT = 300
        const val AUDIO_DURATION_LIMIT = 300
        const val MAX_CAPTION_LENGTH = 1024
        const val EMPTY_TIME = ""
        const val NOTIFY_MESSAGE_HIGHLIGHT = "notify_message_highlight"
        const val NOTIFY_MESSAGE_UNHIGHLIGHT = "notify_message_unhighlight"
        const val NOTIFY_MESSAGE_PROGRESS_CHANGED = "notify_message_progress_changed"
        const val NOTIFY_MESSAGE_MEDIA_STATUS_CHANGED = "notify_message_media_status_changed"
        const val NOTIFY_MESSAGE_STATUS_CHANGED = "notify_message_status_changed"
        const val NOTIFY_USER_NAME = "notify_user_name"
        const val NOTIFY_PROFILE_ICON = "notify_profile_icon"
        const val NOTIFY_MSG_TYPING = "notify_msg_typing"
        const val NOTIFY_SELECTION = "notify_selection"
        const val NOTIFY_IS_SELECTED = "notify_is_selected"
        const val NOTIFY_MESSAGE_UPDATE = "notify_message_update"
        const val NOTIFY_PINNED_ICON = "notify_pinned_icon"
        const val NOTIFY_MUTE_UNMUTE = "notify_mute_unmute"
        const val NOTIFY_MESSAGE = "notify_message"
        const val NOTIFY_UNREAD_ICON = "notify_unread_icon"
        const val SDK_DATA = "data"
        const val TOTAL_PAGES = "total_pages"
        const val DIAL_CODE = "dialCode"
        const val COUNTRY_CODE = "countryCode"
        const val MOBILE_NO = "mobileNumber"
        const val LOGIN_MODE = "mailLogin"
        const val USERNAME = "username"
        const val ERROR_SERVER = "Server error, kindly try again later"
        const val STATUS_CODE_SUCCESS = "200"
        const val STATUS_CODE_SECURITY_TOKEN_ERROR = "401"
        const val STATUS_INTERNAL_SERVER_ERROR = "500"
        const val USER_MOBILE_NUMBER = "mobile_number"
        const val USER_EMAIL = "email"
        const val USER_PROFILE_IMAGE = "profile_image"
        const val USER_STATUS = "user_status"
        const val IS_LOGGED_IN = "is_logged_in"
        const val IS_ARCHIVE_SETTINGS_SET = "is_archive_settings_set"
        const val IS_FIRST = "is_first"
        const val IS_MESSAGE_MIGRATION_DONE = "is_message_detail_migration_done"
        const val USER_JID = "user_jid"
        const val SENDER_USER_JID = "sender_user_jid"
        const val MESSAGE_ID = "message_id"
        const val COUNTRY_REQUEST_CODE = 118
        const val COUNTRY_NAME = "countryName"
        const val GCM_REG_ID = "deviceToken"
        const val XMPP_RESOURCE = "resource"
        const val SECRET_KEY = "password"
        const val AUTH_TOKEN = "authToken"
        const val WEB_SECRET_KEY = "web_password"
        const val CONFIG_UNSUCCESSFULL = "config_unsuccessfull"
        const val ADMIN_USER = "adminUser"
        const val VIDEO_LIMIT = "videoLimit"
        const val AUDIO_LIMIT = "audioLimit"
        const val LIVE_STREAM_URL = "liveStreamingSignalServer"
        const val IS_LIVE_STREAM_ENABLED = "isLiveStreamingEnabled"
        const val LIVE_STREAM_SIGNAL_SERVER = "liveStreamingSignalServer"
        const val RECALL_TIME = "recallTime"
        const val PRIVATE_TIME = "privateTime"
        const val XMPP_DOMAIN = "xmppDomain"
        const val XMPP_PORT = "xmppPort"
        const val XMPP_HOST = "xmppHost"
        const val HOST = "host"
        const val URL = "url"
        const val SIGNAL_SERVER_DOMAIN = "signalServerDomain"
        const val STUNS = "stuns"
        const val TURNS = "turns"
        const val GOOGLE_TRANSLATE = "googleTranslate"
        const val GOOGLE_TRANSLATE_KEY = "google_translate"
        const val PIN_TIMEOUT = "pinTimeOut"
        const val PIN_EXPIRE_DAYS = "pinExpireDays"
        const val BACKUP_TYPE = "chatBackupType"
        const val BACKUP_FREQUENCY = "chatBackupFrequency"
        const val WEEKLY = "weekly"
        const val CONTACT_REQ_CODE = 114
        const val SKIP_PROFILE = "skip_profile"
        const val OTP = "otp"
        const val DEVICE_TYPE = "deviceType"
        const val ANDROID = "android"
        const val IS_LOGOUT = "is_logout"
        const val IS_PROFILE_LOGGED = "is_profile_logged"
        const val TITLE = "title"
        const val TYPE = "type"
        const val HINT = "hint"
        const val TEXT_COUNT = "text_count"
        const val MSG_TYPE_TEXT = "text"
        const val MSG_TYPE_AUTO_TEXT = "auto_text"
        const val MAX_TEXT_COUNT = 139
        const val GROUP_NAME_UPDATE = 2
        const val MAX_GROUP_NAME_COUNT = 25
        const val MAX_CONTACT_SELECTION_COUNT = 5
        const val TYPE_USER_BUSY_STATUS = 4
        const val GROUP_OR_USER_NAME = "GROUP_OR_USER_NAME"
        const val GROUP_ID = "group_id"
        const val GROUP_ICON_EDIT = "GROUP_ICON_EDIT"
        const val MEDIA_URL = "url"
        const val LOCAL_PATH = "UI Kit"
        const val IMAGE_LOCAL_PATH = "Image"
        const val VIDEO_LOCAL_PATH = "Video"
        const val AUDIO_LOCAL_PATH = "Audio"
        const val FILE_LOCAL_PATH = "File"
        const val MSG_SENT_PATH = "Sent"
        const val TEMP_PHOTO_FILE_NAME = "temp_photo"
        const val TEMP_FILE_NAME = "temp_file"
        const val AUDIO_FILE = "audio/*"

        const val CONVERSATION_SOUND = "conv_sound"
        const val NOTIFICATION_URI = "notification_uri"
        const val VIBRATION_TYPE = "vibration_type"
        const val MUTE_ALL_CONVERSATION = "mute_all"
        const val IS_FIRST_LOGIN = "is_first"
        const val FROM_SPLASH = "from_splash"
        const val EMAIL = "email"
        const val ASK_PERMISSION = "ask_permission"
        const val USER_PROFILE_NAME = "profile_name"
        const val EMAIL_PATTERN = ("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,3})$")
        const val FROM_SETTINGS_PROFILE = "from_settings_profile"
        const val FROM_LOGIN_PROFILE = "from_login_profile"
        const val REGISTER_END_POINT = "/api/v1/sandbox/register"
        const val CONTACT_SYNC_END_POINT = "/api/v1/contacts/sandbox/syncContacts"
        const val DEVICE_OS_VERSION = "deviceOsVersion"
        const val LICENSE_KEY = "licenseKey"
        const val MODE = "mode"
        const val USER_IDENTIFIER = "userIdentifier"
        const val VOIP_DEVICE_TOKEN = "voipDeviceToken"
        const val CALLS_TAB_INDEX = 1
        const val TYPE_SEARCH_RECENT = "Chats"
        const val TYPE_SEARCH_CONTACT = "Contact"
        const val TYPE_SEARCH_MESSAGE = "Message"
        const val COMPOSING = "Composing"
        const val MSG_TYPE_IMAGE = "image"
        const val MSG_TYPE_AUDIO = "audio"
        const val MSG_TYPE_LOCATION = "location"
        const val MSG_TYPE_CONTACT = "contact"
        const val MSG_TYPE_FILE = "document"
        const val MSG_TYPE_NOTIFICATION = "notification"
        const val MSG_TYPE_VIDEO = "video"
        const val MSG_TYPE_MEET = "meet"
        const val MESSAGE = "message"
        const val IMAGE_RESULTS = "image_results"
        const val MULTI_SELECTION = "multi_selection"
        const val ADD_PARTICIAPANTS = "add_participants"
        const val LATITUDE = "latitude"
        const val LONGITUDE = "longitude"
        const val SELECT_CONTACT_REQ = 124
        const val SELECTED_VIDEO = "selected_video"
        const val SELECTED_VIDEO_CAPTION = "selected_video_caption"
        const val USERS_JID = "users_jid"
        const val DEVICE_WIDTH = "DEVICE_WIDTH"
        const val DEVICE_HEIGHT = "DEVICE_HEIGHT"
        const val INTENT_KEY_SHARE = "intent_key_share"
        const val INTENT_KEY_JID_LIST = "intent_key_jid_list"
        const val INTENT_KEY_CHAT_TYPE_LIST = "intent_key_chat_type_list"
        const val INTENT_KEY_RECEIVED_FILES = "intent_key_received_files"
        const val SHARE = "share"
        const val IMAGE_TAKEN_FROM_CAMERA = "imagefromcamera"
        const val DELETE_MEDIA_FROM_PHONE = "delete_media_from_phone"
        const val MESSAGES_TO_DELETE = "messages_to_delete"
        const val REPLY_MESSAGE_ID = "reply_message_id"
        const val REPLY_MESSAGE_USER = "reply_message_user"
        const val CHAT_TYPE = "chat_type"
        const val FROM_QUICK_SHARE = "quick_share"
        const val FORWARD = "forward"
        const val DELETE = "delete"
        const val REPLY = "reply"
        const val INFO = "info"
        const val COPY = "copy"
        const val REPORT = "report"
        const val STAR = "star"
        const val UNSTAR = "unstar"
        val CONTENT_URI = Uri.parse("content://eu.janmuller.android.simplecropimage.contus-fly/")
        const val MIME_TYPE_VIDEO = "video/*"
        const val SELECTED_IMAGES = "selected_images"
        const val CHAT_MESSAGE = "chatmessage"
        const val FROMUSER = "Fromuser"
        const val PRESENCE_AVAILABLE = "presence_available"
        const val ONLINE = "Online"
        const val ONLINE_STATUS = "0"
        const val IS_IMAGE = "is_image"
        const val FROM_CAMERA = "from_camera"
        const val FROM_FRONT_CAMERA = "from_front_camera"
        const val FILE_PATH = "file_path"
        const val IS_UPLOAD_SUCCESS = "is_upload_success"
        const val RECALL = "recall"
        const val YOU = "You"
        const val TAG = "Contus Fly"
        const val MEET_SCHEDULED_ON="Meet scheduled on"
        const val IS_FROM_NOTIFICATION = "is_from_notification"
        const val JID = "jid"
        const val NOTIFICATION_CHANNEL_ID = (BuildConfig.APPLICATION_ID + ".notification")
        const val GROUP_CHAT = "groupchat"
        const val ROSTER_JID = "roster_jid"
        const val MUTE_NOTIFY = "mute_notification"
        const val UN_MUTE_NOTIFY = "unmute_notification"
        const val IS_FROM_CHAT_SHORTCUT = "is_from_chat_shortcut"
        const val YESTERDAY = "Yesterday"
        const val FRAGMENT_TYPE = "fragment_type"
        const val TYPE_NOTIFICATION = 3
        const val IS_STARRED_MESSAGE = "Starred_Message"
        const val STORAGE_PERMISSION_CODE = 233
        const val QR_CAMERA_PERMISSION_CODE = 2001


        const val ATTACHMENT_CAMERA = "Camera"
        const val ATTACHMENT_VIDEO = "Video"
        const val ATTACHMENT_AUDIO = "Audio"
        const val ATTACHMENT_GALLERY = "Gallery"
        const val ATTACHMENT_LOCATION = "Location"
        const val ATTACHMENT_DOCUMENT = "Document"
        const val ATTACHMENT_CONTACT = "Contact"

        const val LOCATION_PERMISSION_ASKED = "location_permission_asked_before"
        const val CONTACT_PERMISSION_ASKED = "contact_permission_asked_before"
        const val CONTACT_SAVE_PERMISSION_ASKED = "contact_save_permission_asked_before"
        const val CAMERA_PERMISSION_ASKED = "camera_permission_asked_before"
        const val STORAGE_PERMISSION_ASKED = "storage_permission_asked_before"
        const val NOTIFICATION_PERMISSION_ASKED = "notification_permission_asked_before"
        const val AUDIO_RECORD_PERMISSION_ASKED = "audio_record_permission_asked_before"

        const val READ_PHONE_STATE_PERMISSION_ASKED = "read_phone_state_asked_before"
        const val RECORD_AUDIO_PERMISSION_ASKED = "read_phone_state_asked_before"
        const val BLUETOOTH_PERMISSION_ASKED = "bluetooth_permission_asked_before"

        /**
         * Notifying action for removing action menu from chat activity
         */
        const val FORWARDED_MESSAGE_ITEM = "com.contus.chat.forwarded.message.item"

        /**
         * The application id defined in the app-level build gradle.
         */
        const val PACKAGE_NAME: String = BuildConfig.APPLICATION_ID + "."
        const val KEY_CHANGE_FLAG: String = PACKAGE_NAME + "change.flag"

        /**
         * Key to store the created channel ID for push notification in Oreo based devices and above
         */
        const val KEY_CHANNEL_SINGLE_ID: String = PACKAGE_NAME + "channel.id"

        const val KEY_NOTIIFCATION_SUMMARY_CHANNEL_ID: String = PACKAGE_NAME + "summary_channel.id"

        const val KEY_FORGROUND="_isForground"
        const val KEY_BACKGROUND="_isBackground"

        /**
         * Send the status of file upload triggered from Quick Share
         */
        const val QUICK_SHARE_UPLOAD_RESPONSE = "com.contus.quickshare.reponse"

        const val MSG_SENT = "N"
        const val MSG_ACK = "A"
        const val MSG_DELIVERED = "D"
        const val MSG_SEEN = "S"

        const val COUNT_ONE = 1
        const val COUNT_ZERO = 0
        const val ONE_KB = 1024

        const val MAX_FORWARD_USER_RESTRICTION = 5
        const val MAX_MEDIA_SELECTION_RESTRICTION = 10
        const val POSITION = "Position"

        const val IS_MAKE_CALL = "is_make_call"
        const val CALL_TYPE = "call_type"

        const val IS_24_FORMAT = "is_24_format"
        const val IS_TIME_FORMAT_CHANGED = "is_time_format_changed"
        const val BACK_PRESS = "back_press"
        const val APP_SESSION = "app_session"
        const val SHOW_PIN = "show_pin"
        const val BIOMETRIC = "Biometric"
        const val QUICK_SHARE = "quick_share"
        const val GO_TO = "go_to"
        const val MY_PIN = "my_pin"
        const val ALERT_DATE = "alertDate"
        const val EXPIRY_DATE = "expiryDate"
        const val LAST_LAUNCH_DATE = "last_launch_date"
        const val CHANGE_PIN_NEXT = "ChangePinNext"
        const val RESET_PIN = "reset_pin"
        const val PIN_SCREEN = "pin_screen"
        const val CLOSE_DIALOG = "close_dialog"
        const val ADMIN_BLOCKED = "admin_blocked"

        const val SEEKER_POS = "seeker_pos_in_sec"
        const val FROM_GROUP_INFO = "from_group_info"
        const val FROM_SPLASH_SCREEN = "fromSplashScreen"
        const val FROM_ADMIN_BLOCK_SCREEN = "fromAdminBlockScreen"
        const val IS_PIN_VALIDATED = "fromAdminBlockScreen"

        const val CHAT_TAG_ID="chatTagId"
        const val CHAT_TAG_POSITION="chatTagPosition"
        const val EDIT_CHAT_TAG_ITEMS="editItems"

        val NOTIFICATION_SOUND: String = PACKAGE_NAME + "notification_sound"
        val NOTIFICATION_POPUP: String = PACKAGE_NAME + "notification_popup"
        val VIBRATION: String = PACKAGE_NAME + "vibration"
        const val IS_SET_PIN = "isSetPin"
        const val SET_PIN_BEFORE_BIOMETRIC = "setPinBeforeBiometric"
        const val BACKPRESS = "backpress"
        const val PIN_EXPIRE_BIOMETRIC = "pin_expired_biometric"
        const val IS_WEBCHAT_LOGGED_IN = "web_chat_login"
        const val WEB_USER_TOKEN = "web_user_token"
        const val SHOW_LABEL = "show_label"
        const val IS_FOR_SAFE_CHAT: String = "enable safe chat"
        const val IS_SAFE_CHAT_ENABLED: String = "is_safe_chat_enabled"
        const val IS_TO_DISABLE_SAFE_CHAT: String = "disable_safe_chat_confirm"

        const val NEWLY_CREATED_GROUP = "newly_created_group"
        const val NEW_GROUP_JID = "new_group_jid"
        const val GROUP_JID = "group_jid"
        const val NEW_GROUP_IMAGE = "new_group_image"

        /* Message Translation */
        const val GOOGLE_TRANSLATION_CHECKED = "TranslateLanguageChecked"
        const val GOOGLE_LANGUAGE_NAME = "LanguageName"
        const val GOOGLE_TRANSLATION_LANGUAGE_CODE = "LanguageCode"
        const val GOOGLE_TRANSLATION_CHECKED_IN_FIRST_TIME = "TranslatedLanguageCheckedInFirstTime"
        const val TRANSLATED_MESSAGE_CONTENT = "translated_message_content"
        const val IS_MESSAGE_TRANSLATED = "is_message_translated"
        const val TRANSLATED_LANGUAGE = "translated_language"

        /*Pagination Load Type*/
        const val PREV_LOAD="prevload"
        const val NEXT_LOAD="nextload"
        const val NO_DATA="nodata"

        const val IS_EXISTING = "isExisting"


        const val CLEAR_CHAT="Clear Chat"

        const val STORAGE="/storage/emulated/"
        const val MEDIA_AUTO_DOWNLOAD: String = "media_auto_download"
        const val MISSED_CALL_COUNT: String = "missed_call_count"
        /**
         * The preference key used to store the user preference for the data usage settings
         * in particular to the data connection network type[ConnectivityManager.TYPE_MOBILE].
         */
        const val CONNECTION_TYPE_MOBILE = PACKAGE_NAME + "connection_type_mobile"

        /**
         * The preference key used to store the user preference for the data usage settings
         * in particular to the data connection network type[ConnectivityManager.TYPE_WIFI].
         */
        const val CONNECTION_TYPE_WIFI = PACKAGE_NAME + "connection_type_wifi"

        const val INITIAL_CONTACT_SYNC_DONE = "is_initial_contact_sync_done"
        const val CONTACT_SYNC_DONE = "is_contact_sync_done"
        const val EMAIL_CONTACT_SYNC_COMPLETE = "com.contus.contact.email.sync.complete"
        const val INTENT_ACTION_FORCIBLE_UPDATE: String = BuildConfig.APPLICATION_ID + ".forcible_app_update"
        const val MAIL_CONTACT_END_POINT = "/api/v1/contacts/mail"
        const val TIMESTAMP = "timestamp"
        const val IS_DIALOG_SHOWING = "is_dialog_showing"
        const val DELETED_USER   = "Deleted User"
        const val IS_PROFILE_UPDATED = "is_profile_updated"

        const val WEB_IMAGE_MAX_WIDTH = 330
        const val WEB_IMAGE_MIN_WIDTH = 240
        const val WEB_IMAGE_MAX_HEIGHT = 338
        const val WEB_IMAGE_MIN_HEIGHT = 83

        const val MOBILE_IMAGE_MAX_WIDTH = 250
        const val MOBILE_IMAGE_MIN_WIDTH = 210
        const val MOBILE_IMAGE_MAX_HEIGHT = 320
        const val MOBILE_IMAGE_MIN_HEIGHT = 80

        const val DEFAULT_VIBRATE = 250L

        /* Message Direction */
        const val LOAD_PREV_MESSAGE="backward"
        const val LOAD_NEXT_MESSAGE="forward"

        const val regex1 = "^[\\s\n\r]*(?:(?:[\u00a9\u00ae\u203c\u2049\u2122\u2139\u2194-\u2199\u21a9-\u21aa\u231a-\u231b\u2328\u23cf\u23e9-\u23f3\u23f8-" +
                "\u23fa\u24c2\u25aa-\u25ab\u25b6\u25c0\u25fb-\u25fe\u2600-\u2604\u260e\u2611\u2614-\u2615\u2618\u261d\u2620\u2622-\u2623\u2626\u262a\u262e-\u262f\u2638-\u263a\u2648-" +
                "\u2653\u2660\u2663\u2665-\u2666\u2668\u267b\u267f\u2692-\u2694\u2696-\u2697\u2699\u269b-\u269c\u26a0-\u26a1\u26aa-\u26ab\u26b0-\u26b1\u26bd-\u26be\u26c4-" +
                "\u26c5\u26c8\u26ce-\u26cf\u26d1\u26d3-\u26d4\u26e9-\u26ea\u26f0-\u26f5\u26f7-\u26fa\u26fd\u2702\u2705\u2708-\u270d\u270f\u2712\u2714\u2716\u271d\u2721\u2728\u2733-" +
                "\u2734\u2744\u2747\u274c\u274e\u2753-\u2755\u2757\u2763-\u2764\u2795-\u2797\u27a1\u27b0\u27bf\u2934-\u2935\u2b05-\u2b07\u2b1b-" +
                "\u2b1c\u2b50\u2b55\u3030\u303d\u3297\u3299\ud83c\udc04\ud83c\udccf\ud83c\udd70-\ud83c\udd71\ud83c\udd7e-\ud83c\udd7f\ud83c\udd8e\ud83c\udd91-\ud83c\udd9a\ud83c\ude01-" +
                "\ud83c\ude02\ud83c\ude1a\ud83c\ude2f\ud83c\ude32-\ud83c\ude3a\ud83c\ude50-\ud83c\ude51\u200d\ud83c\udf00-\ud83d\uddff\ud83d\ude00-\ud83d\ude4f\ud83d\ude80-" +
                "\ud83d\udeff\ud83e\udd00-\ud83e\uddff\udb40\udc20-\udb40\udc7f]|\u200d[\u2640\u2642]|[\ud83c\udde6-\ud83c\uddff]{2}|"
        val emojiPattern: Pattern = Pattern.compile("$regex1.[\u20e0\u20e3\ufe0f]+)+[\\s\n\r]*)+$")

        //Private Chat
        const val PRIVATE_CHAT="private_chat"
        const val PRIVATE_CHAT_TYPE="private_chat_type"
        const val PRIVATE_CHAT_LIST = "private_chat_list"
        const val PRIVATE_CHAT_DISABLE = "private_chat_disable"
        const val PRIVATE_CHAT_ENABLE = "private_chat_enable"
        const val DASHBOARD="dashboard"
        const val AUTHENTICATION_NEED="authentication_need"
        const val IS_SHOW_PRIVATE_CHAT_LIST="show_private_chat_list"
        const val ON_GOING_CHAT_USER="ongoing_chat_user"


        const val MAX_DOCUMENT_UPLOAD_SIZE = 2048 // 2 GB
        const val MAX_AUDIO_SIZE_LIMIT = 2048 // 2 GB

    }
}