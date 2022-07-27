package com.example.tictactoe_task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.tictactoe_task.databinding.FragmentSelectorBinding

class FragmentSelector : Fragment() {

    private lateinit var binding: FragmentSelectorBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSelectorBinding.inflate(layoutInflater, container, false)
        goToFragments()
        return binding.root
    }

    private fun goToFragments(){
        binding.btn3x3.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_fragmentSelector_to_fragment9)
        }

        binding.btn4x4.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_fragmentSelector_to_fragment16)
        }

        binding.btn5x5.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_fragmentSelector_to_fragment25)
        }
    }

}