package com.frezzcoding.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.frezzcoding.quizcenter.presentation.ui.R

@Composable
fun SearchScreenComponent() {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.secondary)
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        SearchBar()
        RecsSection()
    }
}

@Composable
fun SearchBar() {
    var searchText by rememberSaveable { mutableStateOf("") }

    Row(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp, top = 20.dp, bottom = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Go to account action",
            tint = Color.White,
            modifier = Modifier
                .size(28.dp)
                .weight(1f)
        )
        Card(
            modifier = Modifier.weight(5f),
            elevation = 4.dp
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 4.dp)
            ) {
                BasicTextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    singleLine = true,
                    textStyle = MaterialTheme.typography.body1
                )
            }
        }
        Icon(
            imageVector = Icons.Default.Settings,
            contentDescription = "Go to settings action",
            tint = Color.White,
            modifier = Modifier
                .size(28.dp)
                .weight(1f)
        )
    }
}

@Composable
fun RecsSection() {

}