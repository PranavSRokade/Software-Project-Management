package com.projexino.softwareprojectmanagement.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.projexino.softwareprojectmanagement.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
//Other default text styles to override
    body2 = TextStyle(
        fontFamily = FontFamily(Font(R.font.outfit_regular)),
        fontSize = 17.sp,
        color = Color.Black
    ),
    h1 = TextStyle(
        fontFamily = FontFamily(Font(R.font.outfit_semibold)),
        fontSize = 28.sp,
        color = Color.Black
    ),
/* caption = TextStyle(
fontFamily = FontFamily.Default,
fontWeight = FontWeight.Normal,
fontSize = 12.sp
)
*/
)