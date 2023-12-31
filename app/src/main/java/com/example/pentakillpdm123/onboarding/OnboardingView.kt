package com.example.pentakillpdm123

import androidx.compose.foundation.Image
import androidx.annotation.FloatRange
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.annotation.IntRange
import androidx.compose.foundation.clickable
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pentakillpdm123.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.pentakillpdm123.login.PreferencesManager
import com.example.pentakillpdm123.navigation.NavRoutes
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun OnBoardingView(navController: NavController) {
    val items = ArrayList<OnBoardingData>()


    items.add(
        OnBoardingData(
            R.drawable.aatrox,
            "",
            R.string.aatrox
        )
    )

    items.add(
        OnBoardingData(
            R.drawable.kayn,
            "",
            R.string.kayn
        )
    )

    items.add(
        OnBoardingData(
            R.drawable.pyke,
            "",
            R.string.pyke
        )
    )

    val pagerState = rememberPagerState(
        pageCount = items.size,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0
    )

    OnBoardingPager(
        item = items,
        pagerState = pagerState,
        modifier = Modifier
            .fillMaxSize()
            .background(color = White),
        navController = navController
    )
}



@ExperimentalPagerApi
@Composable
fun OnBoardingPager(
    item: List<OnBoardingData>,
    pagerState: PagerState,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Box(modifier = modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            HorizontalPager(
                state = pagerState
            ) { page ->
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                ) {
                     Image(
                         painter = painterResource(id = item[page].image),
                         contentDescription = item[page].title,
                         contentScale = ContentScale.FillBounds,
                         modifier = Modifier
                             .fillMaxSize()
                     )

                    Text(
                        text = item[page].title,
                        modifier = Modifier.padding(top = 50.dp),
                        color = Color.White,
                        style = androidx.compose.material3.MaterialTheme.typography.headlineSmall,
                    )

                    Text(
                        text = stringResource(id = item[page].desc),
                        modifier = Modifier
                            .padding(top = 550.dp, start = 120.dp, end = 100.dp)
                            .width(200.dp),
                        color = White,
                        textAlign = TextAlign.Center,
                        fontSize = 20.sp
                    )
                }
            }

            PagerIndicator(item.size, pagerState.currentPage)
        }
        Box(modifier = Modifier.align(Alignment.BottomCenter)) {
            BottomSection(pagerState.currentPage, pagerState, navController)
        }
    }
}

@ExperimentalPagerApi
@Composable
fun rememberPagerState(
    @IntRange(from = 0) pageCount: Int,
    @IntRange(from = 0) initialPage: Int = 0,
    @FloatRange(from = 0.0, to = 1.0) initialPageOffset: Float = 0f,
    @IntRange(from = 1) initialOffscreenLimit: Int = 1,
    infiniteLoop: Boolean = false
): PagerState = rememberSaveable(
    saver = PagerState.Saver
) {
    PagerState(
        pageCount = pageCount,
        currentPage = initialPage,
        currentPageOffset = initialPageOffset,
        offscreenLimit = initialOffscreenLimit,
        infiniteLoop = infiniteLoop
    )
}

@Composable
fun PagerIndicator(
    size: Int,
    currentPage: Int
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(top = 60.dp)
    ) {
        repeat(size) {
            Indicator(isSelected = it == currentPage)
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean) {
    val width = animateDpAsState(targetValue = if (isSelected) 25.dp else 10.dp)

    Box(
        modifier = Modifier
            .padding(1.dp)
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelected) Red else Gray.copy(alpha = 0.5f)
            )
    )
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BottomSection(currentPager: Int, pagerState: PagerState, navController: NavController) {
    val coroutineScope = rememberCoroutineScope()

    Row(
        modifier = Modifier
            .padding(bottom = 80.dp)
            .fillMaxWidth(),
        horizontalArrangement = if (currentPager != 0) Arrangement.SpaceBetween else Arrangement.Center
    ) {
        if (currentPager == 0) {
            OutlinedButton(
                onClick = {
                    val nextPage = pagerState.currentPage + 1
                    if (nextPage < pagerState.pageCount) {
                        coroutineScope.launch {
                            pagerState.scrollToPage(nextPage)
                        }
                    } else {
                            navController.navigate(NavRoutes.login.route)
                    }
                },
                shape = RoundedCornerShape(50),
            ) {
                Text(
                    text = stringResource(id = R.string.getstarted),
                    modifier = Modifier
                        .padding(vertical = 8.dp, horizontal = 20.dp),
                    color = White,
                    style = androidx.compose.material3.MaterialTheme.typography.bodyLarge
                )
            }
        } else {
            SkipNextButton(text = stringResource(id = R.string.skip), modifier = Modifier.padding(start = 20.dp), pagerState)
            SkipNextButton(text = stringResource(id = R.string.next), modifier = Modifier.padding(end = 20.dp), pagerState, currentPager,navController)
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SkipNextButton(text: String, modifier: Modifier, pagerState: PagerState, currentPager: Int? = null, navController: NavController? = null) {
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current
    val preferencesManager = remember { PreferencesManager(context) }

    Text(
        text = text,
        color = White,
        modifier = modifier.clickable {
            if (text == "Skip") {
                // Cambiar a la última página al hacer clic en "Skip"
                val lastPage = pagerState.pageCount - 1
                if (lastPage >= 0) {
                    coroutineScope.launch {
                        pagerState.scrollToPage(lastPage)
                    }
                }
            } else if (text == "Next") {
                // Cambiar a la siguiente página al hacer clic en "Next"
                val nextPage = pagerState.currentPage + 1
                if (nextPage < pagerState.pageCount) {
                    coroutineScope.launch {
                        pagerState.scrollToPage(nextPage)
                    }
                } else if (currentPager == 2 && navController != null){
                    preferencesManager.saveData("alreadyShowOnboarding", true)
                    // Navega a LoginScreenView cuando estés en la última página y hagas clic en "Next"
                    navController.navigate(NavRoutes.login.route)
                }
            }
        },
        fontSize = 18.sp,
        style = MaterialTheme.typography.bodyLarge,
        fontWeight = FontWeight.Medium
    )
}

