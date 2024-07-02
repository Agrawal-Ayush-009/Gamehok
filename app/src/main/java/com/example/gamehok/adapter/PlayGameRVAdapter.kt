package com.example.gamehok.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gamehok.databinding.PlayByGameRvItemBinding
import com.example.gamehok.model.PlayGameItem

class PlayGameRVAdapter(private val list : List<PlayGameItem>): RecyclerView.Adapter<PlayGameRVAdapter.PlayGameViewHolder>()  {
    inner class PlayGameViewHolder(binding: PlayByGameRvItemBinding): RecyclerView.ViewHolder(binding.root){
        val image = binding.gameImage
        val title = binding.gameName
    }

    var onItemClick : ((String) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): PlayGameRVAdapter.PlayGameViewHolder {
        val binding = PlayByGameRvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlayGameViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayGameRVAdapter.PlayGameViewHolder, position: Int) {
        Glide.with(holder.itemView).load(list[position].url).into(holder.image)
        holder.title.text = list[position].title
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(list[position].title)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}