package com.tareasemana04

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.tareasemana04.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseApp.initializeApp(this)
        auth = Firebase.auth

        binding.btLogin.setOnClickListener{
            haceLogin();
        }

        binding.btRegister.setOnClickListener{
            haceRegister();
        }
    }

    private fun haceRegister() {
        val email = binding.etCorreo.text.toString()
        val contraseña = binding.etContraseA.text.toString()

        auth.createUserWithEmailAndPassword(email, contraseña)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("creando usuario", "registrado")
                    val user = auth.currentUser
                    actualiza(user)
                } else {
                    Log.d("creando usuario", "fallo")
                    Toast.makeText(baseContext,"fallo",Toast.LENGTH_LONG).show()
                    actualiza(null)
                }
            }
    }

    private fun actualiza(user: FirebaseUser?) {
        if (user != null) {
            val intent = Intent(this, Principal::class.java)
            startActivity(intent)
        }
    }

    private fun haceLogin() {
        val email = binding.etCorreo.text.toString()
        val contraseña = binding.etContraseA.text.toString()

        auth.signInWithEmailAndPassword(email, contraseña)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("Ingresando", "Autenticado")
                    val user = auth.currentUser
                    actualiza(user)
                } else {
                    Log.d("Ingresando", "fallo")
                    Toast.makeText(baseContext,"fallo",Toast.LENGTH_LONG).show()
                    actualiza(null)
                }
            }
    }
}