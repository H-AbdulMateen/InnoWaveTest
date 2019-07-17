package com.abdulmateen.innowave.ui.home.followers

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.abdulmateen.innowave.R
import com.abdulmateen.innowave.data.db.entities.Follower
import com.abdulmateen.innowave.util.Coroutines
import com.abdulmateen.innowave.util.hide
import com.abdulmateen.innowave.util.show
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.activity_search.progress_bar
import kotlinx.android.synthetic.main.fragment_followers.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance
import java.util.Collections.addAll

class FollowersFragment : Fragment(), KodeinAware {

    override val kodein by kodein()

    private val factory: FollowersViewModelFactory by instance()

    private lateinit var viewModel: FollowersViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_followers, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, factory).get(FollowersViewModel::class.java)
        bindUI()
    }


    private fun bindUI() = Coroutines.main {
        progress_bar.show()
        viewModel.followers.await().observe(this, Observer {
            progress_bar.hide()
            initRecyclerView(it.toFollowerItem())
        })
    }

    private fun initRecyclerView(followerItem: List<FollowerItem>) {

        val mAdapter = GroupAdapter<ViewHolder>().apply {
            addAll(followerItem)
        }

        recyclerview.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = mAdapter
        }

    }


    private fun List<Follower>.toFollowerItem() : List<FollowerItem>{
        return this.map {
            FollowerItem(it)
        }
    }

}
