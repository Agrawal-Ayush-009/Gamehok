package com.example.gamehok

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gamehok.adapter.CompeteBattleRVAdapter
import com.example.gamehok.databinding.FragmentOverviewBinding
import com.example.gamehok.model.CompeteBattleItem

class OverviewFragment : Fragment() {
    private var _binding: FragmentOverviewBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentOverviewBinding.inflate(inflater, container, false)

        val moreTournamentRV = binding.moreTournamentRV
        val competeBattleList = arrayListOf(
            CompeteBattleItem(
                "1",
                "https://res.cloudinary.com/ddut9isww/image/upload/v1719680004/cx8ntgr88glfctjqhghp.jpg",
                "PUBG tournament  By Red Bull",
                "Jun 26 - Jun 27, 2024",
                "Entry - 10",
                "670/800",
                "10000"
            ),
            CompeteBattleItem(
                "2",
                "https://res.cloudinary.com/ddut9isww/image/upload/v1719643063/w7xpwtxjwor0l9jezj6p.jpg",
                "PUBG tournament  By Red Bull",
                "Jun 26 - Jun 27, 2024",
                "Entry - 10",
                "670/800",
                "10000"
            ),
            CompeteBattleItem(
                "2",
                "https://res.cloudinary.com/ddut9isww/image/upload/v1719643063/w7xpwtxjwor0l9jezj6p.jpg",
                "PUBG tournament  By Red Bull",
                "Jun 26 - Jun 27, 2024",
                "Entry - 10",
                "670/800",
                "10000"
            ),

            )

        val moreTournamentRVAdapter = CompeteBattleRVAdapter(competeBattleList)
        moreTournamentRV.adapter = moreTournamentRVAdapter
        moreTournamentRVAdapter.onItemClick = {
            startActivity(Intent(requireContext(), BattleDescriptionActivity::class.java))
            (activity as BattleDescriptionActivity).finish()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}