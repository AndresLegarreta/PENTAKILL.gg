package com.example.pentakillpdm123.home.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pentakillpdm123.R

@Composable
fun LeagueCardView(){
    Box(modifier = Modifier
        .clip(RoundedCornerShape(27.dp))
        .border(width = 1.dp, color = Color.White, shape = RoundedCornerShape(27.dp))) {


        Image(painter = painterResource(id = R.drawable.aatrox), contentDescription = "imagen" )
    }

}


@Preview
@Composable
fun PreviewLeagueCardView(){
    LeagueCardView()
}