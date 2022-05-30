package com.example.beberagua.data

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {

    val lerTodosOsDados: LiveData<List<User>> = userDao.lerTodosOsDados()

    fun addUser(user: User){
        userDao.addUser(user)
    }
}