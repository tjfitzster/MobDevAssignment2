package org.wit.chatapplication.activities


import androidx.appcompat.app.AppCompatActivity

import android.net.Uri
import android.os.Bundle
import org.wit.chatapplication.models.Message
import org.wit.chatapplication.utils.Constants.RECIEVE_ID
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import org.wit.chatapplication.utils.Constants.SEND_ID
import org.wit.chatapplication.utils.BotResponses
import org.wit.chatapplication.utils.Constants.OPEN_GOOGLE
import org.wit.chatapplication.utils.Constants.OPEN_SEARCH
import org.wit.chatapplication.utils.Time

import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.maps.GoogleMap
import kotlinx.coroutines.*
import org.wit.chatapplication.adapters.MessagingAdapter
import org.wit.chatapplication.databinding.ActivityChatBinding
import org.wit.chatapplication.models.Location
import org.wit.chatapplication.utils.Constants.MAP


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityChatBinding
    private lateinit var adapter: MessagingAdapter

    var messagesList = mutableListOf<Message>()

    private val botlist = listOf("MIKE","JIM","LUKE","KEN","TJ")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)

        setContentView(binding.root)

        recyclerView()

        clickEvents()
        val random = (0..3).random()
        customBotMessage("Hello today you are speaking with ${botlist[random]}, how may I help you?")

    }

    private fun clickEvents() {


        binding.btnSend.setOnClickListener {
            sendMessage()
        }

        //Scroll back to correct position when user clicks on text view
        binding.etMessage.setOnClickListener {
            GlobalScope.launch {
                delay(100)
                withContext(Dispatchers.Main) {
                    binding.rvMessages.scrollToPosition(adapter.itemCount - 1)
                }
            }
        }
    }

    private fun recyclerView() {
        adapter = MessagingAdapter()
        binding.rvMessages.adapter = adapter
        binding.rvMessages.layoutManager = LinearLayoutManager(applicationContext)

    }

    override fun onStart() {
        super.onStart()
        //In case there are messages, scroll to bottom when re-opening app

        GlobalScope.launch {
            delay(100)

            withContext(Dispatchers.Main) {
                binding.rvMessages.scrollToPosition(adapter.itemCount - 1)

            }
        }
    }


    private fun sendMessage() {
        val message = binding.etMessage.text.toString()
        val timeStamp = Time.timeStamp()

        if (message.isNotEmpty()) {
            //Adds it to our local list
            messagesList.add(Message(message, SEND_ID, timeStamp))
            binding.etMessage.setText("")

            adapter.insertMessage(Message(message, SEND_ID, timeStamp))
            binding.rvMessages.scrollToPosition(adapter.itemCount - 1)

            botResponse(message)
        }
    }



    private fun botResponse(message: String) {

        val timeStamp = Time.timeStamp()

        GlobalScope.launch {
            //Fake response delay
            delay(1000)

            withContext(Dispatchers.Main) {
                //Gets the response
                val response = BotResponses.basicResponses(message)

                //Adds it to our local list
                messagesList.add(Message(response, RECIEVE_ID, timeStamp))

                //Inserts our message into the adapter
                adapter.insertMessage(Message(response, RECIEVE_ID, timeStamp))

                //Scrolls us to the position of the latest message
                binding.rvMessages.scrollToPosition(adapter.itemCount - 1)

                //Starts Google
                when (response) {
                    OPEN_GOOGLE -> {
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://www.google.com/")
                        startActivity(site)
                    }
                    OPEN_SEARCH -> {
                        val site = Intent(Intent.ACTION_VIEW)
                        val searchTerm: String? = message.substringAfterLast("search")
                        site.data = Uri.parse("https://www.google.com/search?&q=$searchTerm")
                        startActivity(site)
                    }

                    MAP -> {
                        val name: String? = message.substringAfterLast("map")
                        val intent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("google.navigation:q=an+$name"));
                          //  Uri.parse("geo:0,0?q=37.423156,-122.084917 (" + name.toString() + ")"))
                        startActivity(intent)

                    }

                }
            }
        }
    }

    private fun customBotMessage(message: String) {

        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main) {
                val timeStamp = Time.timeStamp()
                messagesList.add(Message(message, RECIEVE_ID, timeStamp))
                adapter.insertMessage(Message(message, RECIEVE_ID, timeStamp))
                binding.rvMessages.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }




}
