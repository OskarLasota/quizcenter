package com.example.media

import android.app.Application
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import javax.inject.Inject

class MediaPlayerManager @Inject constructor(
    private val app: Application
) {

    // todo need to clear these exoplayers
    private var existingPlayerIds: MutableMap<Int, Player> = mutableMapOf()

    fun playVideo(id: Int) {
        if (existingPlayerIds.contains(id)) {
            //pause all the other ones then prepare

            existingPlayerIds[id]?.prepare()
            existingPlayerIds[id]?.play()
        }
    }

    fun pause(id: Int) {
        if (existingPlayerIds.contains(id)) {
            existingPlayerIds[id]?.pause()
        }
    }

    fun applyMediaItem(mediaItem: MediaItem, id: Int): Player? {
        return if (existingPlayerIds.contains(id)) {
            null
        } else {
            val player = createMediaPlayer()
            player.apply {
                setMediaItem(mediaItem)
            }
            player.playWhenReady = true // todo i think this can be avoided
            existingPlayerIds.put(id, player)
        }
    }

    private fun createMediaPlayer(): Player {
        return ExoPlayer.Builder(app).build()
    }


}