package com.abdulmateen.innowave.ui.home.profile

import androidx.lifecycle.ViewModel;
import com.abdulmateen.innowave.data.repositories.UserRepository

class ProfileViewModel(
    repository: UserRepository
) : ViewModel() {

    val user = repository.getUser()

}
