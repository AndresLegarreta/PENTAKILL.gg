package com.example.pentakillpdm123.home.views

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter


@Composable
fun NewsCardView(nombrenot: String, imagennot: String, link: String) {
    val context = LocalContext.current
    Column(modifier = Modifier.fillMaxWidth().height(200.dp)) {
        // Texto para mostrar el nombre de la noticia
        Text(
            text = nombrenot,
            color = Color.Black,
            fontSize = 20.sp
        )

        // Contenedor Box que contiene la imagen de la noticia y es clickeable
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(320.dp)
                .clip(RoundedCornerShape(5.dp))
                .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(5.dp))
                .clickable {
                    // Acción a realizar cuando se hace clic en la imagen (puedes abrir el enlace aquí)
                    // Por ejemplo, abrir el enlace en un navegador
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
                    context.startActivity(intent)
                }
        ) {
            // Imagen de la noticia cargada mediante Coil
            val image = rememberImagePainter(imagennot)
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(5.dp)),
                contentScale = ContentScale.FillBounds
            )
        }
    }
}


@Composable
@Preview
fun NewsCardViewPreview(){

}