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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.kids.kidapp.R
import com.kids.kidapp.data.GetListData
import com.kids.kidapp.data.ListData


@Composable
fun HomeScreen(data: ListData, navController: NavHostController) {
    SoundList(data = data, navController =navController ,ScreenType.Home)
}




@Composable
fun PreviewBoxWithText(navController: NavHostController) {
    val getListData= GetListData(LocalContext.current).getData()
    MyListView(getListData,navController)
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
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 56.dp)
            .padding(top = 40.dp)
            .padding(start = 20.dp)
            .padding(end = 20.dp)

    )


}





