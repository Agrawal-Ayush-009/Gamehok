package com.example.gamehok.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.gamehok.databinding.CompeteInBattleRvItemBinding
import com.example.gamehok.model.CompeteBattleItem

class CompeteBattleRVAdapter(private val list: ArrayList<CompeteBattleItem>):RecyclerView.Adapter<CompeteBattleRVAdapter.CompeteBattleViewHolder>() {

    inner class CompeteBattleViewHolder(binding: CompeteInBattleRvItemBinding): RecyclerView.ViewHolder(binding.root){
        val image = binding.eventImage
        val title = binding.eventTitle
        val time = binding.eventTiming
        val entryFee = binding.entryFee
        val prize = binding.prize
        val participation = binding.eventParticipant
    }

    var onItemClick: ((String) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): CompeteBattleRVAdapter.CompeteBattleViewHolder {
        val binding = CompeteInBattleRvItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CompeteBattleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CompeteBattleRVAdapter.CompeteBattleViewHolder, position: Int) {
        Glide.with(holder.itemView).load(list[position].imgUrl).into(holder.image)
        holder.title.text = list[position].title
        holder.time.text = list[position].timing
        holder.entryFee.text = list[position].entryFee
        holder.prize.text = list[position].prize
        holder.participation.text = list[position].participation
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(list[position].id)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    private val runnable = Runnable {
        list.addAll(list)
        notifyDataSetChanged()
    }

}