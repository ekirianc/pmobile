//ConfirmFragment.kt
package com.higerphi.tugas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.higerphi.tugas.databinding.FragmentConfirmBinding

class ConfirmFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil
            .inflate<FragmentConfirmBinding>(
                inflater,
                R.layout.fragment_confirm, container, false
            )
        binding.confirmTidakButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_confirm_to_home)
        }
        binding.confirmYaButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_confirm_to_login)
        }
        return binding.root
    }
}