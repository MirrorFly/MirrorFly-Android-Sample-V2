package com.contusfly.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0006\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u000fJ\u0016\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\f0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0007\u00a8\u0006\u0019"}, d2 = {"Lcom/contusfly/viewmodels/MediaPreviewViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "profileDetails", "Landroidx/lifecycle/MutableLiveData;", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "getProfileDetails", "()Landroidx/lifecycle/MutableLiveData;", "selectedImageList", "", "Lcom/contusfly/models/MediaPreviewModel;", "selectedMediaList", "", "getSelectedMediaList", "unsentMessage", "", "getUnsentMessage", "checkVideoSize", "", "selectedImage", "Lcom/contusfly/mediapicker/model/Image;", "destinationFile", "Ljava/io/File;", "jid", "setUnSentMessageForAnUser", "app_debug"})
public final class MediaPreviewViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.mirrorflysdk.api.contacts.ProfileDetails> profileDetails = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> unsentMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.contusfly.models.MediaPreviewModel>> selectedMediaList = null;
    private java.util.List<com.contusfly.models.MediaPreviewModel> selectedImageList;
    
    @javax.inject.Inject()
    public MediaPreviewViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.mirrorflysdk.api.contacts.ProfileDetails> getProfileDetails() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getUnsentMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.contusfly.models.MediaPreviewModel>> getSelectedMediaList() {
        return null;
    }
    
    public final void getProfileDetails(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
    }
    
    public final void getUnsentMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String jid) {
    }
    
    public final void setUnSentMessageForAnUser(@org.jetbrains.annotations.NotNull()
    java.lang.String jid, @org.jetbrains.annotations.NotNull()
    java.lang.String unsentMessage) {
    }
    
    public final void checkVideoSize(@org.jetbrains.annotations.NotNull()
    com.contusfly.mediapicker.model.Image selectedImage, @org.jetbrains.annotations.NotNull()
    java.io.File destinationFile) {
    }
}