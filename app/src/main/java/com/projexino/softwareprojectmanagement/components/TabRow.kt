package com.projexino.softwareprojectmanagement.components

import androidx.compose.animation.Animatable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ScrollableTabRow
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
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Tab(
                    text = {
                        Text(
                            title,
//                                        style = if (pagerState.currentPage == index) MaterialTheme.typography.button else MaterialTheme.typography.h5,
                            fontWeight = if (pagerState.currentPage == index) FontWeight.Bold else FontWeight.Normal,
                            fontSize = 16.sp,
                            color = if (pagerState.currentPage == index) Color(("#21486C").toColorInt()) else Color(
                                ("#001B33").toColorInt()
                            ),
                            textAlign = TextAlign.Start
                        )
                    },
                    selected = pagerState.currentPage == index,
                    modifier = Modifier
                        .padding(horizontal = 3.dp),
                    onClick = {
                        coroutineScope.launch {
                            pagerState.scrollToPage(
                                index
                            )
                        }
                    })
                if (pagerState.currentPage == index) {
                    Box(
                        Modifier
                            .size(5.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color("#21486C".toColorInt()))
                    )
                }
            }
        }
    }
}