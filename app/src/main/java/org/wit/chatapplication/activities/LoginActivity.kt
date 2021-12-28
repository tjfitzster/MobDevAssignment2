package org.wit.chatapplication.activities


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.wit.chatapplication.databinding.LoginscreenBinding
import org.wit.chatapplication.models.UserModel


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: LoginscreenBinding
    var user = UserModel()
    var user1 = UserModel()
    var user2 = UserModel()
    var user3 = UserModel()

    private var loggedin: Boolean = false

    private val users = ArrayList<UserModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginscreenBinding.inflate(layoutInflater)


        setContentView(binding.root)
        // JUST PRELOADING THE USER MODEL WITH PEOPLE

        user1.username = "Monty"
        user1.password = "Password123"
        user2.username = "Chris"
        user2.password = "Password123"
        user3.username = "TJ"
        user3.password = "Password123"


        // jsut pre laodign a list
        users.add(user1.copy())
        users.add(user2.copy())
        users.add(user3.copy())



        val intent = Intent(this, MainActivity::class.java)

        binding.loginbutton.setOnClickListener() {

            this.user.username = binding.username.text.toString()
            this.user.password = binding.password.text.toString()

            for (i in users.indices) {
                if ((users[i].username.equals(this.user.username)) && (users[i].password.equals(this.user.password))) // checking if username match
                {       loggedin = true
                        startActivity(intent)
                }
                else{
                    if (loggedin == false) {
                       // Toast.makeText(this, "USER NOT REGISTERED ", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

       binding.registerbutton.setOnClickListener() {
           // just a bit of validaton
           this.user.username = binding.username.text.toString()
           this.user.password = binding.password.text.toString()

           for (i in users.indices) {
               if (users[i].username.equals(this.user.username))  // checking if username match
               {
                   Toast.makeText(this, "USER ALREADY EXISTS ", Toast.LENGTH_SHORT).show()
               } else {
                   if(this.user.password.length < 5)
                   {
                       Toast.makeText(this, "PASSWORD MUST BE MORE THAN 4 CHARACTERS ", Toast.LENGTH_SHORT).show()
                   }
                   else{
                       users.add(user.copy())
                       Toast.makeText(this, "NEW USER ADDED ", Toast.LENGTH_SHORT).show()
                   }

               }
           }

       }
    }
}