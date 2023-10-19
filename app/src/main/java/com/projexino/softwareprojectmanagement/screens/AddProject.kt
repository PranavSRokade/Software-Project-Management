package com.projexino.softwareprojectmanagement.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.projexino.softwareprojectmanagement.components.Dropdown
import com.projexino.softwareprojectmanagement.components.TextInput
import com.projexino.softwareprojectmanagement.ui.theme.SoftwareProjectManagementTheme
import com.projexino.softwareprojectmanagement.ui.theme.Typography
import com.projexino.softwareprojectmanagement.viewmodels.AddProject

class AddProject : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel by viewModels<AddProject>()
        super.onCreate(savedInstanceState)
        setContent {
            val rotationState by animateFloatAsState(targetValue = if (viewModel.showOptions) 180f else 0f)
            SoftwareProjectManagementTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        item {
                            Text("Add Project", style = Typography.h1)
                        }
                        item {
                            Spacer(Modifier.height(20.dp))
                            TextInput(
                                label = "Project Name",
                                value = viewModel.projectName,
                                onChange = { viewModel.projectNameChange(it) })
                        }
                        item {
                            TextInput(
                                label = "Project Description",
                                value = viewModel.projectDescription,
                                onChange = { viewModel.projectDescriptionChange(it) },
                                height = 100.dp
                            )
                        }
                        item{
                            Dropdown(
                                onDropdownMenuChange = { viewModel.showOptions = !viewModel.showOptions },
                                showOptions = viewModel.showOptions,
                                onDismiss = { /*TODO*/ },
                                onSelected = {viewModel.onDropdownSelected(it)},
                                options = viewModel.userLists,
                                hint = "Select Users",
                                rotationState = rotationState
                            )
                        }
                    }
                }
            }
        }
    }
}