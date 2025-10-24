package com.example.responsi1mobileh1d023088.viewmodel

import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.example.responsi1mobileh1d023088.data.model.entity.Team
import com.example.responsi1mobileh1d023088.data.network.FootBallAPI
import kotlinx.coroutines.launch

class TeamViewModel(private val api: FootBallAPI) : ViewModel() {

    private val _team = MutableLiveData<Result<Team>>()
    val team: MutableLiveData<Result<Team>> = _team

    fun getDetailTeam() {
        viewModelScope.launch {
            try {
                val response = api.getTeam();
                if (response.isSuccessful) {
                    val teamResponse = response.body()
                    if (teamResponse != null) {
                        _team.postValue(Result.success(teamResponse))
                        Log.d("TeamViewModel", "Fetched team: $teamResponse")
                    } else {
                        _team.postValue(Result.failure(Exception("Empty response body")))
                        Log.e("TeamViewModel", "Empty response body")
                    }
                } else {
                    Log.e("API_ERROR", "${response.code()} ${response.message()}")
                }

            } catch (e: Exception) {
                Log.e("TeamViewModel", "Exception during API call: ${e.message}", e)
                _team.postValue(Result.failure(e))
            }
        }
    }
}
