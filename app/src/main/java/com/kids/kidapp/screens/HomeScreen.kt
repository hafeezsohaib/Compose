package com.kids.kidapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kids.kidapp.R


@Composable
fun HomeScreen(text: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),

        ) {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier

                .background(Color.Black)
                .padding(
                    top = 20.dp,
                    start = 15.dp,
                    end = 15.dp
                )
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                // Image
                Image(
                    painter = painterResource(id = R.drawable.c),
                    contentDescription = null,
                    modifier = Modifier

                        .align(Alignment.TopStart)
                )

                // Text
                Text(
                    text = text,
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.White,
                    fontFamily = FontFamily.Serif,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(end = 20.dp)

                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewBoxWithText() {
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
    MyListView(items)
}

@Composable
fun MyListView(items: List<String>) {
    LazyColumn {
        items(items.size) { index ->
            // Use index to get each item from the list
            val item = items[index]
            HomeScreen(text = item)
        }
    }
}
interface ItemClickListener {
    fun onItemClick(item: String)
}


