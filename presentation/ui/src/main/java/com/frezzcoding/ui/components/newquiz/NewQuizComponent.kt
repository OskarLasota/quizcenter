package com.frezzcoding.ui.components.newquiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.frezzcoding.quizcenter.presentation.ui.R
import com.frezzcoding.ui.themes.DefaultBlue
import com.frezzcoding.ui.themes.DefaultGrey

@Composable
fun NewQuizComponent(
    onQuizPosted: () -> Unit,
    onQuizClosed: () -> Unit,
) {
    //top part with X button and Post button
    //mid content part - avatar on left and text box with description
    //mid content part - add quiz answers todo
    //bottom gallery on top of keyboard todo
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.secondary)
            .fillMaxHeight()
    ) {
        QuizActionHeader(onQuizPosted, onQuizClosed)
        QuizContentBox()
    }
}

@Composable
fun QuizActionHeader(
    onQuizPosted: () -> Unit,
    onQuizClosed: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(all = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = onQuizClosed) {
            Icon(
                imageVector = Icons.Default.Clear,
                contentDescription = stringResource(id = R.string.exit_screen_action),
                tint = Color.White,
                modifier = Modifier
                    .size(28.dp)
            )
        }
        IconButton(onClick = onQuizPosted) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = stringResource(id = R.string.submit_quiz_action),
                tint = Color.White,
                modifier = Modifier
                    .size(28.dp)
            )
        }
    }
}

@Composable
@Preview
fun QuizContentBox() {
    Row {
        UserAvatar(paddingStart = 20.dp)
        Spacer(modifier = Modifier.size(12.dp))
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(horizontal = 20.dp)
        ) {
            Box {
                QuizContentTextField()
            }
        }
    }
}

@Composable
@Preview
fun QuizContentTextField() {
    var text by rememberSaveable { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        placeholder = {
            Text(
                text = stringResource(id = R.string.quiz_hint_description),
                color = DefaultGrey
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.secondary,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = DefaultBlue
        ),
        textStyle = MaterialTheme.typography.body1.copy(color = Color.White),
        modifier = Modifier
            .height(300.dp),

    )
}