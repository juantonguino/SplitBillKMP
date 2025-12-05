package com.kmp.splitbillkmp.ui.design

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

open abstract class ColorPalette(
    val primary: Color,
    val onPrimary: Color,
    val primaryContainer: Color,
    val onPrimaryContainer: Color,
    val secondary : Color,
    val onSecondary : Color,
    val secondaryContainer : Color,
    val onSecondaryContainer : Color,
    val tertiary: Color,
    val onTertiary: Color,
    val tertiaryContainer: Color,
    val onTertiaryContainer : Color,
    val error : Color,
    val onError : Color,
    val errorContainer : Color,
    val onErrorContainer : Color,
    val background : Color,
    val onBackground : Color,
    val surface : Color,
    val onSurface : Color,
    val surfaceVariant : Color,
    val onSurfaceVariant : Color,
    val outline : Color,
){
    abstract fun generateColorScheme(): ColorScheme
}

object LightColors : ColorPalette(
    primary = Color(0xFF6750A4),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFEADDFF),
    onPrimaryContainer = Color(0xFF21005D),
    secondary = Color(0xFF625B71),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFE8DEF8),
    onSecondaryContainer = Color(0xFF1D192B),
    tertiary = Color(0xFF7D5260),
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFFFFD8E4),
    onTertiaryContainer = Color(0xFF31101D),
    error = Color(0xFFB3261E),
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFFF9DEDC),
    onErrorContainer = Color(0xFF410E0B),
    background = Color(0xFFFFFBFE),
    onBackground = Color(0xFF1C1B1F),
    surface = Color(0xFFFFFBFE),
    onSurface = Color(0xFF1C1B1F),
    surfaceVariant = Color(0xFFE7E0EC),
    onSurfaceVariant = Color(0xFF49454F),
    outline = Color(0xFF79747E),
){
    override fun generateColorScheme(): ColorScheme {
        return lightColorScheme(
            primary= primary,
            onPrimary= onPrimary,
            primaryContainer= primaryContainer,
            onPrimaryContainer= onPrimaryContainer,
            secondary= secondary,
            onSecondary= onSecondary,
            secondaryContainer= secondaryContainer,
            onSecondaryContainer= onSecondaryContainer,
            tertiary= tertiary,
            onTertiary= onTertiary,
            tertiaryContainer= tertiaryContainer,
            onTertiaryContainer= onTertiaryContainer,
            error= error,
            onError= onError,
            errorContainer= errorContainer,
            onErrorContainer= onErrorContainer,
            background= background,
            onBackground= onBackground,
            surface= surface,
            onSurface= onSurface,
            surfaceVariant= surfaceVariant,
            onSurfaceVariant= onSurfaceVariant,
            outline= outline
        )
    }
}

object DarkColors : ColorPalette(
    primary = Color(0xFFD0BCFF),
    onPrimary = Color(0xFF381E72),
    primaryContainer = Color(0xFF4F378B),
    onPrimaryContainer = Color(0xFFEADDFF),
    secondary = Color(0xFFCCC2DC),
    onSecondary = Color(0xFF332D41),
    secondaryContainer = Color(0xFF4A4458),
    onSecondaryContainer = Color(0xFFE8DEF8),
    tertiary = Color(0xFFEFB8C8),
    onTertiary = Color(0xFF492532),
    tertiaryContainer = Color(0xFF633B48),
    onTertiaryContainer = Color(0xFFFFD8E4),
    error = Color(0xFFF2B8B5),
    onError = Color(0xFF601410),
    errorContainer = Color(0xFF8C1D18),
    onErrorContainer = Color(0xFFF9DEDC),
    background = Color(0xFF1C1B1F),
    onBackground = Color(0xFFE6E1E6),
    surface = Color(0xFF1C1B1F),
    onSurface = Color(0xFFE6E1E6),
    surfaceVariant = Color(0xFF49454F),
    onSurfaceVariant = Color(0xFFCAC4D0),
    outline = Color(0xFF938F99),
){
    override fun generateColorScheme(): ColorScheme {
        return darkColorScheme(
            primary= primary,
            onPrimary= onPrimary,
            primaryContainer= primaryContainer,
            onPrimaryContainer= onPrimaryContainer,
            secondary= secondary,
            onSecondary= onSecondary,
            secondaryContainer= secondaryContainer,
            onSecondaryContainer= onSecondaryContainer,
            tertiary= tertiary,
            onTertiary= onTertiary,
            tertiaryContainer= tertiaryContainer,
            onTertiaryContainer= onTertiaryContainer,
            error= error,
            onError= onError,
            errorContainer= errorContainer,
            onErrorContainer= onErrorContainer,
            background= background,
            onBackground= onBackground,
            surface= surface,
            onSurface= onSurface,
            surfaceVariant= surfaceVariant,
            onSurfaceVariant= onSurfaceVariant,
            outline= outline
        )
    }
}
