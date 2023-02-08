package com.david.study.groovy.service

import com.david.study.groovy.repository.PlaylistRepository
import com.david.study.groovy.utils.BaseUnitTest
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.runBlocking
import org.junit.Test

class PlaylistRepositoryTest : BaseUnitTest() {

    private val service: PlaylistService = mock()

    @Test
    fun fetchPlaylistShouldBeCalled() {
        runBlocking {
            val repository = PlaylistRepository(service)
            repository.getPlaylists()
            verify(service, times(1)).fetchPlaylists()
        }
    }

}