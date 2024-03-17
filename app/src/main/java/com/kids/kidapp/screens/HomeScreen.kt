package com.kids.kidapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import com.kids.kidapp.data.ListData


@Composable
fun HomeScreen(data: ListData, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
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
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                // Image
                Image(
                    painter = painterResource(id = R.drawable.clipper1),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopStart)
                )
            }
        }

        Text(
            text = data.name,
            style = MaterialTheme.typography.headlineSmall,
            color = Color.Black,
            fontFamily = FontFamily.Serif,
            modifier = Modifier
                .padding(top = 10.dp)
                .align(Alignment.CenterHorizontally)


        )
    }
}




@Composable
fun PreviewBoxWithText(navController: NavHostController) {
    val items = listOf(
        ListData("Hair Clipper", 1, "https://example.com/image1.jpg"),
        ListData("Air horn", 2, "https://example.com/image2.jpg"),
    ListData("Hair Clipper", 1, "https://example.com/image1.jpg"),
    ListData("Air horn", 2, "https://example.com/image2.jpg"),
    ListData("Hair Clipper", 1, "https://example.com/image1.jpg"),
    ListData("Air horn", 2, "https://example.com/image2.jpg"))
    MyListView(items,navController)
}

@Composable
fun MyListView(items: List<ListData>,navController: NavHostController) {

    Text(
        text = "Funny Sound",
        style = MaterialTheme.typography.headlineSmall,
        color = Color.Black,
        fontFamily = FontFamily.Serif,
        modifier = Modifier
            .padding(start = 30.dp)



    )
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        content = {
            items(items.size) { index ->
                val item = items[index]
            HomeScreen(data = item,navController=navController)
            }
        },
        modifier = Modifier.
        fillMaxSize().padding(bottom = 56.dp)
            .padding(top = 40.dp)

    )


}





