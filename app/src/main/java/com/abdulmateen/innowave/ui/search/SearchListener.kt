package com.abdulmateen.innowave.ui.search

import com.abdulmateen.innowave.data.db.entities.User

interface SearchListener {
    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message: String)
}