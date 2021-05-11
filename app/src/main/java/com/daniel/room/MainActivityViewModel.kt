package com.daniel.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.daniel.room.db.RoomAppDb
import com.daniel.room.db.UserEntity

class MainActivityViewModel(app: Application): AndroidViewModel(app) {

    var allUsers : MutableLiveData<List<UserEntity>> = MutableLiveData()


    fun getAllUsersObservers() : MutableLiveData<List<UserEntity>>{
        return allUsers
    }

    fun getAllUsers(){
       val userDao =  RoomAppDb.getAppDatabase((getApplication())).UserDao()
        val list = userDao.getAllUserInfo()

        allUsers.postValue(list)
    }

    fun insertUserInfo(entity: UserEntity){
        val userDao = RoomAppDb.getAppDatabase(getApplication()).UserDao()
        userDao.insertUser(entity)
        getAllUsers()
    }

    fun deleteUserInfo(entity: UserEntity){
        val userDao = RoomAppDb.getAppDatabase(getApplication()).UserDao()
        userDao.deleteUser(entity)
        getAllUsers()
    }

    fun updateUserInfo(entity: UserEntity){
        val userDao = RoomAppDb.getAppDatabase(getApplication()).UserDao()
        userDao.updateUser(entity)
        getAllUsers()
    }


}