package com.example.pleasedontbered2

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(contextForToast: Context, name: String) {
    var expanded by remember { mutableStateOf(false) }

    Surface(
        color = Color.White, // กำหนดสีพื้นหลังของ TopAppBar เป็นสีขาว
//        elevation = AppBarDefaults.TopAppBarElevation,
        modifier = Modifier.fillMaxWidth() // ให้ TopAppBar ทำเต็มพื้นที่ความกว้าง
    ) {
        CenterAlignedTopAppBar(
            title = {
                Text(text = name, fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
            }
        )
    }
}






@Composable
fun MyBottomBar(navController: NavController, contextForToast: Context) {
    val navigationItems = listOf(
        Screen.Home,
        Screen.ComunityScreen,
        Screen.Setting,
    )

    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.White,
                        Color.LightGray
                    )
                ),
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp) // กำหนดมุมโค้งด้านบน
            )
            .padding(0.dp, 8.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        navigationItems.forEach { screen ->
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(
                        color = if (currentRoute == screen.route) {
                            Color.LightGray.copy(alpha = 0.5f)
                        } else {
                            Color.Transparent
                        }
                    )
                    .clickable {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
//                        Toast.makeText(contextForToast, screen.name, Toast.LENGTH_SHORT).show()
                    }
                    .padding(8.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = null,
                        tint = if (currentRoute == screen.route) {
                            Color.Black
                        } else {
                            Color.Gray
                        }
                    )
                    Text(
                        text = screen.name,
                        fontSize = 16.sp,
                        color = if (currentRoute == screen.route) {
                            Color.Black
                        } else {
                            Color.Gray
                        }
                    )
                }
            }
        }
    }
}



@Composable
fun BackButton(navController: NavController) {
    val coroutineScope = rememberCoroutineScope()
    Box(
        modifier = Modifier
            .padding(start = 26.dp, bottom = 16.dp) // กำหนดระยะห่างด้านซ้ายและด้านล่าง
            .fillMaxWidth(), // ทำให้ FloatingActionButton เต็มความกว้างของหน้าจอ
        contentAlignment = Alignment.CenterStart // ให้ Floating Action Button อยู่ด้านล่างซ้ายของ Box
    ) {
        FloatingActionButton(
            onClick = { coroutineScope.launch { navController.popBackStack() } }
        ) {
            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
        }
    }
}