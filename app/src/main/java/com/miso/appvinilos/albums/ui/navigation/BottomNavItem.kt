package com.miso.appvinilos.ui.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.miso.appvinilos.R

enum class BottomNavItem(
    @StringRes val titleRes: Int,
    @DrawableRes val iconRes: Int,
    val route: String
) {
    Albums(R.string.albums, R.drawable.ic_album, "albums"),
    Artists(R.string.artists, R.drawable.ic_artist, "artists"),
    Collectors(R.string.collectors, R.drawable.ic_collector, "collectors"),
    Home(R.string.home, R.drawable.ic_home, "home")
}