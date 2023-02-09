package com.david.study.groovy.viewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.david.study.groovy.model.Playlist
import com.david.study.groovy.repository.PlaylistRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlaylistViewModel @Inject constructor(
    private val repository: PlaylistRepository
) : ViewModel() {

    val playlists = MutableLiveData<List<Playlist>>()

    init {
        getPlaylistList()
    }

    private fun getPlaylistList() {
        viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->
            Log.d("PlaylistViewModel", "getPlaylistListException: ${throwable.message}")
        }) {
            val result = repository.getPlaylists()
            if (result.isSuccess) {
                playlists.value = result.getOrNull()
            } else {
                Log.d("PlaylistViewModel", "getPlaylistListFailure: ${result.exceptionOrNull()?.message}")
            }
        }
    }
}
