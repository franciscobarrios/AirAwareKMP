package com.fjbg.airaware.kmp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fjbg.airaware.kmp.networking.AqiClient
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(client: AqiClient) {
    MaterialTheme {
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "home") {
            composable("home") {

                val viewModel = viewModel<MainViewModel> {
                    MainViewModel(client)
                }

                val aqi = viewModel.getAqi.collectAsState()

                Column(
                    Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
                ) {
                    Button(onClick = {
                        viewModel.getIAqi()
                    }) {
                        Text("Button")
                    }
                }
            }
        }
    }
}