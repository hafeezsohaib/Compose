package com.kids.kidapp.screens


import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kids.kidapp.data.ListData
import com.kids.kidapp.soundHandle.SoundManage

@Composable
fun SoundList(data: ListData,
              navController: NavHostController,
              screenType: ScreenType) {
    val context= LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        ElevatedCard(

            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .clickable {
                    when (screenType) {
                        is ScreenType.Home -> {
                            // Perform home screen action
                            navController.currentBackStackEntry?.savedStateHandle?.set(key="data",value = data)
                            navController.navigate("detailsScreen/$data")

                        }
                        is ScreenType.Detail -> {
                            // Perform detail screen action

                            val mediaPlayer = SoundManage(context).loadSound(data)
                             mediaPlayer?.start()
                        }
                    }


                }
                .fillMaxWidth()
                .height(115.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
                    .background(Color(android.graphics.Color.parseColor(data.color)))
            ) {
                // Image

                val resourceId = LocalContext.current.resources.getIdentifier(data.imageUrl, "drawable", LocalContext.current.packageName)

                Image(
                    painter = painterResource(id = resourceId),
                    contentDescription = null,
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .align(Alignment.Center)

                )
            }
        }

        Text(
            text = data.name,
            style = MaterialTheme.typography.headlineSmall,
            color = androidx.compose.ui.graphics.Color.Black,
            fontFamily = FontFamily.Serif,
            modifier = Modifier
                .padding(top = 10.dp)
                .align(Alignment.CenterHorizontally)


        )
    }
}
sealed class ScreenType {
    object Home : ScreenType()
    object Detail : ScreenType()
}

