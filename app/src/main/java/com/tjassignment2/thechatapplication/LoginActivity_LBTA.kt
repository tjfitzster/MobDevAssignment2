package com.tjassignment2.thechatapplication

import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity_LBTA : AppCompatActivity() {

    private lateinit var btnLogin: Button
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var back_to_register_textview: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_lbta)

        btnLogin = findViewById(R.id.login_button_login)
        edtEmail = findViewById(R.id.email_edittext_login)
        edtPassword = findViewById(R.id.password_edittext_login)

        btnLogin.setOnClickListener {
            val Email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            Log.d("Login", "Attempt login with email/pw: $Email/***")
        }

        back_to_register_textview.setOnClickListener{
            finish()
        }
    }

}