package com.example.demokotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.demokotlin.R
import com.example.demokotlin.databinding.FragmentPrajwalBinding


class PrajwalFragment : Fragment() {

    lateinit var prajwalBinding: FragmentPrajwalBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        prajwalBinding = FragmentPrajwalBinding.inflate(layoutInflater)

        prajwalBinding.bttonclick.setOnClickListener {
            var username:String = prajwalBinding.usrname.text.toString()
            var password:String = prajwalBinding.password78.text.toString()

        }
        // Inflate the layout for this fragment
        return prajwalBinding.root
    }

}