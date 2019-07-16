package com.abdulmateen.innowave.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.abdulmateen.innowave.data.repositories.UserRepository
import androidx.databinding.ObservableField



@Suppress("UNCHECKED_CAST")
class SearchViewModelFactory (
    private val repository: UserRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SearchViewModel(repository) as T
    }
}