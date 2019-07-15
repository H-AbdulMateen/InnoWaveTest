package com.abdulmateen.innowave.ui.search

import android.view.View
import androidx.lifecycle.ViewModel
import com.abdulmateen.innowave.data.db.entities.User
import com.abdulmateen.innowave.data.repositories.UserRepository
import com.abdulmateen.innowave.util.ApiException
import com.abdulmateen.innowave.util.Coroutines
import com.abdulmateen.innowave.util.NoInternetException
import com.google.gson.Gson

class SearchViewModel (
    private val repository: UserRepository
): ViewModel(){
    var searchListener: SearchListener? = null
    var username: String? = null

    fun onSearchButtonClick(view: View) {
        searchListener?.onStarted()
        if (username.isNullOrEmpty()) {
            searchListener?.onFailure("Invalid email or password")
            //
        return
    }
        Coroutines.main {
            try {
                val response = repository.searchUser(username!!)
                if (response.isSuccessful) {
                    val gson = Gson()
                    var user = gson?.fromJson(response.body(), User::class.java)
                    user?.let {
                        searchListener?.onSuccess(user)
                        repository.saveUser(user)

                        return@main
                    }
                }
                searchListener?.onFailure(response.message())
            } catch (e: ApiException) {
                searchListener?.onFailure(e.message!!)
            } catch (e: NoInternetException) {
                searchListener?.onFailure(e.message!!)
            }

        }
    }
}