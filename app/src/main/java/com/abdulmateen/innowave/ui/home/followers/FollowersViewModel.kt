package com.abdulmateen.innowave.ui.home.followers

import androidx.lifecycle.ViewModel
import com.abdulmateen.innowave.data.db.entities.User
import com.abdulmateen.innowave.data.repositories.FollowerRepository
import com.abdulmateen.innowave.data.repositories.UserRepository
import com.abdulmateen.innowave.util.lazyDeferred

class FollowersViewModel (
    repository: FollowerRepository
) : ViewModel() {
        val followers by lazyDeferred {

            repository.getFollowers()
        }
}