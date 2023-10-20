package com.example.pentakillpdm123.home.views


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeMainView(){
    Row (modifier = Modifier.fillMaxSize()){
        Spacer(modifier = Modifier.width(20.dp))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .clipToBounds()
        ){
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "Home",
                color = Color.Black, // Color del texto
                fontSize = 28.sp // Tamaño del texto en sp

            )
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier= Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ){

                LecCardView()
                Spacer(modifier= Modifier.width(5.dp))
                LckCardView()
                Spacer(modifier= Modifier.width(5.dp))
                LcsCardView()
                Spacer(modifier= Modifier.width(5.dp))
                WorldsCardView()


            }
            Spacer(modifier = Modifier.height(45.dp))
            Text(
                text = "Today Matches",
                color = Color.Black, // Color del texto
                fontSize = 20.sp // Tamaño del texto en sp

            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "Tusday - September 19th",
                color = Color.Gray, // Color del texto
                fontSize = 20.sp // Tamaño del texto en sp

            )
            Spacer(modifier = Modifier.height(45.dp))
            Box(
                modifier= Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .clipToBounds()
            ){
                Row (modifier = Modifier.fillMaxSize()){
                    MatchCardView()
                    Spacer(modifier = Modifier.width(15.dp))
                    Match2CardView()
                    Spacer(modifier = Modifier.width(15.dp))
                    Match3CardView()
                }
            
            }
            Spacer(modifier = Modifier.height(45.dp))
            Text(
                text = "Past Matches",
                color = Color.Black, // Color del texto
                fontSize = 20.sp // Tamaño del texto en sp

            )
            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier= Modifier
                    .fillMaxWidth()
                    .height(350.dp)
            ){
                MatchCardExpanded2View()
            }

        }
    }




}
@Preview
@Composable
fun HomeMainPreview(){
HomeMainView()
}