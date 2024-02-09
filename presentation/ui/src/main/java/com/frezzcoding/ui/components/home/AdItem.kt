package com.frezzcoding.ui.components.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.frezzcoding.domain.models.ad.AdDetails
import com.frezzcoding.ui.components.newquiz.UserAvatar

@Composable
fun AdItem(ad: AdDetails, onPressed: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(all = 10.dp)
            .fillMaxWidth()
    ) {
        UserAvatar()
        Spacer(modifier = Modifier.size(12.dp))
        Column {
            NameAndUsername(ad)
            Spacer(modifier = Modifier.size(1.dp))
            FeedContent(ad)
            Spacer(modifier = Modifier.size(10.dp))
            AdActions(ad)
        }
    }
}

@Composable
fun NameAndUsername(ad: AdDetails) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    )
    {
        Text(
            text = "@${ad.adOwner.name}",
            color = Color.White,
            fontFamily = FontFamily.Monospace,
            maxLines = 1,
            modifier = Modifier
                .padding(bottom = 10.dp)
        )
    }
}

@Composable
fun FeedContent(ad: AdDetails) {
    Box {
        Text(
            text = ad.text,
            color = Color.White,
            fontFamily = FontFamily.Monospace,
            modifier = Modifier.padding(bottom = 8.dp)
        )
    }
}

@Composable
fun AdActions(ad: AdDetails) {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxWidth()
    )
    {
        // Add action buttons here
    }
}
