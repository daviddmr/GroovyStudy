package com.david.study.groovy.viewModels

import com.david.study.groovy.model.Playlist
import com.david.study.groovy.repository.PlaylistRepository
import com.david.study.groovy.viewModels.PlaylistViewModel
import com.david.study.groovy.utils.BaseUnitTest
import com.david.study.groovy.utils.getValueForTest
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito.*

class PlaylistsViewModelTest : BaseUnitTest() {

    private val repository: PlaylistRepository = mock()
    private val playlists = mock<List<Playlist>>()
    private val exception: RuntimeException by lazy {
        RuntimeException("Something went wrong")
    }

    @Test
    fun getPlaylistFromRepositoryIsCalled() {
        runBlocking {
            val viewModel = mockSuccessfulReturn()
            viewModel.playlists.getValueForTest()

            verify(repository, times(1)).getPlaylists()
        }
    }

    @Test
    fun getPlayListFromRepositoryReturnValue() = runBlocking {
        val viewModel = mockSuccessfulReturn()
        Assert.assertEquals(playlists, viewModel.playlists.getValueForTest())
    }

    @Test
    fun getPlaylistReturnError() = runBlocking {
        val viewModel = mockFailureReturn()
        Assert.assertEquals(null, viewModel.playlists.getValueForTest())
    }

    private fun mockSuccessfulReturn(): PlaylistViewModel {
        runBlocking {
            whenever(repository.getPlaylists()).thenReturn(
                Result.success(playlists)
            )
        }
        return PlaylistViewModel(repository)
    }

    private fun mockFailureReturn(): PlaylistViewModel {
        runBlocking {
            whenever(repository.getPlaylists()).thenReturn(
                Result.failure(exception)
            )
        }
        return PlaylistViewModel(repository)
    }
}