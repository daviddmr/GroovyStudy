package com.david.study.groovy.ui.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.david.study.groovy.model.Playlist
import com.david.study.groovy.repository.PlaylistRepository
import kotlinx.coroutines.launch

class PlaylistViewModel(
    private val repository: PlaylistRepository
) : ViewModel() {

    val playlists = MutableLiveData<List<Playlist>>()

    init {
        getPlaylistList()
    }

    private fun getPlaylistList() {
        viewModelScope.launch {
            val result = repository.getPlaylists()
            playlists.value = result
        }
    }
}
