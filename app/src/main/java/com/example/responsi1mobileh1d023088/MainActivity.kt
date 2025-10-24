package com.example.responsi1mobileh1d023088

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.responsi1mobileh1d023088.data.model.entity.Coach
import com.example.responsi1mobileh1d023088.data.model.entity.Player
import com.example.responsi1mobileh1d023088.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initLayout()
        initListener()
    }

    private fun initListener() {
        binding.layoutHistory.root.setOnClickListener {
            startActivity(Intent(this, HistoryClub::class.java))
        }
        binding.layoutHead.root.setOnClickListener {
            startActivity(Intent(this, CoachActivity::class.java))
        }
        binding.layoutTeam.root.setOnClickListener {
            startActivity(Intent(this, PlayerActivity::class.java))
        }
    }

    private fun initLayout(){
        binding.layoutHistory.let{
            it.imgIcon.setImageResource(R.drawable.soccer)
            it.tvLayout.text = getString(R.string.history)
        }
        binding.layoutHead.let{
            it.imgIcon.setImageResource(R.drawable.lead)
            it.tvLayout.text = getString(R.string.headclub)
        }
        binding.layoutTeam.let{
            it.imgIcon.setImageResource(R.drawable.teams)
            it.tvLayout.text = getString(R.string.team)
        }

}}