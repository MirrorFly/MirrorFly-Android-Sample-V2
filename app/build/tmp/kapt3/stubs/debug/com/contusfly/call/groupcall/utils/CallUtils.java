package com.contusfly.call.groupcall.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0004J\u0006\u0010\u001f\u001a\u00020\u001dJ \u0010 \u001a\u0012\u0012\b\u0012\u00060\"j\u0002`#\u0012\u0004\u0012\u00020\u00070!2\u0006\u0010$\u001a\u00020\"H\u0002J2\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&2\b\u0010\'\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&2\b\b\u0002\u0010)\u001a\u00020\u0007J\"\u0010*\u001a\u00020\u00042\b\u0010\'\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&J\"\u0010+\u001a\u00060\"j\u0002`#2\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00040,j\b\u0012\u0004\u0012\u00020\u0004`-J&\u0010.\u001a\u00020\u00042\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00040,j\b\u0012\u0004\u0012\u00020\u0004`-2\u0006\u0010/\u001a\u00020\u0004J\u0006\u00100\u001a\u00020\u0007J\b\u00101\u001a\u0004\u0018\u00010\u0004J\u0006\u00102\u001a\u00020\u0007J\u0006\u00103\u001a\u00020\u0007J\u0006\u00104\u001a\u00020\u0007J\u0006\u00105\u001a\u00020\u0007J\u0006\u00106\u001a\u00020\u0007J\u0006\u00107\u001a\u00020\u0007J\u001e\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u0001090!2\u0006\u0010:\u001a\u00020\u0004H\u0002J\b\u0010;\u001a\u00020\u0012H\u0002J\u0006\u0010<\u001a\u00020\u0004J\u0006\u0010=\u001a\u00020\u0007J\b\u0010>\u001a\u0004\u0018\u00010?J\u000e\u0010@\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0004J\u0010\u0010A\u001a\u0004\u0018\u00010?2\u0006\u0010\u001e\u001a\u00020\u0004J\u0010\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020DH\u0007J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\u0006\u0010E\u001a\u00020\u0007J\u0006\u0010F\u001a\u00020\u0007J\u0018\u0010G\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u0017H\u0002J\u0016\u0010I\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u0017J\u0006\u0010\f\u001a\u00020\u0007J.\u0010J\u001a\u00020\u001d2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020N2\u0014\u0010O\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u0001090!H\u0002J\u0016\u0010P\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u0017J\u000e\u0010Q\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0004J\u0006\u0010R\u001a\u00020\u001dJ\u000e\u0010S\u001a\u00020\u001d2\u0006\u0010E\u001a\u00020\u0007JJ\u0010T\u001a\u00060\"j\u0002`#2\u0006\u0010K\u001a\u00020L2\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00040,j\b\u0012\u0004\u0012\u00020\u0004`-2\u0006\u0010U\u001a\u00020N2\u0006\u0010V\u001a\u00020N2\u0006\u0010W\u001a\u00020N2\u0006\u0010X\u001a\u00020NJ\u0010\u0010Y\u001a\u00020\u001d2\u0006\u0010Z\u001a\u00020\u0007H\u0007J\u000e\u0010[\u001a\u00020\u001d2\u0006\u0010\\\u001a\u00020\u0007J\u0012\u0010]\u001a\u00020\u001d2\b\u0010^\u001a\u0004\u0018\u00010\u0004H\u0007J\u000e\u0010_\u001a\u00020\u001d2\u0006\u0010`\u001a\u00020\u0007J\u000e\u0010a\u001a\u00020\u001d2\u0006\u0010b\u001a\u00020\u0007J\u000e\u0010c\u001a\u00020\u001d2\u0006\u0010d\u001a\u00020\u0007J\u000e\u0010e\u001a\u00020\u001d2\u0006\u0010f\u001a\u00020\u0007J\u000e\u0010g\u001a\u00020\u001d2\u0006\u0010h\u001a\u00020\u0007J\u000e\u0010i\u001a\u00020\u001d2\u0006\u0010f\u001a\u00020\u0007J\u0018\u0010j\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u0017H\u0002J\u000e\u0010k\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010l\u001a\u00020\u001d2\u0006\u0010b\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\'\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00170\u00168BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006m"}, d2 = {"Lcom/contusfly/call/groupcall/utils/CallUtils;", "", "()V", "ACTION_PHONE_CALL_STATE_CHANGED", "", "IS_CALL_NOTIFICATION", "isAddUsersToTheCall", "", "isBackCameraCapturing", "isFromPoorInternetUpdate", "isGridViewEnabled", "isListViewAnimated", "isTileViewScrolling", "isUserTilePinned", "isVideoViewInitialized", "isViewUpdatesCompleted", "mIsCallStarted", "peakSpeakingUser", "Lcom/contusfly/call/groupcall/utils/SpeakingUser;", "pinnedUserJid", "showCallsTab", "speakingLevelMap", "Ljava/util/HashMap;", "", "getSpeakingLevelMap", "()Ljava/util/HashMap;", "speakingLevelMap$delegate", "Lkotlin/Lazy;", "clearPeakSpeakingUser", "", "userJid", "clearSpeakingLevels", "getActualMemberName", "Lkotlin/Pair;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "stringBuilder", "getCallLogUserJidList", "", "toUser", "callUsers", "withDeletedUser", "getCallLogUserNames", "getCallUsersName", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getGroupMembersName", "groupID", "getIsBackCameraCapturing", "getIsCallStarted", "getIsFromPoorInternetUpdate", "getIsGridViewEnabled", "getIsListViewAnimated", "getIsUserTilePinned", "getIsVideoViewInitialized", "getIsViewUpdatesCompleted", "getNameAndProfileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "jid", "getPeakSpeakingUser", "getPinnedUserJid", "getPinnedUserVideoMuted", "getPinnedVideoSink", "Lcom/mirrorflysdk/flycall/webrtc/ProxyVideoSink;", "getUserSpeakingLevel", "getVideoSinkForUser", "isActivityDestroyed", "activity", "Landroid/app/Activity;", "isCallsTabToBeShown", "isLocalUserPinned", "isSpeakingLevelsReceivedForSameUser", "audioLevel", "isSpeakingUserCanBeShownOnTop", "loadUserProfilePic", "context", "Landroid/content/Context;", "callMember", "Lcom/contusfly/views/CircularImageView;", "pair", "onUserSpeaking", "onUserStoppedSpeaking", "resetValues", "setCallsTabToBeShown", "setGroupMemberProfile", "imageCallMember1", "imageCallMember2", "imageCallMember3", "imageCallMember4", "setIsAddUsersToTheCall", "isAddUsers", "setIsBackCameraCapturing", "isBackCamera", "setIsCallStarted", "isCallStarted", "setIsFromPoorInternetUpdate", "isUpdatedFromPoorInternet", "setIsGridViewEnabled", "enabled", "setIsListViewAnimated", "animated", "setIsTileViewScrolling", "boolean", "setIsUserTilePinned", "pinned", "setIsViewUpdatesCompleted", "setPeakSpeakingUser", "setPinnedUserJid", "setVideoViewInitialization", "app_debug"})
public final class CallUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.call.groupcall.utils.CallUtils INSTANCE = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String IS_CALL_NOTIFICATION = "is_call_notification";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String ACTION_PHONE_CALL_STATE_CHANGED = "call.action.PHONE_CALL_STATE_CHANGED";
    
    /**
     * flag indicates whether group call grid view is showing or not
     */
    private static boolean isGridViewEnabled = false;
    private static boolean isVideoViewInitialized = false;
    
    /**
     * boolean represents whether we have to show calls tab or not.
     */
    private static boolean showCallsTab = false;
    
    /**
     * Boolean stating whether if add participant in progress
     */
    private static boolean isAddUsersToTheCall = false;
    
    /**
     * flag indicates whether call grid/list view updates currently happening
     */
    private static boolean isViewUpdatesCompleted = true;
    
    /**
     * flag indicates whether list view is showing above call options
     */
    private static boolean isListViewAnimated = false;
    
    /**
     * Contains the user jid which need to be showed in pinned view
     */
    private static java.lang.String pinnedUserJid = "";
    
    /**
     * flag indicates whether user tile pinned
     */
    private static boolean isUserTilePinned = false;
    
    /**
     * Boolean to identify whether the action is with respect to the call initiation.
     */
    private static java.lang.String mIsCallStarted;
    
    /**
     * This indicates whether the back camera capturing or not
     */
    private static boolean isBackCameraCapturing = false;
    
    /**
     * flag indicates which user audio level reaches peak
     */
    private static com.contusfly.call.groupcall.utils.SpeakingUser peakSpeakingUser;
    private static final kotlin.Lazy speakingLevelMap$delegate = null;
    
    /**
     * Flag to update list view options
     */
    private static boolean isFromPoorInternetUpdate = false;
    private static boolean isTileViewScrolling = false;
    
    private CallUtils() {
        super();
    }
    
    private final java.util.HashMap<java.lang.String, java.lang.Integer> getSpeakingLevelMap() {
        return null;
    }
    
    public final void setIsTileViewScrolling(boolean p0_32355860) {
    }
    
    public final boolean isTileViewScrolling() {
        return false;
    }
    
    public final void setVideoViewInitialization(boolean enabled) {
    }
    
    public final boolean getIsVideoViewInitialized() {
        return false;
    }
    
    public final void setIsGridViewEnabled(boolean enabled) {
    }
    
    public final boolean getIsGridViewEnabled() {
        return false;
    }
    
    public final void setIsViewUpdatesCompleted(boolean p0_32355860) {
    }
    
    public final boolean getIsViewUpdatesCompleted() {
        return false;
    }
    
    public final void setIsListViewAnimated(boolean animated) {
    }
    
    public final boolean getIsListViewAnimated() {
        return false;
    }
    
    public final void setPinnedUserJid(@org.jetbrains.annotations.NotNull
    java.lang.String userJid) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPinnedUserJid() {
        return null;
    }
    
    public final void setIsUserTilePinned(boolean pinned) {
    }
    
    public final boolean getIsUserTilePinned() {
        return false;
    }
    
    public final void setIsBackCameraCapturing(boolean isBackCamera) {
    }
    
    public final boolean getIsBackCameraCapturing() {
        return false;
    }
    
    private final void setPeakSpeakingUser(java.lang.String userJid, int audioLevel) {
    }
    
    private final com.contusfly.call.groupcall.utils.SpeakingUser getPeakSpeakingUser() {
        return null;
    }
    
    public final boolean isSpeakingUserCanBeShownOnTop(@org.jetbrains.annotations.NotNull
    java.lang.String userJid, int audioLevel) {
        return false;
    }
    
    private final boolean isSpeakingLevelsReceivedForSameUser(java.lang.String userJid, int audioLevel) {
        return false;
    }
    
    public final void onUserSpeaking(@org.jetbrains.annotations.NotNull
    java.lang.String userJid, int audioLevel) {
    }
    
    public final void onUserStoppedSpeaking(@org.jetbrains.annotations.NotNull
    java.lang.String userJid) {
    }
    
    public final int getUserSpeakingLevel(@org.jetbrains.annotations.NotNull
    java.lang.String userJid) {
        return 0;
    }
    
    public final void clearSpeakingLevels() {
    }
    
    public final void clearPeakSpeakingUser(@org.jetbrains.annotations.NotNull
    java.lang.String userJid) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.StringBuilder setGroupMemberProfile(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> callUsers, @org.jetbrains.annotations.NotNull
    com.contusfly.views.CircularImageView imageCallMember1, @org.jetbrains.annotations.NotNull
    com.contusfly.views.CircularImageView imageCallMember2, @org.jetbrains.annotations.NotNull
    com.contusfly.views.CircularImageView imageCallMember3, @org.jetbrains.annotations.NotNull
    com.contusfly.views.CircularImageView imageCallMember4) {
        return null;
    }
    
    private final void loadUserProfilePic(android.content.Context context, com.contusfly.views.CircularImageView callMember, kotlin.Pair<java.lang.String, ? extends com.mirrorflysdk.api.contacts.ProfileDetails> pair) {
    }
    
    private final kotlin.Pair<java.lang.String, com.mirrorflysdk.api.contacts.ProfileDetails> getNameAndProfileDetails(java.lang.String jid) {
        return null;
    }
    
    private final kotlin.Pair<java.lang.StringBuilder, java.lang.Boolean> getActualMemberName(java.lang.StringBuilder stringBuilder) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getGroupMembersName(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> callUsers, @org.jetbrains.annotations.NotNull
    java.lang.String groupID) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.StringBuilder getCallUsersName(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> callUsers) {
        return null;
    }
    
    /**
     * this method return the user jid for the call
     */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getCallLogUserJidList(@org.jetbrains.annotations.Nullable
    java.lang.String toUser, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> callUsers, boolean withDeletedUser) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCallLogUserNames(@org.jetbrains.annotations.Nullable
    java.lang.String toUser, @org.jetbrains.annotations.Nullable
    java.util.List<java.lang.String> callUsers) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.mirrorflysdk.flycall.webrtc.ProxyVideoSink getPinnedVideoSink() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.mirrorflysdk.flycall.webrtc.ProxyVideoSink getVideoSinkForUser(@org.jetbrains.annotations.NotNull
    java.lang.String userJid) {
        return null;
    }
    
    public final boolean isLocalUserPinned() {
        return false;
    }
    
    public final boolean getPinnedUserVideoMuted() {
        return false;
    }
    
    /**
     * Determines whether the action is in respect to the call initiation.
     *
     * @return string representing the call action.
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getIsCallStarted() {
        return null;
    }
    
    /**
     * Sets the boolean if the action is related to call initiation.
     *
     * @param isCallStarted string stating the call action.
     */
    @kotlin.jvm.JvmStatic
    public static final void setIsCallStarted(@org.jetbrains.annotations.Nullable
    java.lang.String isCallStarted) {
    }
    
    @kotlin.jvm.JvmStatic
    public static final boolean isActivityDestroyed(@org.jetbrains.annotations.NotNull
    android.app.Activity activity) {
        return false;
    }
    
    /**
     * @return boolean returns whether we have to show calls tab or not
     */
    public final boolean isCallsTabToBeShown() {
        return false;
    }
    
    /**
     * @param isCallsTabToBeShown sets whether we have to show calls tab or not
     */
    public final void setCallsTabToBeShown(boolean isCallsTabToBeShown) {
    }
    
    /**
     * @return true, if add participant in progress
     */
    @kotlin.jvm.JvmStatic
    public static final boolean isAddUsersToTheCall() {
        return false;
    }
    
    /**
     * This method is used to set the add participant in progress
     *
     * @param isAddUsers boolean value, which is true when add participant in progress
     */
    @kotlin.jvm.JvmStatic
    public static final void setIsAddUsersToTheCall(boolean isAddUsers) {
    }
    
    public final void setIsFromPoorInternetUpdate(boolean isUpdatedFromPoorInternet) {
    }
    
    public final boolean getIsFromPoorInternetUpdate() {
        return false;
    }
    
    public final void resetValues() {
    }
}