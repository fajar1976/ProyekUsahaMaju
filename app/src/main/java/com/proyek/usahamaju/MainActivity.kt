package com.proyek.usahamaju

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.proyek.usahamaju.fragments.DompetFragment
import com.proyek.usahamaju.fragments.HomeFragment
import com.proyek.usahamaju.fragments.KeranjangFragment
import com.proyek.usahamaju.fragments.MenuFragment
import com.proyek.usahamaju.ui.LoginScreen
import com.qamar.curvedbottomnaviagtion.CurvedBottomNavigation


private lateinit var firebaseAuth:FirebaseAuth
    private lateinit var firebaseDatabase:FirebaseDatabase
class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation = findViewById<CurvedBottomNavigation>(R.id.bottomNavigation)
        bottomNavigation.add(
            CurvedBottomNavigation.Model(1,"Home", R.drawable.ic_home)
        )
        bottomNavigation.add(
            CurvedBottomNavigation.Model(2,"Uang", R.drawable.ic_uang)
        )
                bottomNavigation.add(
            CurvedBottomNavigation.Model(3,"Keranjang", R.drawable.ic_keranjang)
        )
        bottomNavigation.add(
            CurvedBottomNavigation.Model(4,"Menu", R.drawable.ic_menu)
        )
        bottomNavigation.setOnClickMenuListener {
            when(it.id){
                1 -> {
                    replaceFragment(HomeFragment())
                }
                2 -> {
                    replaceFragment(DompetFragment())
                }
                3 -> {
                    replaceFragment(KeranjangFragment())
                }
                4 -> {
                    replaceFragment(MenuFragment())
                }
            }
        }




        firebaseAuth = FirebaseAuth.getInstance()

        if(firebaseAuth.currentUser == null){
            val intent = Intent(this, LoginScreen::class.java)
            startActivity(intent)
        }
        //default tombol awal
        replaceFragment(HomeFragment())
        bottomNavigation.show(1)
    }
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer,fragment)
            .commit()
    }



}