package com.contusfly.models;

import java.lang.System;

@kotlinx.android.parcel.Parcelize()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u00c6\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nH\u00c6\u0003J9\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u00c6\u0001J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u00d6\u0003J\t\u0010\"\u001a\u00020\u001dH\u00d6\u0001J\t\u0010#\u001a\u00020\u0003H\u00d6\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\u001dH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006)"}, d2 = {"Lcom/contusfly/models/DeviceContactModel;", "Landroid/os/Parcelable;", "contactId", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "mobileNumbers", "", "Lcom/contusfly/models/PhoneNumber;", "profileDetails", "Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/mirrorflysdk/api/contacts/ProfileDetails;)V", "getContactId", "()Ljava/lang/String;", "getMobileNumbers", "()Ljava/util/List;", "setMobileNumbers", "(Ljava/util/List;)V", "getName", "getProfileDetails", "()Lcom/mirrorflysdk/api/contacts/ProfileDetails;", "setProfileDetails", "(Lcom/mirrorflysdk/api/contacts/ProfileDetails;)V", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_debug"})
public final class DeviceContactModel implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String contactId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.contusfly.models.PhoneNumber> mobileNumbers;
    @org.jetbrains.annotations.Nullable()
    private com.mirrorflysdk.api.contacts.ProfileDetails profileDetails;
    public static final android.os.Parcelable.Creator<com.contusfly.models.DeviceContactModel> CREATOR = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.contusfly.models.DeviceContactModel copy(@org.jetbrains.annotations.NotNull()
    java.lang.String contactId, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.util.List<com.contusfly.models.PhoneNumber> mobileNumbers, @org.jetbrains.annotations.Nullable()
    com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    public DeviceContactModel(@org.jetbrains.annotations.NotNull()
    java.lang.String contactId, @org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.util.List<com.contusfly.models.PhoneNumber> mobileNumbers, @org.jetbrains.annotations.Nullable()
    com.mirrorflysdk.api.contacts.ProfileDetails profileDetails) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContactId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.contusfly.models.PhoneNumber> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.contusfly.models.PhoneNumber> getMobileNumbers() {
        return null;
    }
    
    public final void setMobileNumbers(@org.jetbrains.annotations.NotNull()
    java.util.List<com.contusfly.models.PhoneNumber> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.mirrorflysdk.api.contacts.ProfileDetails component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.mirrorflysdk.api.contacts.ProfileDetails getProfileDetails() {
        return null;
    }
    
    public final void setProfileDetails(@org.jetbrains.annotations.Nullable()
    com.mirrorflysdk.api.contacts.ProfileDetails p0) {
    }
    
    public DeviceContactModel(@org.jetbrains.annotations.NotNull()
    java.lang.String contactId, @org.jetbrains.annotations.NotNull()
    java.lang.String name) {
        super();
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 3)
    public static final class Creator implements android.os.Parcelable.Creator<com.contusfly.models.DeviceContactModel> {
        
        public Creator() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.contusfly.models.DeviceContactModel createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel in) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public final com.contusfly.models.DeviceContactModel[] newArray(int size) {
            return null;
        }
    }
}