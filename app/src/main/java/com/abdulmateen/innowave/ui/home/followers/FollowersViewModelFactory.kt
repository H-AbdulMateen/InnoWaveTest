package com.abdulmateen.innowave.ui.home.followers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.abdulmateen.innowave.data.repositories.FollowerRepository

@Suppress("UNCHECKED_CAST")
class FollowersViewModelFactory (private val repository: FollowerRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FollowersViewModel(repository) as T
    }
}