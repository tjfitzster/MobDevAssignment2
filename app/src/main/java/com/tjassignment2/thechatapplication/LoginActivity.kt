package com.tjassignment2.thechatapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast



class LoginActivity : AppCompatActivity() {


    val users = ArrayList<UserModel>()

    var user = UserModel()
    var user1 = UserModel()
    var user2 = UserModel()
    var user3 = UserModel()

    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnSignUp: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        supportActionBar?.hide()
        edtEmail = findViewById(R.id.edt_email)
        edtPassword = findViewById(R.id.edt_password)
        btnLogin = findViewById(R.id.btnLogin)
        btnSignUp = findViewById(R.id.btnSignup)

        user1.username = "Monty"
        user1.password = "Password123"
        user2.username = "Chris"
        user2.password = "Password123"
        user3.username = "TJ"
        user3.password = "Password123"

        users.add(user1.copy())
        users.add(user2.copy())
        users.add(user3.copy())

        btnSignUp.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()
            login(email, password)
        }
    }

    private fun login(email: String, password: String) {

        Toast.makeText(this, "USER FOUND", Toast.LENGTH_SHORT).show()
        val intent = Intent(this@LoginActivity, MainActivity::class.java)
        finish()
        startActivity(intent)

        //for (i in users.indices) {
          //  if (this.users[i].username.equals(user.username)) {
              //  Toast.makeText(this, "USER FOUND", Toast.LENGTH_SHORT).show()
              //  val intent = Intent(this@LoginActivity, MainActivity::class.java)
             //   finish()
             //   startActivity(intent)
        //    } else {
             //   Toast.makeText(this, "USER NOT FOUND", Toast.LENGTH_SHORT).show()
          //  }

      //  }

    }
}
