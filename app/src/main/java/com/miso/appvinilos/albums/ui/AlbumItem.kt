package com.miso.appvinilos.albums.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.miso.appvinilos.albums.ui.theme.AppVinilosTheme
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun AlbumItem(album: Int) {
    AppVinilosTheme {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            GlideImage(
                imageModel = { album.cover },
                modifier = Modifier.size(128.dp)
            )
            Text(text = album.name, style = MaterialTheme.typography.bodyLarge)
            Text(text = album.genre, style = MaterialTheme.typography.bodySmall)
        }
    }
}