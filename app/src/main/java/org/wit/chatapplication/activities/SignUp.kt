package org.wit.chatapplication.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.wit.chatapplication.R

class SignUp : AppCompatActivity() {

    private lateinit var  edtEmail: EditText
    private lateinit var  edtPassword: EditText
    private lateinit var  btnSignUp: Button
    private lateinit var  edtName: EditText
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sign_up)
        supportActionBar?.hide()

        mAuth = FirebaseAuth.getInstance()
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

    private fun signup(name: String, email: String, password: String){

        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // write code for jumping to home activity
                        addUserToDatabase(name, email, mAuth.currentUser?.uid!!)
                    val intent = Intent(this@SignUp, MainActivity::class.java)
                    finish()
                    startActivity(intent)
                } else {
                    Toast.makeText(this@SignUp, "Some Error Occured", Toast.LENGTH_SHORT).show()
                }
            }

    }

    private fun addUserToDatabase(name: String, email: String, uid: String){

        mDbRef = FirebaseDatabase.getInstance().getReference()

        mDbRef.child("user").child(uid).setValue(User(name, email, uid))

    }

}