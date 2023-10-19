package com.projexino.softwareprojectmanagement.components

import androidx.compose.animation.Animatable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Surface
import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabRow(pagerState: PagerState, tabItems: List<String>) {
    val coroutineScope = rememberCoroutineScope()

    ScrollableTabRow(
        edgePadding = 0.dp,
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color.Unspecified,
        indicator = {
        },
        modifier = Modifier.offset(x = (-5).dp),
        divider = { }
    ) {
        tabItems.forEachIndexed { index, title ->
            val color = remember {
                Animatable(Color("#3382FF".toColorInt()))
            }
            LaunchedEffect(pagerState.currentPage == index) {
                if (pagerState.currentPage < 0 || tabItems.isEmpty()) {
                    coroutineScope.launch {
                        pagerState.scrollToPage(0)
                    }
                }

                color.animateTo(
                    if (pagerState.currentPage == index) Color(
                        "#3382FF".toColorInt()
                    ) else Color.White
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 3.dp, vertical = 7.dp)
            ) {
                Tab(
                    text = {
                        Text(
                            title,
//                                        style = if (pagerState.currentPage == index) MaterialTheme.typography.button else MaterialTheme.typography.h5,
                            fontWeight = if (pagerState.currentPage == index) FontWeight.Bold else FontWeight.Normal,
                            fontSize = 26.sp,
                            color = if (pagerState.currentPage == index) Color.Black else Color.DarkGray,
                            textAlign = TextAlign.Start,
                            style = com.projexino.softwareprojectmanagement.ui.theme.Typography.body2,
                        )
                    },
                    selected = pagerState.currentPage == index,
                    modifier = Modifier,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.scrollToPage(
                                index
                            )
                        }
                    })

                Text(
                    "6",
                    modifier = Modifier
                        .width(22.dp)
//                        .height(20.dp)
                        .offset(y = (-4).dp)
                        .align(Alignment.TopEnd)
                        .clip(CircleShape)
                        .background(
                            color = if (pagerState.currentPage == index) Color("#3274f4".toColorInt()) else Color.LightGray
                        ),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}