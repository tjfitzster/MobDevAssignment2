package org.wit.chatapplication.utils

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import org.wit.chatapplication.activities.LoginActivity
import org.wit.chatapplication.activities.MapsActivity
import org.wit.chatapplication.utils.Constants.MAP
import org.wit.chatapplication.utils.Constants.OPEN_GOOGLE
import org.wit.chatapplication.utils.Constants.OPEN_SEARCH

object BotResponses {

    fun basicResponses(message: String) : String {

        val random = (0..2).random()

        val message = message.lowercase()

        return when{
            //Hello
            message.contains("hello") -> {
                when (random){
                    0 -> "Hello There!"
                    1 -> "Alo"
                    2 -> "Ola"
                    else -> "error"
                }
            }

            message.contains("how are you?") -> {
                when (random){
                    0 -> "I am angry how about you?"
                    1 -> "I am hungry how about you?"
                    2 -> "I am great how about you?"
                    else -> "error"
                }
            }

            message.contains("flip") &&  message.contains("coin") -> {
                var r = (0..1).random()
                val result = if (r == 0) "heads" else "tails"
                "I flipped a coin and it esulted on $result"
            }

            message.contains("time") &&  message.contains("?") -> {
                Time.timeStamp()
            }

            message.contains("open") &&  message.contains("google") -> {
                OPEN_GOOGLE
            }

            message.contains("search") -> {
                OPEN_SEARCH
            }
            message.contains("map") -> {
                MAP
            }
            else ->
                when (random){
                    0 -> "I don't understand"
                    1 -> "idk!!!"
                    2 -> "try asking me something different"
                    else -> "error"
                }
        }

    }

}