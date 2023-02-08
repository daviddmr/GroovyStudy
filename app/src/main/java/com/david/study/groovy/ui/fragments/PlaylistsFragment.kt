package com.david.study.groovy.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.david.study.groovy.databinding.FragmentPlaylistsBinding
import com.david.study.groovy.ext.viewModelsFactory
import com.david.study.groovy.repository.PlaylistRepository
import com.david.study.groovy.viewModels.PlaylistViewModel

class PlaylistsFragment : Fragment() {

    companion object {
        fun newInstance(): PlaylistsFragment = PlaylistsFragment()
    }

    private lateinit var binding: FragmentPlaylistsBinding
    private val repository: PlaylistRepository by lazy {
        PlaylistRepository()
    }
    private val viewModel: PlaylistViewModel by viewModelsFactory {
        PlaylistViewModel(repository)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPlaylistsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.playlists.observe(viewLifecycleOwner) {
            val playlistAdapter = PlaylistAdapter(it)
            binding.list.adapter = playlistAdapter
        }
    }
}