package com.abdulmateen.innowave.data.repositories

import com.abdulmateen.innowave.data.db.AppDatabase
import com.abdulmateen.innowave.data.db.entities.User
import com.abdulmateen.innowave.data.network.GitApi
import com.google.gson.JsonObject
import retrofit2.Response

class UserRepository ( private val api: GitApi,
                       private val db: AppDatabase
)  {

    suspend fun searchUser(username: String): Response<JsonObject> {
        return api.searchUser(username)

    }

    suspend fun saveUser(user: User) = db.getUserDao().insert(user)

    fun getUser() = db.getUserDao().getUser()

}