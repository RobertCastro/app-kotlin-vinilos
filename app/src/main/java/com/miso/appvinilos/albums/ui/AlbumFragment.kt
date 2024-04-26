package com.miso.appvinilos.albums.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import com.miso.appvinilos.albums.viewmodels.AlbumViewModel

class AlbumFragment : Fragment() {

    private val viewModel: AlbumViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment using Compose
        return ComposeView(requireContext()).apply {
            setContent {
                AppVinilosTheme {
                    AlbumList(viewModel)
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // You can call viewModel.fetchAlbums() here if your ViewModel does not do it automatically
        viewModel.fetchAlbums()
    }
}
