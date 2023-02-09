package com.david.study.groovy.service

import com.david.study.groovy.interfaces.PlaylistApi
import com.david.study.groovy.model.Playlist
import com.david.study.groovy.utils.BaseUnitTest
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class PlaylistServiceTest : BaseUnitTest() {

    private val playlistApi: PlaylistApi = mock()
    private val playlists: List<Playlist> = mock()

    @Test
    fun fetchPlaylistsShouldCallFetchAllPlaylists() {
        runBlocking {
            val sut = PlaylistService(playlistApi)
            sut.fetchPlaylists()
            verify(playlistApi, times(1)).fetchAllPlaylists()
        }
    }

    @Test
    fun fetchPlaylistsShouldReturnSuccess() {
        runBlocking {
            val sut = mockSuccessCase()
            val result = sut.fetchPlaylists()

            Assert.assertEquals(playlists, result.getOrNull())
        }
    }

    @Test
    fun fetchPlaylistsShouldReturnNetworkFailure() = runBlocking {
        val sut = mockFailureCase()
        val result = sut.fetchPlaylists()

        Assert.assertEquals("Something went wrong", result.exceptionOrNull()?.message)
    }

    private suspend fun mockSuccessCase(): PlaylistService {
        whenever(playlistApi.fetchAllPlaylists()).thenReturn(
            playlists
        )
        return PlaylistService(playlistApi)
    }

    private suspend fun mockFailureCase(): PlaylistService {
        whenever(playlistApi.fetchAllPlaylists()).thenThrow(
            RuntimeException("Something went wrong")
        )
        return PlaylistService(playlistApi)
    }
}