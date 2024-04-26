package com.miso.appvinilos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.miso.appvinilos.albums.ui.views.AlbumList
import com.miso.appvinilos.albums.ui.theme.AppVinilosTheme
import com.miso.appvinilos.albums.viewmodels.AlbumViewModel
import android.util.Log
import androidx.activity.viewModels
import androidx.navigation.NavController
import com.miso.appvinilos.ui.navigation.BottomNavItem


class MainActivity : ComponentActivity() {
    private val viewModel: AlbumViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppVinilosTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) {
        NavigationGraph(navController = navController)
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Albums,
        BottomNavItem.Artists,
        BottomNavItem.Collectors
    )
    BottomNavigation {
        // Implementación de BottomNavigation
    }
}

@Composable
fun NavigationGraph(navController: NavController) {
    NavHost(navController, startDestination = BottomNavItem.Home.route) {
        composable(BottomNavItem.Home.route) { HomeScreen() }
        composable(BottomNavItem.Albums.route) { AlbumsScreen() }
        composable(BottomNavItem.Artists.route) { ArtistsScreen() }
        composable(BottomNavItem.Collectors.route) { CollectorsScreen() }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun AlbumScreen(viewModel: AlbumViewModel) {
    val album by viewModel.album.observeAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchAlbum(1)
    }

    Column {
        if (album == null) {
            // Show loading indicator or placeholder
            Text(text = "Loading...")
        } else {
            // Display the credit card details
//            Text(text = album?.albumId ?: "Unknown")
            Text(text = album?.name ?: "Unknown")
            Text(text = album?.description ?: "Unknown")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppVinilosTheme {
        Greeting("Android")
    }
}


@Composable
fun AlbumListScreen() {
    val viewModel: AlbumViewModel = viewModel()
    LaunchedEffect(key1 = true) {
        viewModel.fetchAlbums()
    }
    Log.d("AlbumListScreen", "Loading albums from ViewModel")
    AlbumList(viewModel)
}
