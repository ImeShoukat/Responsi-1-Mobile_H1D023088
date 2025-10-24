package com.example.responsi1mobileh1d023088

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.responsi1mobileh1d023088.databinding.ActivityHistoryClubBinding

class HistoryClub : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryClubBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryClubBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavigation()
        }
    private fun initNavigation(){
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}