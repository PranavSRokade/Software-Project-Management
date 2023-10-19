package com.projexino.softwareprojectmanagement.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
//import com.google.accompanist.pager.ExperimentalPagerApi
//import com.google.accompanist.pager.rememberPagerState
import com.projexino.softwareprojectmanagement.components.AppBar
import com.projexino.softwareprojectmanagement.components.SearchBar
import com.projexino.softwareprojectmanagement.ui.theme.SoftwareProjectManagementTheme
import kotlinx.coroutines.launch

class Projects : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SoftwareProjectManagementTheme {
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()
                val tabItems = listOf("Projects", "All Tasks", "Updates")
                val pagerState = rememberPagerState()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Box(){
                        Row(modifier = Modifier.align(Alignment.TopCenter)){
                            com.projexino.softwareprojectmanagement.components.TabRow(
                                pagerState = pagerState,
                                tabItems = tabItems
                            )
                        }

                        HorizontalPager(count = tabItems.size, state = pagerState) { page ->
                            Column {
                                SearchBar(
                                    hint = "Search Permits",
                                    modifier = Modifier
                                        .padding(start = 15.dp, end = 15.dp, top = 0.dp, bottom = 16.dp)
                                        .clip(RoundedCornerShape(10.dp)),
                                    onSearch = {

                                    }
                                )

                                Text(tabItems[page])
                            }
                        }
                    }
//                    Scaffold(
//                        scaffoldState = scaffoldState,
//                        topBar = {
//                            AppBar(
//                                onNavigationIconClick = {
//                                    scope.launch {
//                                        scaffoldState.drawerState.open()
//                                    }
//                                },
//                                "Projects",
//                            )
//                        },
//                    ) {
//
//                    }
                }
            }
        }
    }
}