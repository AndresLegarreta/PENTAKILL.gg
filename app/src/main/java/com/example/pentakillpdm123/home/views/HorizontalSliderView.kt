package com.example.pentakillpdm123.home.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp




@Composable
fun HorizontalSliderView(){

    data class ImportedView(
        val id: Int,
        val view: @Composable () -> Unit
    )

    val importedViews: List<ImportedView> = listOf(
        ImportedView(id = 1, view = { MatchCardView() }),
        ImportedView(id = 2, view = { Match2CardView() }),
        ImportedView(id = 3, view = { Match3CardView() })
    )


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .clipToBounds()
    ) {
        LazyRow {
            items(importedViews) { importedView ->
                importedView.view()
            }
        }

    }


}

@Preview
@Composable
fun HorizontalSliderPreview(){
    HorizontalSliderView()
}
