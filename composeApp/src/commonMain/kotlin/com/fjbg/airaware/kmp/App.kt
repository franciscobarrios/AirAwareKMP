package com.fjbg.airaware.kmp

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fjbg.airaware.kmp.di.appModules
import com.fjbg.airaware.kmp.model.AqiDto
import org.koin.compose.KoinApplication
import org.koin.compose.currentKoinScope

@Composable
fun App() {
    KoinApplication(application = {
        modules(appModules())
    }) {
        MaterialTheme {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "home") {
                composable("home") {

                    val viewModel = koinViewModel<MainViewModel>()
                    val state = viewModel.getAqi.collectAsState()

                    Column(
                        Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(
                            16.dp,
                            Alignment.CenterVertically
                        )
                    ) {
                        when (state.value) {
                            is MainViewModel.UiState.Loading -> {
                                LoadingView()
                            }
                            is MainViewModel.UiState.Error -> {
                                ErrorView()
                            }
                            is MainViewModel.UiState.Success -> {
                                Content()

                                (state.value as MainViewModel.UiState.Success).data

                                //println("DATA::: ${(state.value.data}")

                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Content() {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .weight(.2f, true)

        ) {
            CityInfo()
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .weight(.6f, true)
        ) {
            AqiText()
            AqiCircle()
        }

        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .weight(.2f, true)
        ) {

            History()
            History()
            History()
        }
    }
}

@Composable
fun CityInfo() {
    Text(
        "Bangkok, Thailand",
        fontSize = 32.sp,
        color = Color.Gray,
        modifier = Modifier.padding(16.dp),
        maxLines = 1
    )
}

@Composable
fun AqiText() {
    Text(
        "98",
        fontSize = 102.sp,
        color = Color.DarkGray,
        modifier = Modifier.padding(16.dp),
        maxLines = 1
    )
}


@Composable
fun AqiCircle() {
    Canvas(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        onDraw = {
            drawCircle(
                color = Color.Gray,
                radius = 340f,
                style = Stroke(width = 24f),
                center = size.center
            )
        }
    )
}

@Composable
fun History() {
    Canvas(
        modifier = Modifier
            .padding(16.dp),
        onDraw = {
            drawRoundRect(
                color = Color.Red,
                cornerRadius = CornerRadius(10f, 10f),
                size = Size(32f, 240f)
            )
        }
    )
    Text("M")
}

@Composable
fun LoadingView() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorView() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Something went wrong")
    }
}

@Composable
inline fun <reified T : ViewModel> koinViewModel(): T {
    val scope = currentKoinScope()
    return viewModel {
        scope.get<T>()
    }
}