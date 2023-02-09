package com.david.study.groovy.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.david.study.groovy.databinding.FragmentPlaylistsBinding
import com.david.study.groovy.ext.viewModelsFactory
import com.david.study.groovy.interfaces.PlaylistApi
import com.david.study.groovy.repository.PlaylistRepository
import com.david.study.groovy.service.PlaylistService
import com.david.study.groovy.viewModels.PlaylistViewModel
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PlaylistsFragment : Fragment() {

    companion object {
        fun newInstance(): PlaylistsFragment = PlaylistsFragment()
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://localhost:3000")
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(PlaylistApi::class.java)

    private lateinit var binding: FragmentPlaylistsBinding
    private val service: PlaylistService by lazy {
        PlaylistService(api)
    }
    private val repository: PlaylistRepository by lazy {
        PlaylistRepository(service)
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