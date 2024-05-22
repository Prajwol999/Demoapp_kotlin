package com.example.demokotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demokotlin.R
import com.example.demokotlin.adapter.RecyclerAdapter
import com.example.demokotlin.databinding.FragmentListBinding


class ListFragment : Fragment() {
    
    lateinit var listBinding: FragmentListBinding
    var title=ArrayList<String>()
    var image=ArrayList<Int>()
    
    

    

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        
        listBinding= FragmentListBinding.inflate(inflater,container,false)
        title.add("instagram")
        image.add(R.drawable.insta)
        
        title.add("facebook")
        image.add(R.drawable.fb)
        
        title.add("google")
        image.add(R.drawable.google)
        
        var adapter= RecyclerAdapter(title,image)
        listBinding.recyclerView.layoutManager=LinearLayoutManager(context)
        listBinding.recyclerView.adapter=adapter

        return listBinding.root
    }

    
    }
