package com.yesman.autoride.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = BrandDark,
    secondary = BrandGreen,
    tertiary = BrandYellow
)

private val DarkColors = darkColorScheme(
    primary = BrandYellow,
    secondary = BrandGreen
)

@Composable
fun AutoRaidTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography,
        content = content
    )
}
