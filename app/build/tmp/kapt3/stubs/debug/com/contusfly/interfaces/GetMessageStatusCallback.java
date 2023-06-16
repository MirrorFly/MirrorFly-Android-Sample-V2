package com.contusfly.interfaces;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&\u00a8\u0006\b"}, d2 = {"Lcom/contusfly/interfaces/GetMessageStatusCallback;", "", "onGetMessageStatusLoaded", "", "deliveredStatus", "", "Lcom/mirrorflysdk/api/models/MessageStatusDetail;", "readByStatus", "app_debug"})
public abstract interface GetMessageStatusCallback {
    
    public abstract void onGetMessageStatusLoaded(@org.jetbrains.annotations.NotNull()
    java.util.List<com.mirrorflysdk.api.models.MessageStatusDetail> deliveredStatus, @org.jetbrains.annotations.NotNull()
    java.util.List<com.mirrorflysdk.api.models.MessageStatusDetail> readByStatus);
}