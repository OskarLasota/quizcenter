package com.frezzcoding.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.frezzcoding.ui.themes.DefaultBlue

@Composable
fun QuizButton(
    content: String,
    cornerRadius: Dp = 20.dp,
    borderPadding: Dp = 2.dp,
    fontSize: TextUnit = 16.sp,
    backgroundColor: Color,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(borderPadding)
            .clip(RoundedCornerShape(cornerRadius))
            .border(
                width = borderPadding,
                color = DefaultBlue,
                shape = RoundedCornerShape(cornerRadius)
            )
            .background(color = backgroundColor, shape = RoundedCornerShape(cornerRadius))
            .clickable(
                onClick = onClick
            ),
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = content,
                fontSize = fontSize,
            )
        }
    }
}