package com.abdulmateen.innowave.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.abdulmateen.innowave.data.db.AppDatabase
import com.abdulmateen.innowave.data.db.entities.Follower
import com.abdulmateen.innowave.data.db.entities.User
import com.abdulmateen.innowave.data.network.GitApi
import com.abdulmateen.innowave.data.preferences.PreferenceProvider
import com.abdulmateen.innowave.util.Coroutines
import com.google.gson.Gson
import com.google.gson.JsonArray
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class FollowerRepository (private val api: GitApi,
                          private val db: AppDatabase,
                          private val pref: PreferenceProvider

)
{


    private val followers = MutableLiveData<List<Follower>>()

    init {
        followers.observeForever {
            saveFollowers(it)
        }
    }

    suspend fun getFollowers(): LiveData<List<Follower>> {
        return withContext(Dispatchers.IO){
            fetchFollowers()
            db.getFollowerDao().getFollowers()
        }
    }

     suspend fun fetchFollowers() {
        var username: String? = pref.getPrfUser()
         /////////////////////////////////////////
         val response = api.getFollowers(username!!)
         if (response.isSuccessful) {
             db.getFollowerDao().deleteExistedFollowers()
             val gson = Gson()
             val response = gson.fromJson(response.body() , Array<Follower>::class.java).toList()
             followers.postValue(response)
    }
     }



    private fun saveFollowers(followers: List<Follower>) {
        Coroutines.io {
            db.getFollowerDao().saveAllFollowers(followers)
        }
    }

}