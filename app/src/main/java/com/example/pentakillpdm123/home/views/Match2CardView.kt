package com.example.pentakillpdm123.home.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.pentakillpdm123.R

@Composable
fun Match2CardView(){
    Box(modifier = Modifier
        .height(90.dp)
        .width(180.dp)
        .clip(RoundedCornerShape(5.dp))
        .border(width = 1.dp, color = Color.White, shape = RoundedCornerShape(5.dp))) {


        Image(painter = painterResource(id = R.drawable.match2),
            contentDescription = "imagen", contentScale = ContentScale.FillBounds, modifier = Modifier.fillMaxSize())
    }
}

@Preview
@Composable
fun PreviewMatch2CardView(){
    Match2CardView()
}