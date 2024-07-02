package com.example.gamehok.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gamehok.databinding.FollowPeopleItemBinding
import com.example.gamehok.model.FollowPeopleModel

class FollowPeopleRVAdapter(private val list: List<FollowPeopleModel>): RecyclerView.Adapter<FollowPeopleRVAdapter.FollowPeopleViewHolder>() {

    inner class FollowPeopleViewHolder(binding: FollowPeopleItemBinding): RecyclerView.ViewHolder(binding.root) {
        val pp = binding.profilePic
        val personName = binding.name
        val followButton = binding.followButton

    }

    var onItemClicked: ((String) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): FollowPeopleRVAdapter.FollowPeopleViewHolder {
        val binding = FollowPeopleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FollowPeopleViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: FollowPeopleRVAdapter.FollowPeopleViewHolder,
        position: Int,
    ) {
        Glide.with(holder.itemView).load(list[position].profilePic).into(holder.pp)
        holder.personName.text = list[position].name
        holder.followButton.setOnClickListener {
            onItemClicked?.invoke(list[position].name)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}