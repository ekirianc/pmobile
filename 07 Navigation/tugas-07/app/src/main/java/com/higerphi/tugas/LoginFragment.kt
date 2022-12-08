//LoginFragment.kt
package com.higerphi.tugas

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.higerphi.tugas.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil
            .inflate<FragmentLoginBinding>(inflater,
                R.layout.fragment_login,container,false)
        binding.masuk.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_login_to_home)
        }
        binding.daftarOnLogin.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_login_to_daftar)
        }
        return binding.root
    }
}