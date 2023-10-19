package com.proyek.usahamaju.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.proyek.usahamaju.R

class HomeScreen : AppCompatActivity() {

    private lateinit var firebaseAuth : FirebaseAuth
    private lateinit var firebaseDatabase : FirebaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        firebaseAuth = FirebaseAuth.getInstance()

        if(firebaseAuth.currentUser ==null){
            val intent = Intent(this, LoginScreen::class.java)
            startActivity(intent)
        }
    }
    


}