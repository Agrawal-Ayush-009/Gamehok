package com.example.gamehok.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.example.gamehok.R
import com.example.gamehok.databinding.CompeteInBattleRvItemBinding
import com.example.gamehok.model.CompeteBattleItem

class CompeteViewPagerAdapter(private val list: ArrayList<CompeteBattleItem>, private val context: Context): PagerAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == (`object`)
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding = CompeteInBattleRvItemBinding.inflate(LayoutInflater.from(context), container, false)

        val item = list[position]
        val title = item.title
        val image = item.imgUrl
        val participation = item.participation
        val prize = item.prize
        val entryFee = item.entryFee
        val timing = item.timing

        binding.prize.text = prize
        binding.eventTitle.text = title
        binding.eventParticipant.text = participation
        binding.eventTiming.text = timing
        binding.entryFee.text = entryFee
        Glide.with(context).load(image).into(binding.eventImage)

        binding.root.setOnClickListener {
            Toast.makeText(context, "$title", Toast.LENGTH_SHORT).show()
        }


        container.addView(binding.root)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}