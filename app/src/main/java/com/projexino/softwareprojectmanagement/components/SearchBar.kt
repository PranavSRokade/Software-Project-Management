package com.projexino.softwareprojectmanagement.components

import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.projexino.softwareprojectmanagement.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {}
) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = {
            text = it
            onSearch(it)
        },
        textStyle = TextStyle(
            fontFamily = FontFamily(Font(R.font.outfit_regular)),
            fontSize = 17.sp,
            color = Color.Black
        ),
        modifier = modifier.fillMaxWidth().height(50.dp),
        leadingIcon = {
            Icon(
                painterResource(id = R.drawable.ic_custom_search),
                contentDescription = null,
                modifier = Modifier.padding(10.dp)
            )
        },
        placeholder = {
            Text(
                text = hint,
                fontSize = 17.sp,
                fontWeight = FontWeight.Normal,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.outfit_regular)),
                    fontSize = 17.sp,
                    color = Color.Black
                )
            )
        },
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor = Color(0xFFF1F1F1), // Custom background color
            focusedBorderColor = Color(0xFFF1F1F1), // Match the background color
            unfocusedBorderColor = Color(0xFFF1F1F1) // Match the background color
        ),
        visualTransformation = VisualTransformation.None
    )
}
