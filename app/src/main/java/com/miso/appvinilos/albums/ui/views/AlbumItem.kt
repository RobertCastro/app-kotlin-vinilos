package com.miso.appvinilos.albums.ui.views

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.miso.appvinilos.albums.model.Album
import com.miso.appvinilos.albums.ui.theme.AppVinilosTheme
import com.skydoves.landscapist.glide.GlideImage


@Composable
fun AlbumItem(album: Album) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .align(Alignment.Top)
            .fillMaxHeight()
            .padding(top = 0.dp, bottom = 0.dp)
            .width(176.dp)
            .clipToBounds(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.placeholder_image), // Placeholder image
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp)),
        )
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 0.dp, vertical = 8.dp),
        ) {
            Text(
                text = album.name,
                color = Color(0xff1b1c17),
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text = album.genre,
                color = Color(0xff45483c),
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Left,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

}
