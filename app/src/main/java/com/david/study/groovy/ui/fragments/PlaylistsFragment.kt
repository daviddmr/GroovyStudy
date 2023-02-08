package com.david.study.groovy.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.david.study.groovy.databinding.FragmentPlaylistsBinding
import com.david.study.groovy.model.Playlist

class PlaylistsFragment : Fragment() {

    companion object {

        const val TAG = "PlaylistsFragment"

        fun newInstance(): PlaylistsFragment {
            val fragment = PlaylistsFragment()
            val bundle = Bundle()
            fragment.arguments = bundle
            return fragment
        }
    }

    lateinit var binding: FragmentPlaylistsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: ")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "onCreateView: ")
        binding = FragmentPlaylistsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ")

        val playlists = mutableListOf<Playlist>()
        for (i in 0..10) {
            val playlist = Playlist("$i", "Playlist $i", "Category $i", i)
            playlists.add(playlist)
        }
        val playlistAdapter = PlaylistAdapter(playlists)
        binding.list.adapter = playlistAdapter
    }
}