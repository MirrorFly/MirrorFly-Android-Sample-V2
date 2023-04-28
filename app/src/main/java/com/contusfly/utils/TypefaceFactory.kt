/*
 * @category ContusFly
 * @copyright Copyright (C) 2016 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.contusfly.utils

import android.content.Context
import android.graphics.Typeface
import androidx.core.content.res.ResourcesCompat
import com.contusfly.R

/**
 *
 * @author ContusTeam <developers></developers>@contus.in>
 * @version 1.0
 */
internal object TypefaceFactory {
    private const val FONT_SF_UI_DISPLAY_BOLD = "res/font/sf_ui_display_bold.otf"
    private const val FONT_SF_UI_DISPLAY_MEDIUM = "res/font/sf_ui_display_medium.otf"
    private const val FONT_SF_UI_DISPLAY_REGULAR = "res/font/sf_ui_display_regular.otf"
    private const val FONT_SF_UI_DISPLAY_SEMIBOLD = "res/font/sf_ui_display_semi_bold.otf"
    private const val FONT_SF_UI_DISPLAY_THIN = "res/font/sf_ui_display_thin.otf"
    private const val FONT_SF_UI_DISPLAY_LIGHT = "res/font/sf_ui_display_light.otf"
    private var regular: Typeface? = null
    private var bold: Typeface? = null
    private var medium: Typeface? = null
    private var semibold: Typeface? = null
    private var thin: Typeface? = null
    private var light: Typeface? = null

    /**
     * Retrieves the bold type Typeface specified by the font resource id.
     *
     * @param context The View's startupActivityContext.
     * @return Typeface for the specified attribute.
     */
    private fun getBoldFont(context: Context): Typeface? {
        if (bold == null) {
            bold = ResourcesCompat.getFont(context, R.font.sf_ui_display_bold)
        }
        return bold
    }

    /**
     * Retrieves the medium type Typeface specified by the font resource id.
     *
     * @param context The View's startupActivityContext.
     * @return Typeface for the specified attribute.
     */
    private fun getMediumFont(context: Context): Typeface? {
        if (medium == null) {
            medium = ResourcesCompat.getFont(context, R.font.sf_ui_display_medium)
        }
        return medium
    }

    /**
     * Retrieves the medium type Typeface specified by the font resource id.
     *
     * @param context The View's startupActivityContext.
     * @return Typeface for the specified attribute.
     */
    private fun getSemiboldFont(context: Context): Typeface? {
        if (semibold == null) {
            semibold = ResourcesCompat.getFont(context, R.font.sf_ui_display_semi_bold)
        }
        return semibold
    }

    /**
     * Retrieves the medium type Typeface specified by the font resource id.
     *
     * @param context The View's startupActivityContext.
     * @return Typeface for the specified attribute.
     */
    private fun getThinFont(context: Context): Typeface? {
        if (thin == null) {
            thin = ResourcesCompat.getFont(context, R.font.sf_ui_display_thin)
        }
        return thin
    }

    /**
     * Retrieves the medium type Typeface specified by the font resource id.
     *
     * @param context The View's startupActivityContext.
     * @return Typeface for the specified attribute.
     */
    private fun getLightFont(context: Context): Typeface? {
        if (light == null) {
            light = ResourcesCompat.getFont(context, R.font.sf_ui_display_light)
        }
        return light
    }

    /**
     * Retrieves the regular type Typeface specified by the font resource id.
     *
     * @param context The View's startupActivityContext.
     * @return Typeface for the specified attribute.
     */
    private fun getRegularFont(context: Context): Typeface? {
        if (regular == null) {
            regular = ResourcesCompat.getFont(context, R.font.sf_ui_display_regular)
        }
        return regular
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
    fun getFontTypeFace(context: Context, fontPath: String?): Typeface? {
        return when (fontPath) {
            FONT_SF_UI_DISPLAY_BOLD -> getBoldFont(context)
            FONT_SF_UI_DISPLAY_MEDIUM -> getMediumFont(context)
            FONT_SF_UI_DISPLAY_REGULAR -> getRegularFont(context)
            FONT_SF_UI_DISPLAY_SEMIBOLD -> getSemiboldFont(context)
            FONT_SF_UI_DISPLAY_THIN -> getThinFont(context)
            FONT_SF_UI_DISPLAY_LIGHT -> getLightFont(context)
            else -> getRegularFont(context)
        }
    }
}