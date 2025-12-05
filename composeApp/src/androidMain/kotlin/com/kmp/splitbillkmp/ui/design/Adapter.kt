package com.kmp.splitbillkmp.ui.design

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.Font
import com.kmp.splitbillkmp.R

fun FontFamilyToken.toFontFamily() =
    FontFamily(
        Font(
            resId = getFontResId(name)
        )
    )

fun getFontResId(name: String): Int = when (name) {
    "Inter-Regular" -> R.font.inter_18pt_regular
    "Inter-Medium"  -> R.font.inter_18pt_medium
    "Inter-Bold"    -> R.font.inter_18pt_bold
    else -> error("Font not registered: $name")
}

fun ShapeToken.toDp() = androidx.compose.ui.unit.Dp(radius.toFloat())

fun Spacing.toDp() = this // si usas Dp, mapea double → Dp
