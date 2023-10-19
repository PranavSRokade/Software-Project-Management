package com.projexino.softwareprojectmanagement.screens

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
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
import com.projexino.softwareprojectmanagement.R
import com.projexino.softwareprojectmanagement.ui.theme.Typography

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
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Spacer(Modifier.height(10.dp))
                        com.projexino.softwareprojectmanagement.components.TabRow(
                            pagerState = pagerState,
                            tabItems = tabItems
                        )

                        HorizontalPager(
                            count = tabItems.size,
                            state = pagerState,
                            modifier = Modifier
                        ) { page ->
                            LazyColumn(
                                modifier = Modifier.fillMaxSize()
                            ) {
                                item {
                                    SearchBar(
                                        modifier = Modifier
                                            .padding(
                                                start = 15.dp,
                                                end = 15.dp,
                                                top = 10.dp,
                                                bottom = 16.dp
                                            )
                                            .clip(RoundedCornerShape(35.dp)),
                                        hint = "Search",
                                        onSearch = {}
                                    )
                                }
                                item {
                                    Image(
                                        painter = painterResource(id = com.projexino.softwareprojectmanagement.R.drawable.empty_projects),
                                        contentDescription = "No Project",
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .align(Alignment.CenterHorizontally)
                                    )

                                    Text(
                                        text = "No Projects Found",
                                        style = com.projexino.softwareprojectmanagement.ui.theme.Typography.body2,
                                        fontSize = 20.sp,
                                        color = Color.Gray,
                                        modifier = Modifier.fillMaxSize(),
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
                    }
                    Box(
                        modifier = Modifier.size(20.dp),
                        contentAlignment = Alignment.BottomEnd
                    ) {
                        FloatingActionButton(
                            onClick = { startActivity(Intent(this@Projects, AddProject::class.java)) },
                            shape = CircleShape,
                            modifier = Modifier.padding(20.dp),
                            backgroundColor = Color("#3382FF".toColorInt())) {
                            Icon(painter = painterResource(id = R.drawable.ic_baseline_add_24), contentDescription = "Add Projects")
                        }
                    }
                }
            }
        }
    }
}