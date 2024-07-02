package com.example.gamehok

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gamehok.adapter.CompeteBattleRVAdapter
import com.example.gamehok.adapter.TournamentRVAdapter
import com.example.gamehok.model.CompeteBattleItem
import org.w3c.dom.Text

class PlayGameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_game)
        val url = intent.getStringExtra("url")
        val title = intent.getStringExtra("name")

        val titleTV = findViewById<TextView>(R.id.gameHeader)
        titleTV.text = title

        val backButton = findViewById<ImageView>(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }

        val tournamentRV = findViewById<RecyclerView>(R.id.tournamentRV)
        val tournamentList = arrayListOf(
            CompeteBattleItem(
                "1",
                "https://res.cloudinary.com/ddut9isww/image/upload/v1719917528/bmymtb2uyvk3nuuzo3uh.png",
                "PUBG tournament  By Red Bull",
                "Jun 26 - Jun 27, 2024",
                "Entry - 10",
                "670/800",
                "10000"
            ),
            CompeteBattleItem(
                "1",
                "https://res.cloudinary.com/ddut9isww/image/upload/v1719917528/bmymtb2uyvk3nuuzo3uh.png",
                "PUBG tournament  By Red Bull",
                "Jun 26 - Jun 27, 2024",
                "Entry - 10",
                "670/800",
                "10000"
            ),
            CompeteBattleItem(
                "1",
                "https://res.cloudinary.com/ddut9isww/image/upload/v1719917528/bmymtb2uyvk3nuuzo3uh.png",
                "PUBG tournament  By Red Bull",
                "Jun 26 - Jun 27, 2024",
                "Entry - 10",
                "670/800",
                "10000"
            ),
            CompeteBattleItem(
                "1",
                "https://res.cloudinary.com/ddut9isww/image/upload/v1719917528/bmymtb2uyvk3nuuzo3uh.png",
                "PUBG tournament  By Red Bull",
                "Jun 26 - Jun 27, 2024",
                "Entry - 10",
                "670/800",
                "10000"
            ),
            CompeteBattleItem(
                "1",
                "https://res.cloudinary.com/ddut9isww/image/upload/v1719917528/bmymtb2uyvk3nuuzo3uh.png",
                "PUBG tournament  By Red Bull",
                "Jun 26 - Jun 27, 2024",
                "Entry - 10",
                "670/800",
                "10000"
            ),
            CompeteBattleItem(
                "1",
                "https://res.cloudinary.com/ddut9isww/image/upload/v1719917528/bmymtb2uyvk3nuuzo3uh.png",
                "PUBG tournament  By Red Bull",
                "Jun 26 - Jun 27, 2024",
                "Entry - 10",
                "670/800",
                "10000"
            ),
            CompeteBattleItem(
                "1",
                "https://res.cloudinary.com/ddut9isww/image/upload/v1719917528/bmymtb2uyvk3nuuzo3uh.png",
                "PUBG tournament  By Red Bull",
                "Jun 26 - Jun 27, 2024",
                "Entry - 10",
                "670/800",
                "10000"
            ),

            )
        findViewById<TextView>(R.id.tournamentHeader).text =
            "${tournamentList.size} Tournaments to battle"
        tournamentRV.adapter = TournamentRVAdapter(tournamentList)

        Glide.with(this)
            .load("https://res.cloudinary.com/ddut9isww/image/upload/v1719917712/drg7b8mtdxjstqwygxnb.webp")
            .into(findViewById(R.id.gameImage))
    }
}