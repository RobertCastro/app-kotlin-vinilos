package com.miso.appvinilos.presentacion.ui.views.albumdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.miso.appvinilos.data.model.CollectorId
import com.miso.appvinilos.data.model.CommentRequest
import com.miso.appvinilos.presentacion.viewmodels.AlbumViewModel

@Composable
fun AddCommentScreen(albumId: Int, navigationController: NavHostController) {
    val viewModel: AlbumViewModel = viewModel()
    var commentContent by remember { mutableStateOf("") }
    var rating by remember { mutableStateOf(0) }
    val postCommentResponse by viewModel.postCommentResponse.observeAsState()

    Column {
        TextField(
            value = commentContent,
            onValueChange = { commentContent = it },
            label = { Text("Comment") }
        )
        TextField(
            value = rating.toString(),
            onValueChange = { rating = it.toIntOrNull() ?: 0 },
            label = { Text("Rating") }
        )
        Button(onClick = {
            val newCommentRequest = CommentRequest(
                description = commentContent,
                rating = rating,
                collector = CollectorId(id = 1)

            )
            viewModel.postComment(albumId, newCommentRequest)
        }) {
            Text("Submit")
        }

        // Handle post comment response
        postCommentResponse?.let { response ->
            if (response.isSuccessful) {
                Text("Comment posted successfully!")
                navigationController.popBackStack()
            } else {
                Text("Failed to post comment: ${response.message()}")
            }
        }
    }
}
