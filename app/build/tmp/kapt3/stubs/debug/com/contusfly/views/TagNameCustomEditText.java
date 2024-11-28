package com.contusfly.views;

import java.lang.System;

/**
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0003J\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/contusfly/views/TagNameCustomEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onKeyPreIme", "", "keyCode", "event", "Landroid/view/KeyEvent;", "setEditTextAttributes", "set", "setText", "text", "", "type", "Landroid/widget/TextView$BufferType;", "app_debug"})
public final class TagNameCustomEditText extends androidx.appcompat.widget.AppCompatEditText {
    private java.util.HashMap _$_findViewCache;
    
    /**
     * The default constructor to be invoked when initializing the instance of this
     * [android.widget.EditText] object.
     *
     * @param context The Context the view is running in, through which it can
     * access the current theme, resources, etc.
     */
    public TagNameCustomEditText(@org.jetbrains.annotations.Nullable
    android.content.Context context) {
        super(null);
    }
    
    /**
     * The default constructor to be invoked when initializing the instance of this
     * [android.widget.EditText] object.
     *
     * @param context The Context the view is running in, through which it can
     * access the current theme, resources, etc.
     * @param attrs   The attributes of the XML tag that is inflating the view.
     */
    public TagNameCustomEditText(@org.jetbrains.annotations.Nullable
    android.content.Context context, @org.jetbrains.annotations.Nullable
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    /**
     * The default constructor to be invoked when initializing the instance of this
     * [android.widget.EditText] object.
     *
     * @param context      The Context the view is running in, through which it can
     * access the current theme, resources, etc.
     * @param attrs        The attributes of the XML tag that is inflating the view.
     * @param defStyleAttr An attribute in the current theme that contains a
     * reference to a style resource that supplies default values for
     * the view.
     */
    public TagNameCustomEditText(@org.jetbrains.annotations.Nullable
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
    @android.annotation.SuppressLint(value = {"CustomViewStyleable"})
    private final void setEditTextAttributes(android.util.AttributeSet set) {
    }
    
    @java.lang.Override
    protected void onDraw(@org.jetbrains.annotations.NotNull
    android.graphics.Canvas canvas) {
    }
    
    /**
     * Sets the text to be displayed.
     *
     * @param text The text to be displayed.
     * @param type The [BufferType] which defines whether the text is
     * stored as a static text, styleable/spannable text, or editable text.
     */
    @java.lang.Override
    public void setText(@org.jetbrains.annotations.NotNull
    java.lang.CharSequence text, @org.jetbrains.annotations.NotNull
    android.widget.TextView.BufferType type) {
    }
    
    /**
     * Handle a key event before it is processed by any input method
     * associated with the view hierarchy.  This can be used to intercept
     * key events in special situations before the IME consumes them; a
     * typical example would be handling the BACK key to update the application's
     * UI instead of allowing the IME to see it and close itself.
     *
     * @param keyCode The value in event.getKeyCode().
     * @param event   Description of the key event.
     * @return true if handled the event.
     */
    @java.lang.Override
    public boolean onKeyPreIme(int keyCode, @org.jetbrains.annotations.NotNull
    android.view.KeyEvent event) {
        return false;
    }
}