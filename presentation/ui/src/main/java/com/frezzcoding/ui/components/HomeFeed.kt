package com.frezzcoding.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.frezzcoding.quizcenter.domain.AdModel
import com.frezzcoding.quizcenter.presentation.components.AdItem

@Composable
fun HomeFeed(ads: List<AdModel>, onItemPressed: () -> Unit) {
   LazyColumn {
       items(ads) { ad ->
           AdItem(ad, onItemPressed)
       }
   }
}