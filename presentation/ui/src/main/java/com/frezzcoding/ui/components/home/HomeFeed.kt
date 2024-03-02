package com.frezzcoding.ui.components.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
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
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.media.MediaPlayerManager
import com.frezzcoding.domain.models.ad.AdDetails
import com.frezzcoding.domain.models.quiz.QuizDetails
import com.frezzcoding.ui.components.newquiz.QuizItem
import kotlinx.collections.immutable.ImmutableList
import kotlin.math.max


//todo need to create preview files
//todo need to understand if this is being composed too often and if it is built correctly
@Composable
fun HomeFeed(
    items: ImmutableList<Any>,
    player: MediaPlayerManager,
    onItemPressed: () -> Unit,
    onVideoItemFullyVisible: (QuizDetails?) -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberLazyListState()
    val listHeight = LocalConfiguration.current.screenHeightDp.dp - 56.dp // todo magic number

    LazyColumn(
        state = scrollState,
        modifier = modifier
            .background(MaterialTheme.colors.secondary)
            .height(listHeight)
    ) {
        items(items) { item ->
            when (item) {
                is AdDetails -> {
                    AdItem(item, onItemPressed)
                }

                is QuizDetails -> {
                    QuizItem(item, onItemPressed, player)
                }
            }
        }
    }
//    val visibleItems: List<FeedItem?> by remember(scrollState, items) {
//        derivedStateOf {
//            // could easily change this logic to check which item is no longer visible and
//            // potentially run some logic on it? e.g. pausing a video.
//            scrollState.visibleItems(100f)
//                .mapNotNull {
//                    if (it.index >= items.size) return@mapNotNull null
//
//                    items[it.index] as FeedItem
//                }
//        }
//    }

    val lastVisibleQuizWithVideo: QuizDetails? by remember(scrollState, items) {
        derivedStateOf {
            val lastItem = scrollState.visibleItems(80f).findLast {
                if (it.index >= items.size) return@findLast false
                if (items[it.index] !is QuizDetails) return@findLast false

                return@findLast (items[it.index] as QuizDetails).video?.isNotEmpty() == true
            }
            lastItem?.let {
                items[it.index] as QuizDetails
            }
        }
    }

    LaunchedEffect(lastVisibleQuizWithVideo) {
        onVideoItemFullyVisible(lastVisibleQuizWithVideo)
        Log.d(
            "home feed",
            "visible quiz item id: " + lastVisibleQuizWithVideo?.id
        )
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