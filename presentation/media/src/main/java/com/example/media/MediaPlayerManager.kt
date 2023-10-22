package com.example.media

import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import javax.inject.Inject

class MediaPlayerManager @Inject constructor(private val player: Player) {

    init {
        player.playWhenReady = true
    }

    fun playVideo() {
        player.prepare()
    }

    fun applyMediaItem(mediaItem: MediaItem): Player {
        return player.apply {
            setMediaItem(mediaItem)
        }
    }

}