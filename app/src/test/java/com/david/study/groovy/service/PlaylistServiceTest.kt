package com.david.study.groovy.service

import com.david.study.groovy.interfaces.PlaylistApi
import com.david.study.groovy.utils.BaseUnitTest
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.runBlocking
import org.junit.Test

class PlaylistServiceTest : BaseUnitTest() {

    private val playlistApi: PlaylistApi = mock()

    @Test
    fun fetchPlaylistsShouldCallFetchAllPlaylists() {
        runBlocking {
            val sut = PlaylistService(playlistApi)
            sut.fetchPlaylists()
            verify(playlistApi, times(1)).fetchAllPlaylists()
        }
    }
}