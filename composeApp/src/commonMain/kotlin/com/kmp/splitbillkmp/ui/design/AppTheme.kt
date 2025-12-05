package com.kmp.splitbillkmp.ui.design

class AppTheme(
    val colors: ColorPalette,
    val typography: Typography,
    val spacing: Spacing,
    val shapes: Shapes
)

object AppThemes {
    val Light = AppTheme(
        colors = LightColors,
        typography = AppTypography,
        spacing = AppSpacing,
        shapes = AppShapes
    )

    val Dark = AppTheme(
        colors = DarkColors,
        typography = AppTypography,
        spacing = AppSpacing,
        shapes = AppShapes
    )
}