package com.contusfly.views;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u000f\u0010B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0002\u00a8\u0006\u0011"}, d2 = {"Lcom/contusfly/views/CustomViewPager;", "Landroidx/viewpager/widget/ViewPager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onInterceptTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "setMyScroller", "", "MyScroller", "ScrollerCustomDuration", "app_debug"})
public final class CustomViewPager extends androidx.viewpager.widget.ViewPager {
    private java.util.HashMap _$_findViewCache;
    
    public CustomViewPager(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
        super(null);
    }
    
    public CustomViewPager(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    @java.lang.Override()
    public boolean onTouchEvent(@org.jetbrains.annotations.NotNull()
    android.view.MotionEvent ev) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onInterceptTouchEvent(@org.jetbrains.annotations.NotNull()
    android.view.MotionEvent ev) {
        return false;
    }
    
    private final void setMyScroller() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/contusfly/views/CustomViewPager$MyScroller;", "Landroid/widget/Scroller;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "startScroll", "", "startX", "", "startY", "dx", "dy", "duration", "app_debug"})
    public static final class MyScroller extends android.widget.Scroller {
        
        public MyScroller(@org.jetbrains.annotations.Nullable()
        android.content.Context context) {
            super(null);
        }
        
        @java.lang.Override()
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007B#\b\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fJ0\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/contusfly/views/CustomViewPager$ScrollerCustomDuration;", "Landroid/widget/Scroller;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "interpolator", "Landroid/view/animation/Interpolator;", "(Landroid/content/Context;Landroid/view/animation/Interpolator;)V", "flywheel", "", "(Landroid/content/Context;Landroid/view/animation/Interpolator;Z)V", "mScrollFactor", "", "setScrollDurationFactor", "", "scrollFactor", "startScroll", "startX", "", "startY", "dx", "dy", "duration", "app_debug"})
    public static final class ScrollerCustomDuration extends android.widget.Scroller {
        private double mScrollFactor = 1.0;
        
        public ScrollerCustomDuration(@org.jetbrains.annotations.Nullable()
        android.content.Context context) {
            super(null);
        }
        
        public ScrollerCustomDuration(@org.jetbrains.annotations.Nullable()
        android.content.Context context, @org.jetbrains.annotations.Nullable()
        android.view.animation.Interpolator interpolator) {
            super(null);
        }
        
        @android.annotation.SuppressLint(value = {"NewApi"})
        public ScrollerCustomDuration(@org.jetbrains.annotations.Nullable()
        android.content.Context context, @org.jetbrains.annotations.Nullable()
        android.view.animation.Interpolator interpolator, boolean flywheel) {
            super(null);
        }
        
        /**
         * Set the factor by which the duration will change
         */
        public final void setScrollDurationFactor(double scrollFactor) {
        }
        
        @java.lang.Override()
        public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        }
    }
}