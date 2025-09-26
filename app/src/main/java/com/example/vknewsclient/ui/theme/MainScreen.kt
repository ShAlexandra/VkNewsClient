package com.example.vknewsclient.ui.theme

import android.annotation.SuppressLint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    Scaffold(
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