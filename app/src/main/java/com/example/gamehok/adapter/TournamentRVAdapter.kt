package com.example.gamehok.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.gamehok.databinding.CompeteInBattleRvItemBinding
import com.example.gamehok.databinding.GameTournamentItemBinding
import com.example.gamehok.model.CompeteBattleItem
import com.example.gamehok.model.PlayGameItem

class TournamentRVAdapter(private val list: ArrayList<CompeteBattleItem>):RecyclerView.Adapter<TournamentRVAdapter.CompeteBattleViewHolder>() {

    inner class CompeteBattleViewHolder(binding: GameTournamentItemBinding): RecyclerView.ViewHolder(binding.root){
        val image = binding.gameImage
        val title = binding.eventTitle
        val time = binding.eventTiming
        val entryFee = binding.entryFee
        val participation = binding.eventParticipant
    }

    var onItemClick: ((String) -> Unit)? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): TournamentRVAdapter.CompeteBattleViewHolder {
        val binding = GameTournamentItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CompeteBattleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TournamentRVAdapter.CompeteBattleViewHolder, position: Int) {
        Glide.with(holder.itemView).load(list[position].imgUrl).into(holder.image)
        holder.title.text = list[position].title
        holder.time.text = list[position].timing
        holder.entryFee.text = list[position].entryFee
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