package com.proyek.usahamaju

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.proyek.usahamaju.ui.LoginScreen

private lateinit var firebaseAuth:FirebaseAuth
    private lateinit var firebaseDatabase:FirebaseDatabase
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebaseAuth = FirebaseAuth.getInstance()

        if(firebaseAuth.currentUser ==null){
            val intent = Intent(this, LoginScreen::class.java)
            startActivity(intent)
        }
    }
}