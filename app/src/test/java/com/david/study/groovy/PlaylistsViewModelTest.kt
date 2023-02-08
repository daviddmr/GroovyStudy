package com.david.study.groovy

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.david.study.groovy.repository.PlaylistRepository
import com.david.study.groovy.ui.viewModels.PlaylistViewModel
import com.david.study.groovy.utils.MainCoroutineScopeRule
import com.david.study.groovy.utils.getValueForTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mockito.*

class PlaylistsViewModelTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    @get:Rule
    val coroutineTestRule = MainCoroutineScopeRule()

    @get:Rule
    var instantTask: TestRule = InstantTaskExecutorRule()

    private val repository: PlaylistRepository = mock()
    private val viewModel: PlaylistViewModel = PlaylistViewModel(repository)

    @Test
    fun getPlaylistFromRepository() {
        viewModel.playlists.getValueForTest()

        verify(repository, times(1)).getPlaylists()
    }
}