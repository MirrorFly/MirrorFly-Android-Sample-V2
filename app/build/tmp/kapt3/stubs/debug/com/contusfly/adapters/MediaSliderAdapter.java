package com.contusfly.adapters;

import java.lang.System;

/**
 * Display the media file in slider for the single user
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000eH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/contusfly/adapters/MediaSliderAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "messageList", "", "Lcom/mirrorflysdk/api/models/ChatMessage;", "(Landroidx/fragment/app/FragmentManager;Ljava/util/List;)V", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "getItemPosition", "", "app_debug"})
public final class MediaSliderAdapter extends androidx.fragment.app.FragmentStatePagerAdapter {
    private final java.util.List<com.mirrorflysdk.api.models.ChatMessage> messageList = null;
    
    public MediaSliderAdapter(@org.jetbrains.annotations.Nullable
    androidx.fragment.app.FragmentManager fm, @org.jetbrains.annotations.NotNull
    java.util.List<? extends com.mirrorflysdk.api.models.ChatMessage> messageList) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public androidx.fragment.app.Fragment getItem(int position) {
        return null;
    }
    
    @java.lang.Override
    public int getCount() {
        return 0;
    }
    
    @java.lang.Override
    public int getItemPosition(@org.jetbrains.annotations.NotNull
    java.lang.Object position) {
        return 0;
    }
}