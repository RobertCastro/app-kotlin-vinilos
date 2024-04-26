package com.miso.appvinilos.albums.ui

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.miso.appvinilos.albums.viewmodels.AlbumViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun AlbumList(viewModel: AlbumViewModel) {
    val albums by viewModel.albums.observeAsState(initial = listOf())

    LazyColumn {
        items(albums) { album ->
            AlbumItem(album)
        }
    }
}