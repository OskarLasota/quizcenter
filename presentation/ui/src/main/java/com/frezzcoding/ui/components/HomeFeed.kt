package com.frezzcoding.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.frezzcoding.network.AdModel

@Composable
fun HomeFeed(ads: List<com.frezzcoding.network.AdModel>, onItemPressed: () -> Unit) {
   LazyColumn {
       items(ads) { ad ->
           AdItem(ad, onItemPressed)
       }
   }
}