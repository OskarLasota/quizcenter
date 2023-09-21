package com.frezzcoding.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.frezzcoding.domain.AdDetails
import com.frezzcoding.domain.QuizDetails
import kotlinx.collections.immutable.ImmutableList

@Composable
fun HomeFeed(items: ImmutableList<Any>, onItemPressed: () -> Unit) {
    LazyColumn {
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