package com.contusfly.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\r\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0011J\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0014H\u0002J\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00172\u0006\u0010\u0019\u001a\u00020\u000bJ\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0014H\u0007J\u001e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00142\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0014H\u0007J\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u00172\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/contusfly/utils/ProfileDetailsUtils;", "", "()V", "addContact", "", "profileDetail", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "getContactSyncProfileDetails", "jid", "", "isUnknownContact", "", "getDisplayName", "getDisplayNameFromJid", "getGroupUsersNames", "groupJid", "getGroupUsersNameCallback", "Lcom/contusfly/interfaces/GetGroupUsersNameCallback;", "getProfileDetails", "getSortedGroupProfileList", "", "profilesList", "removeAdminBlockedProfiles", "", "profileDetails", "sortProfiles", "sortGroupProfileList", "sortGroupProfileListWithoutOwn", "sortProfileList", "app_debug"})
public final class ProfileDetailsUtils {
    @org.jetbrains.annotations.NotNull
    public static final com.contusfly.utils.ProfileDetailsUtils INSTANCE = null;
    
    private ProfileDetailsUtils() {
        super();
    }
    
    /**
     * Sort the profile list by nick name of the profile detail
     *
     * @param profilesList List of profile
     * @return List<ProfileDetails> Sorted profile list
     *   </ProfileDetails>
     */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> sortProfileList(@org.jetbrains.annotations.Nullable
    java.util.List<? extends com.mirrorflysdk.api.contacts.ProfileDetails> profilesList) {
        return null;
    }
    
    /**
     * Returns group users names Separated by comma
     *
     * @param groupJid Group Jid
     * @return String User names Separated by comma
     */
    public final void getGroupUsersNames(@org.jetbrains.annotations.Nullable
    java.lang.String groupJid, @org.jetbrains.annotations.NotNull
    com.contusfly.interfaces.GetGroupUsersNameCallback getGroupUsersNameCallback) {
    }
    
    /**
     * Sort the group user profile list by nick name of the profile detail
     * and move current user to last in the list
     *
     * @param profilesList List of profile
     * @return List<ProfileDetails> Sorted profile list
     *   </Roster>
     */
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.JvmStatic
    public static final java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> sortGroupProfileList(@org.jetbrains.annotations.Nullable
    java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> profilesList) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> removeAdminBlockedProfiles(@org.jetbrains.annotations.NotNull
    java.util.List<? extends com.mirrorflysdk.api.contacts.ProfileDetails> profileDetails, boolean sortProfiles) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.mirrorflysdk.api.contacts.ProfileDetails getProfileDetails(@org.jetbrains.annotations.NotNull
    java.lang.String jid, boolean isUnknownContact) {
        return null;
    }
    
    private final com.mirrorflysdk.api.contacts.ProfileDetails getContactSyncProfileDetails(java.lang.String jid, boolean isUnknownContact) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDisplayName(@org.jetbrains.annotations.Nullable
    java.lang.String jid) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDisplayNameFromJid(@org.jetbrains.annotations.Nullable
    java.lang.String jid) {
        return null;
    }
    
    public final void addContact(@org.jetbrains.annotations.NotNull
    com.mirrorflysdk.api.contacts.ProfileDetails profileDetail) {
    }
    
    @org.jetbrains.annotations.NotNull
    @kotlin.jvm.JvmStatic
    public static final java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> sortGroupProfileListWithoutOwn(@org.jetbrains.annotations.Nullable
    java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> profilesList) {
        return null;
    }
    
    private final java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> getSortedGroupProfileList(java.util.List<com.mirrorflysdk.api.contacts.ProfileDetails> profilesList) {
        return null;
    }
}