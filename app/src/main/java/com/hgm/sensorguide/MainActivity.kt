package com.hgm.sensorguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hgm.sensorguide.ui.theme.SensorGuideTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
      override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                  SensorGuideTheme {
                        val viewModel = viewModel<MainViewModel>()
                        val isDark = viewModel.isDark

                        Box(
                              modifier = Modifier
                                    .fillMaxSize()
                                    .background(if (isDark) Color.DarkGray else Color.White),
                              contentAlignment = Alignment.Center
                        ) {
                              Text(
                                    text = if (isDark) "当前环境光线：Dark" else "当前环境光线：Light",
                                    color = if (isDark) Color.White else Color.DarkGray
                              )
                        }
                  }
            }
      }
}
