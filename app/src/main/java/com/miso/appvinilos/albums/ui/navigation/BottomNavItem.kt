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
    Home(R.string.home, R.drawable.ic_home, "home")
}