package com.example.gamehok

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class PlayGameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play_game)

        Glide.with(this).load("https://res.cloudinary.com/ddut9isww/image/upload/v1719643063/ytydf5xetxq4dalphcls.png").into(findViewById(R.id.gameImage))
    }
}