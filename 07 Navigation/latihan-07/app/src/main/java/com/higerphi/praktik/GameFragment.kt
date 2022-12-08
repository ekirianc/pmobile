//GameFragment.kt
package com.higerphi.praktik

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.higerphi.praktik.databinding.FragmentGameBinding
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment : Fragment() {
    override fun onCreateView(inflater:
                              LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentGameBinding>(
            inflater, R.layout.fragment_game, container, false)
        binding.submitButton.setOnClickListener { view: View ->
            if (checkBox01.isChecked && checkBox02.isChecked) {
                view.findNavController()
                    .navigate(R.id.action_gameFragment_to_gameWonFragment)
            } else {
                view.findNavController()
                    .navigate(R.id.action_gameFragment_to_gameOverFragment)
            }
        }
        return binding.root
    }
}