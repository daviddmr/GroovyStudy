package com.david.study.groovy.repository

import com.david.study.groovy.model.Playlist
import com.david.study.groovy.service.PlaylistService
import com.david.study.groovy.utils.BaseUnitTest
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class PlaylistRepositoryTest : BaseUnitTest() {

    private val service: PlaylistService = mock()
    private val playlists: List<Playlist> = mock()
    private val exception = RuntimeException("Something went wrong")

    @Test
    fun shouldCallFetchPlaylistsFromService() {
        runBlocking {
            val sut = PlaylistRepository(service)
            sut.getPlaylists()
            verify(service, times(1)).fetchPlaylists()
        }
    }

    @Test
    fun getPlaylistsReturnSuccess() = runBlocking {
        val sut = mockSuccessCase()
        val result = sut.getPlaylists()

        assertEquals(playlists, result.getOrNull())
    }

    @Test
    fun getPlaylistReturnFailure() = runBlocking {
        val sut = mockFailureCase()
        val result = sut.getPlaylists()

        assertEquals(exception, result.exceptionOrNull())
    }

    private fun mockSuccessCase(): PlaylistRepository {
        whenever(service.fetchPlaylists()).thenReturn(
            Result.success(playlists)
        )
        return PlaylistRepository(service)
    }

    private fun mockFailureCase(): PlaylistRepository {
        whenever(service.fetchPlaylists()).thenReturn(
            Result.failure(exception)
        )
        return PlaylistRepository(service)
    }
}