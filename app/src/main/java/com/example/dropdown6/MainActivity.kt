package com.example.dropdown6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldDemo()

        }
    }
}
@Preview
@Composable
fun ScaffoldDemo() {
    val materialBlue700 = Color(0xebeff3)
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Open))
    val navController = rememberNavController()
    Scaffold(
        scaffoldState = scaffoldState,
        drawerElevation = 5.dp,
        topBar = {
            TopAppBar(
                title = { Text("Company Generator") },
                backgroundColor = materialBlue700
            )
        },
//        content = { MainScreen() },
//        floatingActionButtonPosition = FabPosition.End,
//        floatingActionButton = {
//            FloatingActionButton(onClick = {}) {
//                Text("+") // :)
//            }
//        },

        bottomBar = { BottomNavigationBar(navController = navController) },
    )
    {
        Navigation(navController = navController)
    }
}

@Composable
fun BottomBar() {
    BottomAppBar(
        modifier = Modifier.padding(1.dp),

        backgroundColor = colorResource(id = R.color.black),
        contentColor = Color.Black,
                content = { HomeScreen() },
    )
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    BottomBar()
}


