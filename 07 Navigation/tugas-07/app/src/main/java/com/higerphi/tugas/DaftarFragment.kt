//DaftarFragment.kt
package com.higerphi.tugas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.higerphi.tugas.databinding.FragmentDaftarBinding

class DaftarFragment : Fragment(){
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil
            .inflate<FragmentDaftarBinding>(
                inflater,
                R.layout.fragment_daftar, container, false
            )
        binding.daftar.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_daftar_to_home)
        }
        return binding.root
    }
}