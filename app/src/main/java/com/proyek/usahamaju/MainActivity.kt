package com.proyek.usahamaju

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.proyek.usahamaju.nav_fragment.Homefragment
import com.proyek.usahamaju.nav_fragment.KeamananFragment
import com.proyek.usahamaju.nav_fragment.PengaturanFragment
import com.proyek.usahamaju.nav_fragment.ProfileFragment
import com.proyek.usahamaju.ui.LoginScreen
import java.util.Objects

private lateinit var firebaseAuth:FirebaseAuth
    private lateinit var firebaseDatabase:FirebaseDatabase
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private val onBackPressedCallback : OnBackPressedCallback = object : OnBackPressedCallback(true){
        override fun handleOnBackPressed() {
            onBackPressedMethod()
        }
    }

    private fun onBackPressedMethod() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            finish()
        }
    }

    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onBackPressedDispatcher.addCallback(this,onBackPressedCallback)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        drawerLayout = findViewById(R.id.drawerLayout)

        val navigationView = findViewById<NavigationView>(R.id.navigateView)0
        val header = navigationView.getHeaderView(0)
        val userNameTxt = header.findViewById<TextView>(R.id.userNameTxt)
        val emailTxt = header.findViewById<TextView>(R.id.emailTxt)
        val profileImg = header.findViewById<ImageView>(R.id.profileImg)
        
        navigationView.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(
            this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        /// Default Navigation bar Tab Selected
        replaceFragment(Homefragment())
        navigationView.setCheckedItem(R.id.FabPengiriman)

        firebaseAuth = FirebaseAuth.getInstance()

        if(firebaseAuth.currentUser == null){
            val intent = Intent(this, LoginScreen::class.java)
            startActivity(intent)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.navFragment,fragment)
            .commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_profile -> {
                replaceFragment(ProfileFragment())
            }
            R.id.nav_keamanan -> {
                replaceFragment(KeamananFragment())
            }
            R.id.nav_pengaturan -> {
                replaceFragment(PengaturanFragment())
            }
            R.id.nav_logout -> {
                Toast.makeText(this,"Logout Klik",Toast.LENGTH_LONG).show()
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}