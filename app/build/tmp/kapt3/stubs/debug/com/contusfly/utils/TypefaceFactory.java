package com.contusfly.utils;

import java.lang.System;

/**
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/contusfly/utils/TypefaceFactory;", "", "()V", "FONT_SF_UI_DISPLAY_BOLD", "", "FONT_SF_UI_DISPLAY_LIGHT", "FONT_SF_UI_DISPLAY_MEDIUM", "FONT_SF_UI_DISPLAY_REGULAR", "FONT_SF_UI_DISPLAY_SEMIBOLD", "FONT_SF_UI_DISPLAY_THIN", "bold", "Landroid/graphics/Typeface;", "light", "medium", "regular", "semibold", "thin", "getBoldFont", "context", "Landroid/content/Context;", "getFontTypeFace", "fontPath", "getLightFont", "getMediumFont", "getRegularFont", "getSemiboldFont", "getThinFont", "app_debug"})
public final class TypefaceFactory {
    @org.jetbrains.annotations.NotNull()
    public static final com.contusfly.utils.TypefaceFactory INSTANCE = null;
    private static final java.lang.String FONT_SF_UI_DISPLAY_BOLD = "res/font/sf_ui_display_bold.otf";
    private static final java.lang.String FONT_SF_UI_DISPLAY_MEDIUM = "res/font/sf_ui_display_medium.otf";
    private static final java.lang.String FONT_SF_UI_DISPLAY_REGULAR = "res/font/sf_ui_display_regular.otf";
    private static final java.lang.String FONT_SF_UI_DISPLAY_SEMIBOLD = "res/font/sf_ui_display_semi_bold.otf";
    private static final java.lang.String FONT_SF_UI_DISPLAY_THIN = "res/font/sf_ui_display_thin.otf";
    private static final java.lang.String FONT_SF_UI_DISPLAY_LIGHT = "res/font/sf_ui_display_light.otf";
    private static android.graphics.Typeface regular;
    private static android.graphics.Typeface bold;
    private static android.graphics.Typeface medium;
    private static android.graphics.Typeface semibold;
    private static android.graphics.Typeface thin;
    private static android.graphics.Typeface light;
    
    private TypefaceFactory() {
        super();
    }
    
    /**
     * Retrieves the bold type Typeface specified by the font resource id.
     *
     * @param context The View's startupActivityContext.
     * @return Typeface for the specified attribute.
     */
    private final android.graphics.Typeface getBoldFont(android.content.Context context) {
        return null;
    }
    
    /**
     * Retrieves the medium type Typeface specified by the font resource id.
     *
     * @param context The View's startupActivityContext.
     * @return Typeface for the specified attribute.
     */
    private final android.graphics.Typeface getMediumFont(android.content.Context context) {
        return null;
    }
    
    /**
     * Retrieves the medium type Typeface specified by the font resource id.
     *
     * @param context The View's startupActivityContext.
     * @return Typeface for the specified attribute.
     */
    private final android.graphics.Typeface getSemiboldFont(android.content.Context context) {
        return null;
    }
    
    /**
     * Retrieves the medium type Typeface specified by the font resource id.
     *
     * @param context The View's startupActivityContext.
     * @return Typeface for the specified attribute.
     */
    private final android.graphics.Typeface getThinFont(android.content.Context context) {
        return null;
    }
    
    /**
     * Retrieves the medium type Typeface specified by the font resource id.
     *
     * @param context The View's startupActivityContext.
     * @return Typeface for the specified attribute.
     */
    private final android.graphics.Typeface getLightFont(android.content.Context context) {
        return null;
    }
    
    /**
     * Retrieves the regular type Typeface specified by the font resource id.
     *
     * @param context The View's startupActivityContext.
     * @return Typeface for the specified attribute.
     */
    private final android.graphics.Typeface getRegularFont(android.content.Context context) {
        return null;
    }
    
    /**
     * Returns the Typeface in which the [android.widget.TextView]
     * and [android.widget.EditText] should be displayed.
     * the Typeface for the attribute at <var>index</var>.
     *
     *
     * This method will throw an exception if the attribute is defined but is
     * not a font.
     *
     * @param context  The View's startupActivityContext.
     * @param fontPath The path of the font added to the View.
     * @return Typeface for the attribute, or `null` if not defined.
     */
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.Typeface getFontTypeFace(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String fontPath) {
        return null;
    }
}