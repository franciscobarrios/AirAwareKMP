package com.airaware.mobile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airaware.mobile.networking.AqiHttpClient
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview
import util.NetworkError
import util.map

@Composable
@Preview
fun App(client: AqiHttpClient) {
    MaterialTheme {

        val scope = rememberCoroutineScope()

        var isLoading by remember {
            mutableStateOf(false)
        }
        var errorMessage by remember {
            mutableStateOf<NetworkError?>(null)
        }

        var text by remember {
            mutableStateOf<String?>(null)
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        ) {
            Button(onClick = {
                scope.launch {
                    scope.launch {
                        isLoading = true
                        errorMessage = null

                        val s = client.getAqi("4451728cc993ee1e86af7beeb147657bddd56d46")
                        s.map {
                            println(it)
                        }
                    }
                }
            }) {

            }
        }
    }
}