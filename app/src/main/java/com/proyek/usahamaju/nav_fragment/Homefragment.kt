package com.proyek.usahamaju.nav_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.proyek.usahamaju.R
import com.proyek.usahamaju.bottom_fragment.ChartFragment
import com.proyek.usahamaju.bottom_fragment.FavoriteFragment
import com.proyek.usahamaju.bottom_fragment.MenuFragment
import com.proyek.usahamaju.bottom_fragment.PayFragment


class Homefragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_homefragment, container, false)

        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigationView.setOnItemSelectedListener{
            when(it.itemId){
                R.id.Bottom_Pay -> {
                    replaceFragment(PayFragment())
                    activity?.title = "Pay"
                }
                R.id.Bottom_Keranjang -> {
                    replaceFragment(ChartFragment())
                    activity?.title = "Keranjang"
                }
                R.id.Bottom_Favorite -> {
                    replaceFragment(FavoriteFragment())
                    activity?.title = "Favorite"
                }
                R.id.Bottom_Menu -> {
                    replaceFragment(MenuFragment())
                    activity?.title = "Menu"
                }
            }
            true
        }
        replaceFragment(Homefragment())
        activity?.title = "Home"
        bottomNavigationView.selectedItemId = R.id.addFabHome


        return view
    }
    private fun replaceFragment(fragment: Fragment) {
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.navFragment,fragment)
            .commit()
    }


}