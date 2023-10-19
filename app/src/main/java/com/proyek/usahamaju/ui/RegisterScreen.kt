package com.proyek.usahamaju.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.proyek.usahamaju.R
import com.proyek.usahamaju.databinding.ActivityRegisterScreenBinding

class RegisterScreen : AppCompatActivity() {
    private lateinit var binding:ActivityRegisterScreenBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var firebaseDatabase : FirebaseDatabase
    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\\\.+[a-z]+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        firebaseDatabase = FirebaseDatabase.getInstance()

        val signUpNama : EditText = findViewById(R.id.namaEt)
        val signUpEmail : EditText = findViewById(R.id.emailEt)
        val signUpPass : EditText = findViewById(R.id.passEt)
        val signUpConfPass : EditText = findViewById(R.id.confpassEt)
        val signUpBtn : AppCompatButton = findViewById(R.id.buttonDaftar)


        binding.textView.setOnClickListener{
            val intent = Intent(this,LoginScreen::class.java)
            startActivity(intent)
        }

//        binding.buttonDaftar.setOnClickListener {
//            val nama = signUpNama.text.toString()
//            val email = signUpEmail.text.toString()
//            val pass = signUpPass.text.toString()
//            val confPass = signUpConfPass.text.toString()
//
//
//
//            if (nama.isEmpty() || email.isEmpty() || pass.isEmpty() || confPass.isEmpty()){
//                if(nama.isEmpty()){
//                    signUpNama.error = "Masukan Nama"
//                }
//                if(email.isEmpty()){
//                    signUpNama.error = "Masukan Email"
//                }
//                if(pass.isEmpty()){
//                    signUpNama.error = "Masukan Kata Sandi"
//                }
//                if(confPass.isEmpty()){
//                    signUpNama.error = "Masukan Konfirmasi Kata Sandi"
//                }
//                Toast.makeText(this,"Masukan Data valid", Toast.LENGTH_SHORT).show()
//
//
//            }else if (!email.matches(emailPattern.toRegex())){
//                signUpEmail.error = "Masukan Email Valid"
//                Toast.makeText(this, "Masukan Email Valid", Toast.LENGTH_SHORT).show()
//            }else if (pass.length < 6){
//                signUpPass.error = "Masukan Email Valid"
//                Toast.makeText(this, "Masukan Email Valid", Toast.LENGTH_SHORT).show()
//            }else if (pass != confPass){
//                signUpConfPass.error = "Kata Sandi Tidak Sama"
//                Toast.makeText(this, "Kata Sandi Tidak Sama", Toast.LENGTH_SHORT).show()
//            }else{
//                firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
//                    if(it.isSuccessful){
//                        val databaseRef = firebaseDatabase.reference.child("users").child(firebaseAuth.currentUser!!.uid)
//                        val users : Users = Users(nama, email, firebaseAuth.currentUser!!.uid)
//
//                        databaseRef.setValue(users).addOnCompleteListener {
//                            if(it.isSuccessful){
//                                val intent = Intent(this, LoginScreen::class.java)
//                                startActivity(intent)
//                            }else{
//                                Toast.makeText(this, "ada yang salah, Coba lagi", Toast.LENGTH_SHORT).show()
//                            }
//                        }
//                    }else{
//                        Toast.makeText(this, "ada yang salah, Coba lagi", Toast.LENGTH_SHORT).show()
//                    }
//                }
//            }
//
//        }
        binding.buttonDaftar.setOnClickListener{
            val email = binding.emailEt.text.toString()
            val pass = binding.passEt.text.toString()
            val confirmpass = binding.confpassEt.text.toString()

            if (email.isNotEmpty() && confirmpass.isNotEmpty()){
                if(pass == confirmpass){
                    firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener{
                        if(it.isSuccessful){
                            val intent = Intent(this,LoginScreen::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Toast.makeText(this, "Password tidak sama", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "formulir tidak boleh kosong !", Toast.LENGTH_SHORT).show()
            }
        }
    }
}