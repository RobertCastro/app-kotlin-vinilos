package com.miso.appvinilos.albums.viewmodels
import com.miso.appvinilos.albums.model.Album
import com.miso.appvinilos.albums.repositories.AlbumRepository
import android.app.Application
import androidx.lifecycle.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.launch
import android.util.Log;

class AlbumViewModel(application: Application) :  AndroidViewModel(application) {
    private val albumRepository = AlbumRepository()
    private val _albums = MutableLiveData<List<Album>>()
    val albums: LiveData<List<Album>>
        get() = _albums

    private val _album = MutableLiveData<Album>()
    val album: LiveData<Album>
        get() = _album

    fun fetchAlbums() {
        viewModelScope.launch {
            try {
                val albums = albumRepository.getAlbums()
                Log.d("fetchAlbums", "fetchAlbums: $albums")

                _albums.value = albums
            } catch (e: Exception) {
                // Handle error
                Log.e("fetchAlbumsError", "Error fetching album details", e)
                e.printStackTrace()
            }
        }
    }

    fun fetchAlbum(albumId: Int) {
        // Launch a coroutine in the IO context
        viewModelScope.launch {
            try {
                val result = albumRepository.getAlbum(albumId)
                Log.d("fetchAlbum", "fetchAlbum: $result")
                _album.value = result
            } catch (e: Exception) {
                // Handle error
                e.printStackTrace()
            }
        }
    }

}