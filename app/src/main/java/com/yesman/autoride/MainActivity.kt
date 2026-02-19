package com.yesman.autoride

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.yesman.autoride.ui.AutoRaidApp
import com.yesman.autoride.ui.theme.AutoRaidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AutoRaidTheme {
                AutoRaidApp()
            }
        }
    }
}
