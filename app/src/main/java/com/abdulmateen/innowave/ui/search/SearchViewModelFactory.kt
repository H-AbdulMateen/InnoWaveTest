package com.abdulmateen.innowave.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.abdulmateen.innowave.data.repositories.UserRepository
import androidx.databinding.ObservableField
import com.abdulmateen.innowave.data.preferences.PreferenceProvider


@Suppress("UNCHECKED_CAST")
class SearchViewModelFactory (
    private val repository: UserRepository,
    private val pref:PreferenceProvider
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SearchViewModel(repository, pref) as T
    }
}