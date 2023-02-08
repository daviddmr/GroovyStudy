package com.david.study.groovy.playlist

import com.david.study.groovy.model.Playlist
import com.david.study.groovy.repository.PlaylistRepository
import com.david.study.groovy.ui.viewModels.PlaylistViewModel
import com.david.study.groovy.utils.BaseUnitTest
import com.david.study.groovy.utils.getValueForTest
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito.mock

class PlaylistsViewModelTest : BaseUnitTest() {

    private val repository: PlaylistRepository = mock()
    private val playlists = mock<List<Playlist>>()
    private val viewModel: PlaylistViewModel by lazy {
        PlaylistViewModel(repository)
    }
    private val exception: RuntimeException by lazy {
        RuntimeException("Something went wrong")
    }

//    @Test
//    fun getPlaylistFromRepositoryIsCalled() {
//        mockSuccessfulReturn()
//        viewModel.playlists.getValueForTest()
//
//        verify(repository, times(1)).getPlaylists()
//    }

    @Test
    fun getPlayListFromRepositoryReturnValue() = runBlocking {
        mockSuccessfulReturn()
        Assert.assertEquals(playlists, viewModel.playlists.getValueForTest())
    }

    @Test
    fun getPlaylistReturnError() = runBlocking {
        mockFailureReturn()
        Assert.assertEquals(null, viewModel.playlists.getValueForTest())
    }

    private fun mockSuccessfulReturn() = runBlocking {
        whenever(repository.getPlaylists()).thenReturn(
            Result.success(playlists)
        )
    }

    private fun mockFailureReturn() = runBlocking {
        whenever(repository.getPlaylists()).thenReturn(
            Result.failure(exception)
        )
    }
}