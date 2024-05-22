package com.example.demokotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.demokotlin.databinding.ActivityDashBoardBinding
import com.example.demokotlin.fragments.FavouriteFragment
import com.example.demokotlin.fragments.HomeFragment
import com.example.demokotlin.fragments.SearchFragment

class DashBoard : AppCompatActivity() {

    lateinit var dashBoardBinding: ActivityDashBoardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        dashBoardBinding = ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(dashBoardBinding.root)

        dashBoardBinding.navMenu.setOnItemSelectedListener{
            when(it.itemId){
                R.id.home->replaceFragment(HomeFragment())
                R.id.search->replaceFragment(SearchFragment())
                R.id.favourite->replaceFragment(FavouriteFragment())
                R.id.list->replaceFragment(SearchFragment())
                else->{}



            }
            true


            }
        }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager:FragmentManager=supportFragmentManager
        val fragmentTransaction:FragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()
    }


}

