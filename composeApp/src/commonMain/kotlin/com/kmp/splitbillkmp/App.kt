package com.kmp.splitbillkmp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import com.kmp.splitbillkmp.ui.design.AppThemes
import com.kmp.splitbillkmp.views.HomeView
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val appThemesLight = AppThemes.Light
    val appThemesDark = AppThemes.Dark
    MaterialTheme(colorScheme = appThemesLight.colors.generateColorScheme()) {
        HomeView()
    }
    /**
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }
    }
    */
}