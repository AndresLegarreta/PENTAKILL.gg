package com.example.pentakillpdm123.home.views


import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pentakillpdm123.BottomNavBar
import com.example.pentakillpdm123.R
import com.example.pentakillpdm123.home.model.LeagueModel
import com.example.pentakillpdm123.home.viewModel.HomeViewModel


@Composable
fun HomeMainView(navController: NavController, viewModel: HomeViewModel) {
    val leagueCards by viewModel.leagueCards.observeAsState(emptyList())

    LaunchedEffect(Unit){
        viewModel.fetchLeagueCards()
    }
    Scaffold(
        topBar = { TopAppBar(title = { androidx.compose.material.Text("Home") }) },
        content = { it
            Column(modifier = Modifier.fillMaxSize()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(740.dp)
                ) {
                    Spacer(modifier = Modifier.width(20.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(700.dp)
                            .clipToBounds()
                    ) {
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = "Home",
                            color = Color.Black,
                            fontSize = 28.sp

                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                        ) {
                            LazyRow(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                            ){
                                items(leagueCards){
                                    leagueCard ->

                                    LeagueCardView(leagueCard.nombre, leagueCard.region, leagueCard.imagen)

                                }
                            }





                        }
                        Spacer(modifier = Modifier.height(45.dp))
                        Text(
                            text = stringResource(id = R.string.today_matches),
                            color = Color.Black,
                            fontSize = 20.sp

                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Text(
                            text = stringResource(id = R.string.datematch),
                            color = Color.Gray,
                            fontSize = 20.sp

                        )
                        Spacer(modifier = Modifier.height(45.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(90.dp)
                                .clipToBounds()
                        ) {
                            HorizontalSliderView()

                        }
                        Spacer(modifier = Modifier.height(45.dp))
                        Text(
                            text = stringResource(id = R.string.pastmatch),
                            color = Color.Black,
                            fontSize = 20.sp

                        )
                        Spacer(modifier = Modifier.height(5.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(350.dp)
                                .clipToBounds()
                        ) {
                            HorizontalSliderView2()
                        }
                        Spacer(modifier = Modifier.height(5.dp))
                        Row(modifier = Modifier.fillMaxWidth()) {

                        }
                    }
                }
            }
        } ,
        bottomBar = { BottomNavBar(navController = navController) }
    )
}

