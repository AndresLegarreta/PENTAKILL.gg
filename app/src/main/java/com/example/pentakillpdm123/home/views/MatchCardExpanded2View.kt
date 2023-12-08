package com.example.pentakillpdm123.home.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.pentakillpdm123.R

@Composable
fun MatchCardExpanded2View(
    team1Image: String,
    team2Image: String,
    team1: String,
    team2: String,
    gameName: String,
    teamGp: String,
    matchName: String,
    matchImage: String
) {
    Box(
        modifier = Modifier
            .height(290.dp)
            .width(360.dp)
            .clip(RoundedCornerShape(20.dp))
            .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(20.dp))
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
            ) {
                val image  = rememberImagePainter(matchImage)
                Image(
                    painter = image,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(5.dp)),
                    contentScale = ContentScale.FillHeight
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp)
                        .background(color = Color.DarkGray)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(55.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .height(60.dp)
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(5.dp))
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(60.dp)
                                    .clip(RoundedCornerShape(5.dp))
                            ) {
                                Text(team1, fontSize = 20.sp, color = Color.White)
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(50.dp)
                                    .clip(RoundedCornerShape(5.dp))
                            ) {
                                val image = rememberImagePainter(team1Image)
                                Image(
                                    painter = image,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .clip(RoundedCornerShape(5.dp)),
                                    contentScale = ContentScale.FillHeight
                                )
                            }
                            Spacer(modifier = Modifier.width(15.dp))
                            Box(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(80.dp)
                                    .clip(RoundedCornerShape(5.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(teamGp, fontSize = 25.sp, color = Color.White)
                            }
                            Box(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(70.dp)
                                    .clip(RoundedCornerShape(5.dp))
                            ) {
                                val image = rememberImagePainter(team2Image)
                                Image(
                                    painter = image,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .clip(RoundedCornerShape(5.dp)),
                                    contentScale = ContentScale.FillHeight
                                )
                            }
                            Spacer(modifier = Modifier.width(5.dp))
                            Box(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .width(60.dp)
                                    .clip(RoundedCornerShape(5.dp))
                            ) {
                                Text(team2, fontSize = 15.sp, color = Color.White)
                            }
                        }
                    }
                    Row(modifier = Modifier.fillMaxWidth().height(55.dp)) {
                        Box(
                            modifier = Modifier
                                .height(80.dp)
                                .width(80.dp)
                                .clip(RoundedCornerShape(5.dp))
                        ) {
                            Text(gameName, color = Color.White, fontSize = 20.sp)
                        }
                        Box(
                            modifier = Modifier
                                .height(80.dp)
                                .width(230.dp)
                                .clip(RoundedCornerShape(5.dp))
                        ) {
                            Text(matchName, color = Color.White, fontSize = 20.sp)
                        }

                        // Accede a la propiedad teamGp de matchExCard
                        Box(
                            modifier = Modifier
                                .height(80.dp)
                                .width(230.dp)
                                .clip(RoundedCornerShape(5.dp))
                        ) {
                            Text(teamGp, color = Color.White, fontSize = 20.sp)
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewMatchCardExpanded2View(){
    // Puedes añadir datos de prueba si es necesario
}