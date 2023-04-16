package com.david.study.groovy.ui.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.david.study.groovy.databinding.ItemPlaylistsBinding
import com.david.study.groovy.model.Playlist

class PlaylistAdapter(
    private val values: List<Playlist>
) : RecyclerView.Adapter<PlaylistAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemPlaylistsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.playlistTitle.text = item.name
        holder.playlistCategory.text = item.category
        holder.playlistImage.setImageResource(item.image)
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: ItemPlaylistsBinding) : RecyclerView.ViewHolder(binding.root) {
        val playlistImage: ImageView = binding.itemPlaylistsImageIv
        val playlistTitle: TextView = binding.itemPlaylistsPlaylistNameTv
        val playlistCategory: TextView = binding.itemPlaylistsPlaylistCategoryTv
    }
}