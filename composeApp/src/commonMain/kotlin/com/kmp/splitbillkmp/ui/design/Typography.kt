package com.kmp.splitbillkmp.ui.design

data class FontFamilyToken(val name: String)

data class Typography(
    val title: FontFamilyToken,
    val body: FontFamilyToken,
    val label: FontFamilyToken
)

val AppTypography = Typography(
    title = FontFamilyToken("Inter-Bold"),
    body = FontFamilyToken("Inter-Regular"),
    label = FontFamilyToken("Inter-Medium")
)
