package com.example.gamehok

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.gamehok.adapter.CompeteBattleRVAdapter
import com.example.gamehok.adapter.CompeteViewPagerAdapter
import com.example.gamehok.adapter.FollowPeopleRVAdapter
import com.example.gamehok.adapter.ImageAdapter
import com.example.gamehok.adapter.PlayGameRVAdapter
import com.example.gamehok.adapter.UncontainedCarouselLayoutManager
import com.example.gamehok.databinding.FragmentHomeBinding
import com.example.gamehok.model.CompeteBattleItem
import com.example.gamehok.model.FollowPeopleModel
import com.example.gamehok.model.ImageItem
import com.example.gamehok.model.PlayGameItem
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.FullScreenCarouselStrategy
import com.google.android.material.carousel.HeroCarouselStrategy
import com.google.android.material.carousel.UncontainedCarouselStrategy

import java.util.UUID

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewpager2: ViewPager2
    private lateinit var pageChangeListener: ViewPager2.OnPageChangeCallback
    private lateinit var competeBattleViewPager: ViewPager2
    private lateinit var handler: Handler
    private lateinit var imageList: ArrayList<Int>
    private lateinit var adapter: ImageAdapter

    private val params = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.WRAP_CONTENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
    ).apply {
        setMargins(8, 0, 8, 0)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        ImageUIUpdate()
        PlayGameUIUpdate()

        val competeBattleRecyclerView = binding.competeBattleRV

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


        val competeBattleAdapter = CompeteBattleRVAdapter(competeBattleList)
        competeBattleRecyclerView.adapter = competeBattleAdapter
        competeBattleAdapter.notifyDataSetChanged()
        competeBattleAdapter.onItemClick = {
            startActivity(Intent(requireContext(), BattleDescriptionActivity::class.java))
        }


        val followPeopleRV = binding.followPeopleRV
        val followPeopleList = arrayListOf(
            FollowPeopleModel("Adam Reeves", "https://res.cloudinary.com/ddut9isww/image/upload/v1719677247/hedd2trnymqxxexyvjf6.jpg"),
            FollowPeopleModel("Lisa Paulsen", "https://res.cloudinary.com/ddut9isww/image/upload/v1719677247/odciuxbbmgnrmcq8px7h.webp"),
            FollowPeopleModel("Harvey Spectre", "https://res.cloudinary.com/ddut9isww/image/upload/v1719677410/lqaqrka7wfrhxjqolvc3.jpg"),
        )

        val followPeopleAdapter = FollowPeopleRVAdapter(followPeopleList)
        followPeopleRV.adapter = followPeopleAdapter
        followPeopleAdapter.onItemClicked = {
            Toast.makeText(requireContext(), "Followed ${it}", Toast.LENGTH_SHORT).show()
        }


        return binding.root
    }

    private fun PlayGameUIUpdate() {
        val playGameRV = binding.playByGamesRV
        val playGameList = arrayListOf(
            PlayGameItem(
                "https://res.cloudinary.com/ddut9isww/image/upload/v1719643063/ytydf5xetxq4dalphcls.png",
                "PUBG"
            ),
            PlayGameItem(
                "https://res.cloudinary.com/ddut9isww/image/upload/v1719643063/rsh6rlxlc2coxwpz9hm7.jpg",
                "Valorant"
            ),
            PlayGameItem(
                "https://res.cloudinary.com/ddut9isww/image/upload/v1719643062/atl4wvhvtujfapk9wla7.jpg",
                "Apex Legend"
            ),
            PlayGameItem(
                "https://res.cloudinary.com/ddut9isww/image/upload/v1719643063/w7xpwtxjwor0l9jezj6p.jpg",
                "Call of Duty"
            ),
            PlayGameItem(
                "https://res.cloudinary.com/ddut9isww/image/upload/v1719643063/sypq3cyu1hgkmr9mldmu.jpg",
                "Counter Strike"
            ),
            PlayGameItem(
                "https://res.cloudinary.com/ddut9isww/image/upload/v1719643063/ytydf5xetxq4dalphcls.png",
                "PUBG"
            ),
        )
        val playGameAdapter = PlayGameRVAdapter(playGameList)
        playGameRV.adapter = playGameAdapter
        playGameAdapter.onItemClick = {
            val intent = Intent(requireContext(), PlayGameActivity::class.java)
            intent.putExtra("url", it.url)
            intent.putExtra("name", it.title)
            startActivity(intent)
        }
    }

    private fun ImageUIUpdate() {
        val imageAdapter = ImageAdapter()
        viewpager2 = binding.viewpager2

        val imageList = arrayListOf(
            ImageItem(
                UUID.randomUUID().toString(),
                "https://res.cloudinary.com/ddut9isww/image/upload/v1719644562/nchnrbrfnvl6sachootg.avif"
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "https://res.cloudinary.com/ddut9isww/image/upload/v1719644562/nchnrbrfnvl6sachootg.avif"
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "https://res.cloudinary.com/ddut9isww/image/upload/v1719644562/nchnrbrfnvl6sachootg.avif"
            ),
        )

        viewpager2.adapter = imageAdapter
        imageAdapter.submitList(imageList)


        val slideDotLL = binding.slideDotLL
        val dotsImage = Array(imageList.size) {
            ImageView(requireContext())
        }

        dotsImage.forEach {
            it.setImageResource(
                R.drawable.non_active_dot
            )
            slideDotLL.addView(it, params)
        }

        dotsImage[0].setImageResource(R.drawable.active_dot)

        pageChangeListener = object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                dotsImage.mapIndexed { index, imageView ->
                    if (position == index) {
                        imageView.setImageResource(
                            R.drawable.active_dot
                        )
                    } else {
                        imageView.setImageResource(R.drawable.non_active_dot)
                    }
                }
                super.onPageSelected(position)
            }
        }
        viewpager2.registerOnPageChangeCallback(pageChangeListener)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewpager2.unregisterOnPageChangeCallback(pageChangeListener)
        _binding = null
    }
}