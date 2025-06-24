package com.example.todoapplication.ui.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.todoapplication.R
import com.example.todoapplication.databinding.SaveScreenBinding
import com.example.todoapplication.ui.viewmodel.SaveViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SaveScreen : Fragment() {
    private lateinit var binding: SaveScreenBinding
    private lateinit var viewModel: SaveViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SaveScreenBinding.inflate(inflater, container, false)

        //this - this@SaveScreen - requireContext() - applicationContext

        binding.saveButton.setOnClickListener {
            val name = binding.editTextName.text.toString()
            viewModel.save(name)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: SaveViewModel by viewModels()
        viewModel = tempViewModel
    }
}