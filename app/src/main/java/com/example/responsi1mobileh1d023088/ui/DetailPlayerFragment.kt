package com.example.responsi1mobileh1d023088.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.responsi1mobileh1d023088.R
import com.example.responsi1mobileh1d023088.data.model.entity.Contract
import com.example.responsi1mobileh1d023088.databinding.FragmentDetailPlayerBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class DetailPlayerFragment (
    private val playerName: String,
    private val position: String,
    private val nationality: String,
    private val dateOfBirth: String,
    private val shirtNumber: Int,
    private val marketValue: Int,
    private val contract: Contract?
) : BottomSheetDialogFragment(){
    private var _binding: FragmentDetailPlayerBinding? = null
    private val binding get() = _binding!!

    override fun getTheme(): Int = R.style.ThemeOverlay_App_BottomSheetDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun loadData() {
        binding.tvPlayerName.text = playerName
        binding.tvPosition.text = "Posisi: ${position}"
        binding.tvNationality.text = "Kebangsaan: ${nationality}"
        binding.tvDateOfBirth.text = "Tanggal Lahir: ${dateOfBirth}"
        binding.tvShirtNumber.text = "Nomor Kaus: ${shirtNumber.toString()}"
        binding.tvMarketValue.text = "Value: ${marketValue.toString()}"
        binding.tvContract.text = if (contract != null) {
            "Contract: From ${contract.start} to ${contract.until}"
        } else {
            "Contract: Tidak Tersedia"
        }
    }

}
