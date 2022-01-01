package com.tjassignment2.thechatapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText



class MainActivity_LBTA : AppCompatActivity() {

    private lateinit var btnRegister: Button
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var already_have_account_text_view: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_lbta)

        btnRegister = findViewById(R.id.register_button_register)
        edtEmail = findViewById(R.id.email_edittext_register)
        edtEmail = findViewById(R.id.email_edittext_register)
        edtPassword = findViewById(R.id.password_edittext_register)
        already_have_account_text_view = findViewById(R.id.already_have_account_text_view)


   btnRegister.setOnClickListener()
    {
          val email = edtEmail.text.toString()
           val password = edtPassword.text.toString()

        // Firebase Authentication to create a user with email and password
    }

        already_have_account_text_view.setOnClickListener {
            //   Log.d("MainActivity", "Try to show login activity")

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}


