package com.example.pentakillpdm123.positionchamp

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.input.pointer.util.VelocityTracker
import androidx.compose.foundation.background
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
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.pentakillpdm123.navigation.NavRoutes
import kotlin.collections.indexOf

@Composable
fun PositionChamp(navController: NavController) {
    val roles = remember {
        mutableStateListOf(
            Role("Top-Lane", R.drawable.toplane),
            Role("Jungler", R.drawable.jungler),
            Role("Mid-Lane", R.drawable.midlane),
            Role("Adc", R.drawable.botlane),
            Role("Support", R.drawable.support)
        )
    }

    val currentlyDragging = remember { mutableStateOf(-1) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth().height(650.dp) // Reducir la altura un poco para dar espacio al botón.
        ) {
            itemsIndexed(roles) { index, role ->

                val isBeingDragged = currentlyDragging.value == index

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .run {
                            if (isBeingDragged) {
                                shadow(30.dp)
                            } else {
                                this
                            }
                        }
                        .draggable(
                            orientation = Orientation.Vertical,
                            state = rememberDraggableState { delta ->
                                val nextIndex = (index + if (delta < 0) -1 else 1)
                                if (nextIndex in roles.indices) {
                                    roles.removeAt(index)
                                    roles.add(nextIndex, role)
                                    currentlyDragging.value = nextIndex
                                }
                            },
                            onDragStarted = {
                                currentlyDragging.value = index
                            },
                            onDragStopped = {
                                currentlyDragging.value = -1
                            }
                        )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = role.imageResourceId),
                            contentDescription = null
                        )

                        Spacer(modifier = Modifier.width(5.dp))
                        Text(text = role.name)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(40.dp)) // Espacio para empujar el botón hacia arriba.

        Button(
            onClick = { navController.navigate(NavRoutes.homemainview.route) },
            shape = RoundedCornerShape(50),
            colors = ButtonDefaults.buttonColors(Color.Red)
        ) {
            Text(
                text = "Continue",
                modifier = Modifier.padding(vertical = 5.dp, horizontal = 20.dp),
                color = Color.White,
                style = androidx.compose.material3.MaterialTheme.typography.bodyLarge
            )
        }
    }
}

data class Role(val name: String, val imageResourceId: Int)
