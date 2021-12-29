package com.tjassignment2.thechatapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.tjassignment2.thechatapplication.UserModel


class SignupActivity : AppCompatActivity() {

    var user = UserModel()
    var user1 = UserModel()
    var user2 = UserModel()
    var user3 = UserModel()


    private val users = ArrayList<UserModel>()


    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnSignUp: Button
    private lateinit var edtName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        supportActionBar?.hide()

        user1.username = "Monty"
        user1.password = "Password123"
        user2.username = "Chris"
        user2.password = "Password123"
        user3.username = "TJ"
        user3.password = "Password123"

        edtName = findViewById(R.id.edt_name)
        edtEmail = findViewById(R.id.edt_email)
        edtPassword = findViewById(R.id.edt_password)
        btnSignUp = findViewById(R.id.btnSignup)

        btnSignUp.setOnClickListener {

            val name = edtName.text.toString()
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            signup(name, email, password)

        }
    }

    private fun signup(name: String, email: String, password: String) {

        Toast.makeText(this, "USER FOUND", Toast.LENGTH_SHORT).show()
        val intent = Intent(this@SignupActivity, MainActivity::class.java)
        finish()
        startActivity(intent)

       // if ((user.username.isNotEmpty()) && (user.password.isNotEmpty())) {
         //   users.add(user.copy())
      //      Toast.makeText(this, "REGISTERING A NEW USER", Toast.LENGTH_SHORT).show()
      //  }
    }
}