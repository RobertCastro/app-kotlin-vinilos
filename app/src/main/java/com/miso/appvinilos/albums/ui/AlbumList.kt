package com.miso.appvinilos.albums.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.miso.appvinilos.albums.viewmodels.AlbumViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun AlbumList(viewModel: AlbumViewModel = viewModel()) {

    val albums = viewModel.albums.observeAsState(listOf()).value

    LazyColumn {
        items(albums) { album ->
            AlbumItem(album)
        }
    }
}