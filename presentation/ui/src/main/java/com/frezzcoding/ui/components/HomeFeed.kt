package com.frezzcoding.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.frezzcoding.domain.AdDetails
import com.frezzcoding.domain.QuizDetails
import kotlinx.collections.immutable.ImmutableList

@Composable
fun HomeFeed(items: ImmutableList<Any>, onItemPressed: () -> Unit) {
    LazyColumn(modifier = Modifier.background(MaterialTheme.colors.secondary)) {
        items(items) { item ->
            when (item) {
                is AdDetails -> {
                    AdItem(item, onItemPressed)
                }
                is QuizDetails -> {
                    QuizItem(item, onItemPressed)
                }
            }
        }
    }
}