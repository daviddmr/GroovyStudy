package com.david.study.groovy.viewModels

import com.david.study.groovy.model.Playlist
import com.david.study.groovy.repository.PlaylistRepository
import com.david.study.groovy.utils.BaseUnitTest
import com.david.study.groovy.utils.getValueForTest
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito.*

class PlaylistsViewModelTest : BaseUnitTest() {

    private val repository: PlaylistRepository = mock()
    private val playlists: List<Playlist> = mock()

    @Test
    fun getPlaylistsFromRepositoryShouldBeCalled() {
        runBlocking {
            val sut = PlaylistViewModel(repository)
            sut.getPlaylistList()
            verify(repository, times(1)).getPlaylists()
        }
    }

    @Test
    fun getPlaylistSuccessCaseReturnList() {
        runBlocking {
            val sut = mockSuccessCase()
            sut.getPlaylistList()
            val result = sut.playlists.getValueForTest()
            Assert.assertEquals(playlists, result)
        }
    }

    @Test
    fun getPlaylistsFailureCaseReturnEmptyList() {
        runBlocking {
            val sut = mockFailureCase()
            sut.getPlaylistList()
            Assert.assertEquals(null, sut.playlists.getValueForTest())
        }
    }

    private suspend fun mockSuccessCase(): PlaylistViewModel {
        whenever(repository.getPlaylists()).thenReturn(
            Result.success(playlists)
        )
        return PlaylistViewModel(repository)
    }

    private suspend fun mockFailureCase(): PlaylistViewModel {
        whenever(repository.getPlaylists()).thenReturn(
            Result.failure(RuntimeException())
        )
        return PlaylistViewModel(repository)
    }
}