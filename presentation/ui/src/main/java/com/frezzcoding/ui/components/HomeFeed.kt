package com.frezzcoding.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.frezzcoding.domain.Ad

@Composable
fun HomeFeed(ads: List<Ad>, onItemPressed: () -> Unit) {
   LazyColumn {
       items(ads) { ad ->
           AdItem(ad, onItemPressed)
       }
   }
}