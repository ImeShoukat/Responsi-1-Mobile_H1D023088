package com.example.responsi1mobileh1d023088

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.responsi1mobileh1d023088.databinding.ActivityMenuBinding


class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initLayout()
        initListener()
    }

    private fun initListener() {
        binding.layoutHistory.root.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        binding.layoutHead.root.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        binding.layoutTeam.root.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
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
    }

}