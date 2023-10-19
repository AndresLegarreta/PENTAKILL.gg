package com.example.pentakillpdm123.positionchamp

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.util.VelocityTracker
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pentakillpdm123.R
import kotlin.math.roundToInt
import androidx.compose.foundation.Image


@Composable
fun PositionChamp() {
    val roles = listOf(
        Role("Top-Lane", painterResource(id = R.drawable.toplane)),
        Role("Jungler", painterResource(id = R.drawable.jungler)),
        Role("Mid-Lane", painterResource(id = R.drawable.midlane)),
        Role("Adc", painterResource(id = R.drawable.botlane)),
        Role("Support", painterResource(id = R.drawable.support))
    )

    val orderedRoles = remember { mutableStateOf(roles) }
    val listState = rememberLazyListState()

    LazyColumn(state = listState) {
        items(orderedRoles.value) { role ->  // <-- Usar orderedRoles.value
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(Color.Gray)
                    .draggable(
                        state = rememberDraggableState { delta ->
                            // Lógica para reordenar
                        }
                    )
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Cambiar Icon por Image
                    Image(painter = role.painter, contentDescription = null)
                    Text(text = role.name)
                    Text(text = (orderedRoles.value.indexOf(role) + 1).toString())
                }
            }
        }
    }
}


data class Role(val name: String, val painter: Painter)


