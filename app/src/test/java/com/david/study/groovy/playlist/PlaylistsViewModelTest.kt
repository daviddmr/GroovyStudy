package com.david.study.groovy.playlist

import com.david.study.groovy.model.Playlist
import com.david.study.groovy.repository.PlaylistRepository
import com.david.study.groovy.ui.viewModels.PlaylistViewModel
import com.david.study.groovy.utils.BaseUnitTest
import com.david.study.groovy.utils.getValueForTest
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito.*

class PlaylistsViewModelTest : BaseUnitTest() {

    private val repository: PlaylistRepository = mock()
    private val playlists = mock<List<Playlist>>()
    private val viewModel: PlaylistViewModel by lazy {
        PlaylistViewModel(repository)
    }

//    @Test
//    fun getPlaylistFromRepositoryIsCalled() {
//        mockSuccessfulReturn()
//        viewModel.playlists.getValueForTest()
//
//        verify(repository, times(1)).getPlaylists()
//    }

    @Test
    fun getPlayListFromRepositoryReturnValue() {
        mockSuccessfulReturn()
        Assert.assertEquals(playlists, viewModel.playlists.getValueForTest())
    }

    private fun mockSuccessfulReturn() {
        whenever(repository.getPlaylists()).thenReturn(
            playlists
        )
    }
}