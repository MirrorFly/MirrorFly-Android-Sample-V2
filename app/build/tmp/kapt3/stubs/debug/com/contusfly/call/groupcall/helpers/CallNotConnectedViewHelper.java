package com.contusfly.call.groupcall.helpers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\bJ\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\u0006\u0010\r\u001a\u00020\bJ\u001e\u0010\u000e\u001a\u00020\b2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012J\u0006\u0010\u0013\u001a\u00020\bJ \u0010\u0014\u001a\u00020\b2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012H\u0002J\u0016\u0010\u0015\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0012\u0010\u0016\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/contusfly/call/groupcall/helpers/CallNotConnectedViewHelper;", "", "context", "Landroid/content/Context;", "binding", "Lcom/contusfly/databinding/LayoutCallNotConnectedBinding;", "(Landroid/content/Context;Lcom/contusfly/databinding/LayoutCallNotConnectedBinding;)V", "hideRetryLayout", "", "setUpCallUI", "setUpCallUIForCallAttended", "showCallStatus", "showCallerImage", "showRetryLayout", "updateCallMemberDetails", "callUsers", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "updateCallStatus", "updateGroupDetailsForGroupCall", "updateGroupMemberDetails", "updateUserDetails", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "app_debug"})
public final class CallNotConnectedViewHelper {
    private final android.content.Context context = null;
    private final com.contusfly.databinding.LayoutCallNotConnectedBinding binding = null;
    
    public CallNotConnectedViewHelper(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.contusfly.databinding.LayoutCallNotConnectedBinding binding) {
        super();
    }
    
    public final void updateCallStatus() {
    }
    
    private final void showCallStatus() {
    }
    
    public final void setUpCallUI() {
    }
    
    private final void showCallerImage() {
    }
    
    public final void showRetryLayout() {
    }
    
    public final void hideRetryLayout() {
    }
    
    /**
     * This method is getting the caller name and profile picture
     *
     * @param callUsers list of Users in Call
     */
    public final void updateCallMemberDetails(@org.jetbrains.annotations.NotNull
    java.util.ArrayList<java.lang.String> callUsers) {
    }
    
    private final void updateGroupDetailsForGroupCall(java.util.ArrayList<java.lang.String> callUsers) {
    }
    
    private final void updateUserDetails(com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
    }
    
    private final void updateGroupMemberDetails(java.util.ArrayList<java.lang.String> callUsers) {
    }
    
    public final void setUpCallUIForCallAttended() {
    }
}