package com.example.pentakillpdm123.home.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import com.example.pentakillpdm123.R

@Composable
fun MatchCardView(team1Image: String,team2Image: String, team1: String, team2: String, gameName: String, teamGp: String,matchName: String){
    Box(modifier = Modifier
        .height(90.dp)
        .width(180.dp)
        .clip(RoundedCornerShape(5.dp))
        .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))) {
    Column(modifier = Modifier
        .fillMaxSize()
        .clip(RoundedCornerShape(5.dp))
        .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(5.dp)))
    {
    Row (modifier = Modifier
        .height(50.dp)
        .fillMaxWidth()
        .clip(RoundedCornerShape(5.dp))
        .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))){
    Box(modifier = Modifier
        .fillMaxHeight()
        .width(30.dp)
        .clip(RoundedCornerShape(5.dp))
        .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))){
    Text(team1)
    }
    Box(modifier = Modifier
        .fillMaxHeight()
        .width(30.dp)
        .clip(RoundedCornerShape(5.dp))
        .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))){
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
    Box(modifier = Modifier
        .fillMaxHeight()
        .width(60.dp)
        .clip(RoundedCornerShape(5.dp))
        .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))){
        Text(teamGp)
    }
    Box(modifier = Modifier
        .fillMaxHeight()
        .width(30.dp)
        .clip(RoundedCornerShape(5.dp))
        .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))){
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
    Box(modifier = Modifier
        .fillMaxHeight()
        .width(30.dp)
        .clip(RoundedCornerShape(5.dp))
        .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))){
        Text(team2)
    }
    }
    Row (modifier = Modifier
        .height(40.dp)
        .fillMaxWidth()
        ){
    Box(modifier = Modifier
        .fillMaxHeight()
        .width(40.dp)
        .clip(RoundedCornerShape(5.dp))
        .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))){
        Text(gameName)
        Text(matchName)
    }
    }


    }


    }
}

@Preview
@Composable
fun PreviewMatchCardView(){

}