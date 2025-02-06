package com.fjbg.airaware.kmp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fjbg.airaware.kmp.networking.AqiClient
import io.ktor.client.HttpClient
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview
import util.onError
import util.onSuccess

@Composable
@Preview
fun App(client: AqiClient) {
    MaterialTheme {

        val scope = rememberCoroutineScope()

        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
        ) {
            Button(onClick = {
                scope.launch {
                    client.getAqi().onSuccess {
                        println(it)
                    }.onError {
                        println(it)
                    }
                }
            }) {
                Text("Button")
            }
        }
    }
}