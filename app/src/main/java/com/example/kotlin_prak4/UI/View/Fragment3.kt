package com.example.kotlin_prak4.UI.View

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.kotlin_prak4.R

class Fragment3 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment3, container, false)

        val buttonToFragment1 = view.findViewById<Button>(R.id.button_back_fragment3)

        buttonToFragment1.setOnClickListener {
            findNavController().navigate(R.id.action_fragment3_to_fragment1)
        }

        return view
    }
}