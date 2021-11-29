package org.wit.chatapplication.models


import android.content.Context
import android.net.Uri
import com.google.gson.*
import com.google.gson.reflect.TypeToken
import timber.log.Timber
import java.lang.reflect.Type

import java.util.*

const val JSON_FILE = "userDetails.json"
val gsonBuilder: Gson = GsonBuilder().setPrettyPrinting()
    .registerTypeAdapter(Uri::class.java, UriParser())
    .create()
val listType: Type = object : TypeToken<ArrayList<UserModel>>() {}.type

fun generateRandomId(): Long {
    return Random().nextLong()
}

class PlacemarkJSONStore(private val context: Context) : UserStore {

    var users = mutableListOf<UserModel>()

    init {
      //  if (exists(context, JSON_FILE)) {
       //     deserialize()
      //  }
    }

    override fun findAll(): MutableList<UserModel> {
        logAll()
        return users
    }

    override fun create(user: UserModel) {
     //   placemark.id = generateRandomId()
        users.add(user)
        serialize()
    }


    override fun update(user: UserModel) {
        // todo
    }

    private fun serialize() {
        val jsonString = gsonBuilder.toJson(users, listType)
     //   write(context, JSON_FILE, jsonString)
    }

    private fun deserialize() {
    //    val jsonString = read(context, JSON_FILE)
    //    users = gsonBuilder.fromJson(jsonString, listType)
    }

    private fun logAll() {
        users.forEach { Timber.i("$it") }
    }
}

class UriParser : JsonDeserializer<Uri>,JsonSerializer<Uri> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Uri {
        return Uri.parse(json?.asString)
    }

    override fun serialize(
        src: Uri?,
        typeOfSrc: Type?,
        context: JsonSerializationContext?
    ): JsonElement {
        return JsonPrimitive(src.toString())
    }
}