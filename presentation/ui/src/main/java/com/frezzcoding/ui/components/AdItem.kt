package com.frezzcoding.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.frezzcoding.domain.AdDetails

@Composable
fun AdItem(ad: AdDetails, onPressed: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(all = 10.dp)
            .fillMaxWidth()
    ) {
        UserAvatar(ad)
        Spacer(modifier = Modifier.size(12.dp))
        Column {
            NameAndUsername(ad)
            Spacer(modifier = Modifier.size(1.dp))
            DescriptionAndImage(ad)
            Spacer(modifier = Modifier.size(10.dp))
            AdActions(ad)
        }
    }
}

@Composable
fun NameAndUsername(ad: AdDetails) {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .fillMaxWidth()
    )
    {
        Text(
            text = "test name @tester", // todo add this to domain ad model
            fontFamily = FontFamily.Monospace,
            maxLines = 1,
            modifier = Modifier
                .padding(bottom = 10.dp)
        )
    }
}

@Composable
fun UserAvatar(ad: AdDetails) {
    // User Avatar
    Box(
        modifier = Modifier
            .size(40.dp) // Adjust the size as needed
            .background(MaterialTheme.colors.secondary) // Background color for the avatar
            .clip(shape = CircleShape) // Clip the avatar to a circle shape
    ) {
        // Can load the user's avatar image here
    }
}

@Composable
fun DescriptionAndImage(ad: AdDetails) {
    Box {
        Text(
            text = ad.text,
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
