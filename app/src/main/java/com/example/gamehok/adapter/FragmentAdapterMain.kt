package com.example.gamehok.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.gamehok.OverviewFragment
import com.example.gamehok.PlayersFragment
import com.example.gamehok.RulesFragment
import com.example.gamehok.StandingsFragment

class FragmentAdapterMain(fm : FragmentActivity): FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> return OverviewFragment()
            1 -> return PlayersFragment()
            2 -> return RulesFragment()
            3 -> return StandingsFragment() // Add additional fragment for tab 4
            else -> return OverviewFragment()
        }
    }
}