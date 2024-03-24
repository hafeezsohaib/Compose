package com.kids.kidapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.compose.runtime.*
import androidx.compose.ui.text.font.FontFamily

import com.kids.kidapp.R
import com.kids.kidapp.data.ListData


@Composable
fun DetailsScreen(listData: ListData, phone: String, navController: NavHostController) {

    Text(text = "Item Name: $listData")
    Text(text = "Phone: $phone")
    YourComposable()
    listData.dataSound?.let { PhoneScreen(it, navController) }
}

@Composable
fun CircularBackground(
    modifier: Modifier = Modifier,
    color: Color = Color.Gray,
    shape: Shape = CircleShape,
    size: Dp = 100.dp, // Diameter of the circle
    margin: Dp = 150.dp
) {
    Box(
        modifier = modifier
            .size(size)
            .background(color, shape)
            .padding(margin)
    )
}

@Preview
@Composable
fun YourComposable() {
//PhoneScreen()

}

@Composable
fun PhoneScreen(items: List<ListData>, navController: NavHostController,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White,
) {


    Box(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor),
        contentAlignment = Alignment.TopCenter
    ) {
        TopAppBar(
            title = {
                Text(
                    text = "Detail Screen",
                )
            },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_back),
                        contentDescription = "Back"
                    )
                }
            },
            backgroundColor = Color.White,
        )
        Column(
            modifier = Modifier.padding(top = 150.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier.size(250.dp),
                contentAlignment = Alignment.Center
            ) {
                CircularBackground(
                    color = Color.Magenta,
                    size = 250.dp,
                    margin = 100.dp
                )
                Image(
                    painter = painterResource(id = R.drawable.air),
                    contentDescription = "Your Image",
                    modifier = Modifier.size(120.dp)
                )
            }
            Spacer(modifier = Modifier.height(50.dp))
            ToggleButton()
            Spacer(modifier = Modifier.height(30.dp))

            MyHorizontalGridView(items,navController)


        }
    }
}


@Composable
fun ToggleButton() {
    var isPlaying by remember { mutableStateOf(false) }

    Button(
        onClick = {
            isPlaying = !isPlaying // Toggle the play/pause state
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = if (isPlaying) Color(0xFFA4C639) else Color(0xFFFFAC1C)),
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = if (isPlaying) "Pause" else "Play",
            color = Color.White,
            modifier = Modifier.padding(vertical = 16.dp, horizontal = 20.dp)
        )
    }
}


@Composable
fun MyHorizontalGridView(items: List<ListData>, navController: NavHostController) {
    Text(
        text = "Click on Play",
        style = MaterialTheme.typography.headlineSmall,
        color = Color.Black,
        fontFamily = FontFamily.Serif,
        modifier = Modifier.padding(start = 10.dp)
    )
    LazyRow(
        content = {
            items(items.size) { index ->
                val item = items[index]
                SoundList(data = item, navController =navController ,ScreenType.Detail)
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 56.dp)
            .padding(top = 40.dp)
    )
}



