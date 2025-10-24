package com.example.responsi1mobileh1d023088

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.responsi1mobileh1d023088.data.network.RetrofitInstance
import com.example.responsi1mobileh1d023088.databinding.ActivityCoachBinding
import com.example.responsi1mobileh1d023088.viewmodel.TeamViewModel

class CoachActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoachBinding
    private lateinit var teamViewModel: TeamViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoachBinding.inflate(layoutInflater)
        setContentView(binding.root)

        teamViewModel = TeamViewModel(RetrofitInstance.getApiService())
        getDataCoach()
    }

    private fun getDataCoach() {
        teamViewModel.getDetailTeam()

        teamViewModel.team.observe(this) { result ->
            result.onSuccess { team ->
                val coach = team.coach

                // CEK null total
                if (coach == null) {
                    binding.tvFullName.text = "-"
                    binding.tvName.text = "Coach data not available"
                    binding.tvDateOfBirth.text = "-"
                    binding.tvNationality.text = "-"
                    binding.tvContract.text = "-"
                    return@onSuccess
                }

                // Gunakan safe-call & elvis operator
                val firstName = coach.firstName ?: "-"
                val lastName = coach.lastName ?: "-"
                val name = coach.name.ifEmpty { "-" }
                val dob = coach.dateOfBirth.ifEmpty { "-" }
                val nationality = coach.nationality.ifEmpty { "-" }
                val contractStart = coach.contract?.start ?: "Unknown"
                val contractUntil = coach.contract?.until ?: "Unknown"

                binding.tvFullName.text = "$name"
                binding.tvName.text = "Nama Depan: $firstName Nama Belakang: $lastName"
                binding.tvDateOfBirth.text = "Tanggal Lahir: $dob"
                binding.tvNationality.text = "Kebangsaan: $nationality"
                binding.tvContract.text = "Kontrak dari $contractStart hingga $contractUntil"

            }.onFailure { e ->
                e.printStackTrace()
                binding.tvFullName.text = "-"
                binding.tvName.text = "Failed to load coach data"
                binding.tvDateOfBirth.text = "-"
                binding.tvNationality.text = "-"
                binding.tvContract.text = "-"
            }
        }
    }
}
