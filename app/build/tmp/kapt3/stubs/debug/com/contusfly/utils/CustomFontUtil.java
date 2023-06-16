package com.contusfly.utils;

import java.lang.System;

/**
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J \u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\fJ\"\u0010\r\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/contusfly/utils/CustomFontUtil;", "", "()V", "getCustomTypeface", "Landroid/graphics/Typeface;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "setEditTextFont", "", "editText", "Landroid/widget/EditText;", "setTextViewFont", "textView", "Landroid/widget/TextView;", "app_debug"})
public final class CustomFontUtil {
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.utils.CustomFontUtil INSTANCE = null;
    
    private CustomFontUtil() {
        super();
    }
    
    /**
     * Set a custom font for the custom [TextView].
     *
     * @param context  The textView's Context.
     * @param attrs    The textView's attribute values.
     * @param textView The textView to which the font should be added.
     */
    public final void setTextViewFont(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, @org.jetbrains.annotations.NotNull()
    android.widget.TextView textView) {
    }
    
    /**
     * Set a custom font for the custom [EditText].
     *
     * @param context  The editText's Context.
     * @param attrs    The editText's attribute values.
     * @param editText The editText to which the font should be added.
     */
    public final void setEditTextFont(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, @org.jetbrains.annotations.NotNull()
    android.widget.EditText editText) {
    }
    
    /**
     * Sets the custom typeface and style in which the text should be displayed.
     * Note that not all Typeface families actually have bold and italic
     * variants, so you may need to use
     * [TextView.setTypeface] to get the appearance
     * that you actually want.
     *
     * @param context The View's Context.
     * @param attrs   The attributes of the XML tag that is inflating the view.
     */
    private final android.graphics.Typeface getCustomTypeface(android.content.Context context, android.util.AttributeSet attrs) {
        return null;
    }
}