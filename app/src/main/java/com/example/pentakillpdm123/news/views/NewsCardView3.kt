package com.example.pentakillpdm123.news.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pentakillpdm123.R

@Composable
fun NewsCardView3() {
    Column {
        Text(
            text = "10th Year Anniversary!",
            color = Color.Black, // Color del texto
            fontSize = 24.sp // Tamaño del texto en sp

        )
        Spacer(modifier = Modifier.height(5.dp))
        Box(
            modifier = Modifier
                .height(150.dp)
                .width(350.dp)
                .clip(RoundedCornerShape(20.dp))
                .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(20.dp))
        ) {


            Image(
                painter = painterResource(id = R.drawable.anniversary),
                contentDescription = "imagen",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxSize()
            )
        }

    }

}
@Preview
@Composable
fun PreviewNewsCardView3(){
    NewsCardView3()
}