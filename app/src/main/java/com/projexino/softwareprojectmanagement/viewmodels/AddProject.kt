package com.projexino.softwareprojectmanagement.viewmodels

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class AddProject(): ViewModel(){

    var projectName by mutableStateOf("")
    var projectDescription by mutableStateOf("")

    var validate by mutableStateOf(false)

    var showOptions by mutableStateOf(false)
    var userLists = mutableListOf<String>("User 1", "User 2", "User 3", "User 4", "User 5")

    fun projectNameChange(text: String){
        projectName = text
    }

    fun projectDescriptionChange(text: String){
        projectDescription = text
    }

    fun onDropdownSelected(text: String){

    }

    fun validation() {
        validate =
            !(projectName == "" || projectDescription == "")
    }
}