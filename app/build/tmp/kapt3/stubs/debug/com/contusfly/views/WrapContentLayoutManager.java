package com.contusfly.views;

import java.lang.System;

/**
 * Crop the image of the taken photo to set on the profile image
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 2.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J,\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u00060\bR\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J,\u0010\u000f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\n\u0010\u0007\u001a\u00060\bR\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\rH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/contusfly/views/WrapContentLayoutManager;", "Lcom/contusfly/views/WrapContentLayoutInit;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "onMeasure", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "widthSpec", "", "heightSpec", "setMeasureAdapter", "setOrientation", "orientation", "app_debug"})
public final class WrapContentLayoutManager extends com.contusfly.views.WrapContentLayoutInit {
    
    public WrapContentLayoutManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    /**
     * Set the measurement
     *
     * @param recycler   recycler view to measure
     * @param state      state of the recycler view
     * @param widthSpec  width
     * @param heightSpec height
     */
    @java.lang.Override()
    public void onMeasure(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.Recycler recycler, @org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.State state, int widthSpec, int heightSpec) {
    }
    
    /**
     * Set the measurement on the adapter
     *
     * @param state      state of the recycler view
     * @param recycler   recycler view to measure
     * @param widthSpec  width
     * @param heightSpec height
     * @return int 1 if Measured or 0 if not
     */
    private final int setMeasureAdapter(androidx.recyclerview.widget.RecyclerView.State state, androidx.recyclerview.widget.RecyclerView.Recycler recycler, int widthSpec, int heightSpec) {
        return 0;
    }
    
    /**
     * Measure the orientation
     *
     * @param orientation vertical/horizontal
     */
    @java.lang.Override()
    public void setOrientation(int orientation) {
    }
}