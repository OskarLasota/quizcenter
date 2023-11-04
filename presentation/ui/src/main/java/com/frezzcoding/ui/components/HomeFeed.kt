package com.frezzcoding.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListItemInfo
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import com.frezzcoding.domain.models.FeedItem
import com.frezzcoding.domain.models.ad.AdDetails
import com.frezzcoding.domain.models.quiz.QuizDetails
import com.example.media.MediaPlayerManager
import kotlinx.collections.immutable.ImmutableList
import kotlin.math.max


//todo need to understand if this is being composed too often and if it is built corrrectly
@Composable
fun HomeFeed(
    items: ImmutableList<Any>,
    player: MediaPlayerManager,
    lifecycle: Lifecycle.Event,
    onItemPressed: () -> Unit,
    onItemFullyVisible: (FeedItem?) -> Unit
) {
    val state = rememberLazyListState()
    LazyColumn(
        modifier = Modifier.background(MaterialTheme.colors.secondary),
        state = state
    ) {
        items(items) { item ->
            when (item) {
                is AdDetails -> {
                    val visibleItems by remember(state) {
                        derivedStateOf {
                            var visibleItems = emptyList<FeedItem>()
                            if (items.isNotEmpty()) {
                                visibleItems = state.visibleItems(100f)
                                    .map { items[it.index] as FeedItem }
                            }
                            visibleItems
                        }
                    }
                    LaunchedEffect(visibleItems) {
                        Log.d("home feed", "visible ad items: " + visibleItems.count { it is AdDetails }.toString())
                    }
                    AdItem(item, onItemPressed)
                }

                is QuizDetails -> {
                    val visibleItems by remember(state) {
                        derivedStateOf {
                            var visibleItems = emptyList<FeedItem>()
                            if (items.isNotEmpty()) {
                                visibleItems = state.visibleItems(50f)
                                    .map { items[it.index] as FeedItem }
                            }
                            visibleItems
                        }
                    }
                    LaunchedEffect(visibleItems) {
                        onItemFullyVisible(visibleItems.findLast { it is QuizDetails })
                        Log.d("home feed", "visible quiz items: " + visibleItems.count { it is QuizDetails }.toString())
                    }
                    QuizItem(item, onItemPressed, player)
                }
            }
        }
    }
}

fun LazyListState.visibleItems(itemVisiblePercentThreshold: Float): List<LazyListItemInfo> =
    layoutInfo
        .visibleItemsInfo
        .filter {
            visibilityPercent(it) >= itemVisiblePercentThreshold
        }

fun LazyListState.visibilityPercent(info: LazyListItemInfo): Float {
    val cutTop = max(0, layoutInfo.viewportStartOffset - info.offset)
    val cutBottom = max(0, info.offset + info.size - layoutInfo.viewportEndOffset)

    return max(0f, 100f - (cutTop + cutBottom) * 100f / info.size)
}