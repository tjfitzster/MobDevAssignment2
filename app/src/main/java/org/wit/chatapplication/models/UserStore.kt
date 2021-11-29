package org.wit.chatapplication.models

interface UserStore {
    fun findAll(): List<UserModel>
    fun create(placemark: UserModel)
    fun update(placemark: UserModel)
}