package com.miso.appvinilos.albums.ui.views

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.miso.appvinilos.albums.viewmodels.AlbumViewModel
import androidx.compose.runtime.livedata.observeAsState


@Composable
fun AlbumList(viewModel: AlbumViewModel) {
    val albums by viewModel.albums.observeAsState(initial = listOf())

    LazyColumn {
        items(albums) { album ->
            AlbumItem(album)
        }
    }
}