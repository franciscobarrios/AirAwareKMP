package com.fjbg.airaware.kmp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fjbg.airaware.kmp.di.appModules
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
                            is MainViewModel.UiState.Loading -> LoadingView()
                            is MainViewModel.UiState.Error -> ErrorView()
                            is MainViewModel.UiState.Success -> {}
                        }
                    }
                }
            }
        }
    }
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