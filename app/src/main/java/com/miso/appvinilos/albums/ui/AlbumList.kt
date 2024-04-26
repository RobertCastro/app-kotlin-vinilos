package com.miso.appvinilos.albums.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.miso.appvinilos.albums.viewmodels.AlbumViewModel
import androidx.compose.runtime.livedata.observeAsState


@Composable
fun AlbumList(viewModel: AlbumViewModel = viewModel()) {
    // Utiliza observeAsState si albums es un LiveData
    val albums = viewModel.albums.observeAsState(listOf()).value

    LazyColumn {
        items(albums) { album ->
            AlbumItem(album)
        }
    }
}