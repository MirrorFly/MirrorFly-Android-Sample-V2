package com.contusfly.call.groupcall;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0002\u0010\bJ\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/contusfly/call/groupcall/AudioDeviceAdapter;", "Landroid/widget/ArrayAdapter;", "", "context", "Landroid/content/Context;", "devices", "", "selectedDevice", "(Landroid/content/Context;[Ljava/lang/String;Ljava/lang/String;)V", "[Ljava/lang/String;", "getView", "Landroid/view/View;", "position", "", "convertView", "parent", "Landroid/view/ViewGroup;", "updateSelection", "", "newSelectedDevice", "app_debug"})
public final class AudioDeviceAdapter extends android.widget.ArrayAdapter<java.lang.String> {
    private final java.lang.String[] devices = null;
    private java.lang.String selectedDevice;
    
    public AudioDeviceAdapter(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    java.lang.String[] devices, @org.jetbrains.annotations.NotNull
    java.lang.String selectedDevice) {
        super(null, 0);
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public android.view.View getView(int position, @org.jetbrains.annotations.Nullable
    android.view.View convertView, @org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent) {
        return null;
    }
    
    public final void updateSelection(@org.jetbrains.annotations.NotNull
    java.lang.String newSelectedDevice) {
    }
}