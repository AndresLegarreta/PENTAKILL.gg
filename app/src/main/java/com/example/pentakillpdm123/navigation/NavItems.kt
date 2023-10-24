package com.example.pentakillpdm123.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

fun NavItems(){
    val navItems = listOf(
        BarItems.Home,
        BarItems.News,
        BarItems.Stream,
        BarItems.Social,
        BarItems.Profile

    )
}
@Preview
@Composable
fun NavItemsPreview(){
    NavItems()
}