package com.kmp.splitbillkmp.ui.design

data class ShapeToken(val radius: Double)

data class Shapes(
    val small: ShapeToken,
    val medium: ShapeToken,
    val large: ShapeToken
)

val AppShapes = Shapes(
    small = ShapeToken(4.0),
    medium = ShapeToken(8.0),
    large = ShapeToken(16.0)
)