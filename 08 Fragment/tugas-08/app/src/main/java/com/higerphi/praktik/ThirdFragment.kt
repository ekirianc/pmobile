package com.higerphi.praktik

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class ThirdFragment : Fragment() {
    private var txtName: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_third,
            container, false)
    }
    companion object {
        fun newInstance(): ThirdFragment {
            return ThirdFragment()
        }
    }
}