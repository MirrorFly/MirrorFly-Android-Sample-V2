package com.contusfly.views;

import java.lang.System;

/**
 * @author ContusTeam <developers@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0014J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0006H\u0002\u00a8\u0006\u0015"}, d2 = {"Lcom/contusfly/views/MessageTextView;", "Lio/github/rockerhieu/emojicon/EmojiconTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getMaxLineWidth", "", "layout", "Landroid/text/Layout;", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "setTextViewAttributes", "set", "app_debug"})
public final class MessageTextView extends io.github.rockerhieu.emojicon.EmojiconTextView {
    private java.util.HashMap _$_findViewCache;
    
    /**
     * The default constructor to be invoked when initializing the instance of this
     * [android.widget.TextView] object.
     *
     * @param context The Context the view is running in, through which it can
     * access the current theme, resources, etc.
     */
    public MessageTextView(@org.jetbrains.annotations.Nullable
    android.content.Context context) {
        super(null);
    }
    
    /**
     * The default constructor to be invoked when initializing the instance of this
     * [android.widget.TextView] object.
     *
     * @param context The Context the view is running in, through which it can
     * access the current theme, resources, etc.
     * @param attrs   The attributes of the XML tag that is inflating the view.
     */
    public MessageTextView(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    /**
     * The default constructor to be invoked when initializing the instance of this
     * [android.widget.TextView] object.
     *
     * @param context      The Context the view is running in, through which it can
     * access the current theme, resources, etc.
     * @param attrs        The attributes of the XML tag that is inflating the view.
     * @param defStyleAttr An attribute in the current theme that contains a
     * reference to a style resource that supplies default values for
     * the view.
     */
    public MessageTextView(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    /**
     * Return a TypedArray holding the attribute values in
     * <var>set</var>
     * that are listed in <var>attrs</var>.  In addition, if the given
     * AttributeSet specifies a style class (through the "style" attribute),
     * that style will be applied on top of the base attributes it defines.
     *
     * @param set The base set of attribute values.
     */
    private final void setTextViewAttributes(android.util.AttributeSet set) {
    }
    
    @java.lang.Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    }
    
    private final float getMaxLineWidth(android.text.Layout layout) {
        return 0.0F;
    }
}