package com.abdulmateen.innowave.ui.search

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.abdulmateen.innowave.R
import com.abdulmateen.innowave.data.db.entities.User
import com.abdulmateen.innowave.databinding.ActivitySearchBinding
import com.abdulmateen.innowave.ui.home.HomeActivity
import com.abdulmateen.innowave.util.hide
import com.abdulmateen.innowave.util.show
import com.abdulmateen.innowave.util.toast
import kotlinx.android.synthetic.main.activity_search.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class SearchActivity : AppCompatActivity(), SearchListener, KodeinAware {

    override val kodein by kodein()
    private val factory : SearchViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivitySearchBinding = DataBindingUtil.setContentView(this, R.layout.activity_search)
        val viewModel = ViewModelProviders.of(this, factory).get(SearchViewModel :: class.java)

        binding.viewmodel = viewModel

        viewModel.searchListener = this

    }
    override fun onStarted() {
        toast("Login Started")
        progress_bar.show()
    }

    override fun onSuccess(user: User) {
        progress_bar.hide()
        toast("${user.url}")

        Intent(this, HomeActivity::class.java).also {
            this.startActivity(it)
        }
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
//        toast(message)
    }
}

