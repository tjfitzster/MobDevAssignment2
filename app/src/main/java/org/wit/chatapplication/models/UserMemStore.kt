package org.wit.chatapplication.models

import timber.log.Timber.i

var lastId = 0L

internal fun getId(): Long {
    return lastId++
}

class UserMemStore : UserStore {

    val placemarks = ArrayList<UserModel>()

    override fun findAll(): List<UserModel> {
        return placemarks
    }

    override fun create(placemark: UserModel) {
     //   placemark.id = getId()
        placemarks.add(placemark)
        logAll()
    }

    override fun update(placemark: UserModel) {
      //  val foundUser: UserModel? = placemarks.find { p -> p.id == placemark.id }
     //   if (foundUser != null) {
          //  foundUser.title = placemark.title
          //  foundUser.description = placemark.description
    //        foundUser.image = placemark.image
        //    foundPlacemark.lat = placemark.latw
           // foundPlacemark.lng = placemark.lng
        //    foundPlacemark.zoom = placemark.zoom
      //      logAll()
     //   }
    }

    private fun logAll() {
        placemarks.forEach { i("$it") }
    }
}