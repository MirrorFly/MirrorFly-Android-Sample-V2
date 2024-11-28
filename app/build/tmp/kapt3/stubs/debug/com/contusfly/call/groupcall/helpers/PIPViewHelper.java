package com.contusfly.call.groupcall.helpers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\bH\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\bJ\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\bJ\b\u0010\u0015\u001a\u00020\u000fH\u0002J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\bH\u0002J\u001e\u0010\u0017\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bH\u0002J\u0006\u0010\u0018\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/contusfly/call/groupcall/helpers/PIPViewHelper;", "", "context", "Landroid/content/Context;", "binding", "Lcom/contusfly/databinding/LayoutPipModeBinding;", "(Landroid/content/Context;Lcom/contusfly/databinding/LayoutPipModeBinding;)V", "lastUserJid", "", "getProfileName", "", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "userJid", "hidePIPLayout", "", "onUserSpeaking", "audioLevel", "", "onUserStoppedSpeaking", "onVideoTrackAdded", "setLocalUserView", "setRemoteUserView", "setRemoteVideoMuted", "showPIPLayout", "app_debug"})
public final class PIPViewHelper {
    private final android.content.Context context = null;
    private final com.contusfly.databinding.LayoutPipModeBinding binding = null;
    private java.lang.String lastUserJid = "";
    
    public PIPViewHelper(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.contusfly.databinding.LayoutPipModeBinding binding) {
        super();
    }
    
    public final void hidePIPLayout() {
    }
    
    public final void showPIPLayout() {
    }
    
    private final void setLocalUserView() {
    }
    
    public final void onVideoTrackAdded(@org.jetbrains.annotations.NotNull
    java.lang.String userJid) {
    }
    
    private final void setRemoteUserView(java.lang.String userJid) {
    }
    
    private final java.lang.CharSequence getProfileName(com.mirrorflysdk.api.contacts.ProfileDetails profileDetails, java.lang.String userJid) {
        return null;
    }
    
    private final void setRemoteVideoMuted(com.mirrorflysdk.api.contacts.ProfileDetails profileDetails, java.lang.String userJid) {
    }
    
    public final void onUserSpeaking(@org.jetbrains.annotations.NotNull
    java.lang.String userJid, int audioLevel) {
    }
    
    public final void onUserStoppedSpeaking(@org.jetbrains.annotations.NotNull
    java.lang.String userJid) {
    }
}