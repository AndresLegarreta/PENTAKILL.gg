package com.example.pentakillpdm123.home.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pentakillpdm123.BottomNavBar
import com.example.pentakillpdm123.home.viewModel.HomeViewModel
import com.example.pentakillpdm123.home.viewModel.NewsViewModel

@Composable
fun NewsView(navController: NavController, viewModel: NewsViewModel){
    val newsCards by viewModel.newsCards.observeAsState(emptyList())

    LaunchedEffect(Unit){
        viewModel.fetchNews()
    }
    Scaffold(
        bottomBar = { BottomNavBar(navController) }
    ) { it
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(740.dp)) {
        Spacer(modifier = Modifier.width(20.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(700.dp)
                .clipToBounds()
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "News",
                color = Color.Black,
                fontSize = 28.sp

            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(600.dp)
            ) {
                items(newsCards) { newsCard ->

                    NewsCardView(newsCard.nombrenot, newsCard.imagennot, newsCard.link)

                }
            }
        }
    }
    }
}