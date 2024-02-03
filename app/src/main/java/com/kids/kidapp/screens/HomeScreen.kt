package com.kids.kidapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kids.kidapp.R


@Composable
fun HomeScreen(data: String,navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White

        ) {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .clickable {
                    println("data compose::::$data")
                    navController.navigate("detailsScreen/$data")

                }
                .padding(
                    top=10.dp,
                    start = 10.dp,
                    end = 10.dp,
                    bottom = 10.dp

                )
                .fillMaxWidth()
                .background(Color.White)

        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                // Image
                Image(
                    painter = painterResource(id = R.drawable.c),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .fillMaxWidth()
                )

                // Text
                Text(
                    text = data,
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White,
                    fontFamily = FontFamily.Serif,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(end = 30.dp)
                        .padding(bottom = 10.dp)

                )
            }
        }
    }
}



@Composable
fun PreviewBoxWithText(navController: NavHostController) {
    val items = listOf(
        "Workout in Gym",
        "Workout Home",
        "workout",
        "Workout in Gym",
        "SK",
        "Suheb",
        "Workout in Gym",
        "workout",
        "workout",
        "Workout in Gym",
        "Sohaib",
        "Khan",
        "Workout in Gym",
        "workout",
        "workout",
        "Workout in Gym",
        "SK",
        "Suheb",
        "Sohaib",
        "Khan",
        "Workout in Gym",
        "workout",
        "workout",
        "Workout in Gym",
        "Suheb",
        "Sohaib",
        "Khan",
        "S.Khan...",
        "SK",
        "Suheb",
        "Sohaib",
        "Khan",
        "S.Khan...",
        "Workout in Gym",
        "workout",
        "workout",
        "Workout in Gym",
        "SK"
    )
    MyListView(items,navController)
}

@Composable
fun MyListView(items: List<String>,navController: NavHostController) {
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 56.dp)
    ){
        items(items.size) { index ->
            // Use index to get each item from the list
            val item = items[index]
            HomeScreen(data = item,navController=navController)
        }
    }
}



