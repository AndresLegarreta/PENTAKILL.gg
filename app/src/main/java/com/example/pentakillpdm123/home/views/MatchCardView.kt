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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.sp
import com.example.pentakillpdm123.R

@Composable
fun MatchCardView(team1Image: String,team2Image: String, team1: String, team2: String, gameName: String, teamGp: String){
    Box(modifier = Modifier
        .height(120.dp)
        .width(200.dp)
        .clip(RoundedCornerShape(5.dp))
        .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))
        .background(color = Color.DarkGray)) {
    Column(modifier = Modifier
        .fillMaxSize()
        .clip(RoundedCornerShape(5.dp))
        )
    {
    Row (modifier = Modifier
        .height(60.dp)
        .fillMaxWidth()
        .clip(RoundedCornerShape(5.dp))

        ){
    Box(modifier = Modifier
        .fillMaxHeight()
        .width(40.dp)
        .clip(RoundedCornerShape(5.dp))

        ){
    Text(team1, fontSize = 15.sp,color= Color.White)
    }
    Box(modifier = Modifier
        .fillMaxHeight()
        .width(30.dp)
        .clip(RoundedCornerShape(5.dp))
        ){
        val image  = rememberImagePainter(team1Image)
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
    Box(modifier = Modifier
        .fillMaxHeight()
        .width(40.dp)
        .clip(RoundedCornerShape(5.dp))
        ,contentAlignment = Alignment.Center){
        Text(teamGp, fontSize = 20.sp,color= Color.White)
    }
    Box(modifier = Modifier
        .fillMaxHeight()
        .width(30.dp)
        .clip(RoundedCornerShape(5.dp))
        ){
        val image  = rememberImagePainter(team2Image)
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
    Box(modifier = Modifier
        .fillMaxHeight()
        .width(40.dp)
        .clip(RoundedCornerShape(5.dp))
        ){
        Text(team2, fontSize = 15.sp,color= Color.White)
    }
    }
    Row (modifier = Modifier
        .height(60.dp)
        .fillMaxWidth()
        ){
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .clip(RoundedCornerShape(5.dp))
        ){
        Column(modifier = Modifier.fillMaxSize()){
            Text(gameName,color= Color.White)

        }
    }
    }


    }


    }
}

@Preview
@Composable
fun PreviewMatchCardView(){

}