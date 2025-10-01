package com.example.vknewsclient.ui.theme

import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val fabVisible = remember {
        mutableStateOf(true)
    }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    scope.launch {
                        val action = snackbarHostState.showSnackbar(
                            message = "This is snackbar",
                            actionLabel = "Hide FAB",
                            duration = SnackbarDuration.Long
                        )
                        if (action == SnackbarResult.ActionPerformed) {
                            fabVisible.value = false
                        }
                    }
                },
            ) {
                Icon(Icons.Filled.Favorite, null)
            }
        },
        bottomBar = {
            BottomNavigation {

                val state = remember {
                    mutableStateOf(0)
                }

                val navigationItems = listOf(
                    NavigationItem.Home,
                    NavigationItem.Favorite,
                    NavigationItem.Profile
                )

                navigationItems.forEachIndexed { index, item ->
                    BottomNavigationItem(
                        selected = state.value == index,
                        onClick = { state.value = index },
                        label = { Text(stringResource(item.titleResId)) },
                        icon = { Icon(item.icon, contentDescription = null) }
                    )
                }
            }
        }
    ) {

    }
}