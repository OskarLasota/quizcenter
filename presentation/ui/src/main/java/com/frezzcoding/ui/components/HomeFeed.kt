package com.frezzcoding.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.frezzcoding.domain.AdDetails

@Composable
fun HomeFeed(ads: List<AdDetails>, onItemPressed: () -> Unit) {
   LazyColumn {
       items(ads) { ad ->
           AdItem(ad, onItemPressed)
       }
   }
}