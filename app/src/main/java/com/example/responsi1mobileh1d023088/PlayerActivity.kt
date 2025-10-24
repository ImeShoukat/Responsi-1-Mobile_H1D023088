package com.example.responsi1mobileh1d023088

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.appcompat.app.AppCompatActivity
import com.example.responsi1mobileh1d023088.databinding.ActivityPlayerBinding
import com.example.responsi1mobileh1d023088.viewmodel.TeamViewModel
import com.example.responsi1mobileh1d023088.data.model.entity.Player
import com.example.responsi1mobileh1d023088.data.network.RetrofitInstance
import com.example.responsi1mobileh1d023088.ui.PlayerAdapter
import com.example.responsi1mobileh1d023088.ui.DetailPlayerFragment


class PlayerActivity : AppCompatActivity(), PlayerAdapter.OnPlayerClickListener {

    lateinit var binding: ActivityPlayerBinding
    private lateinit var teamViewModel: TeamViewModel

    private val adapter = PlayerAdapter(emptyList(), this)

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter


        teamViewModel = TeamViewModel(RetrofitInstance.getApiService())

        teamViewModel.getDetailTeam()
        teamViewModel.team.observe(this) { result ->
            result.onSuccess { team ->
                adapter.players = team.squad
                adapter.notifyDataSetChanged()
            }.onFailure { e ->
                e.printStackTrace()
            }
        }
    }
    override fun onPlayerClick(player: Player) {
        player.let { b ->
            DetailPlayerFragment(
                playerName = b.name,
                position = b.position,
                nationality = b.nationality,
                dateOfBirth = b.dateOfBirth,
                shirtNumber = b.shirtNumber,
                marketValue = b.marketValue,
                contract = b.contract
            ).show(supportFragmentManager, DetailPlayerFragment::class.java.simpleName)
        }
    }
}