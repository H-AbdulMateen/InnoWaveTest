package com.abdulmateen.innowave.ui.home.followers

import com.abdulmateen.innowave.R
import com.abdulmateen.innowave.data.db.entities.Follower
import com.abdulmateen.innowave.databinding.ItemFollowerBinding
import com.xwray.groupie.databinding.BindableItem

class FollowerItem (
    private val follower: Follower
) : BindableItem<ItemFollowerBinding>(){

    override fun getLayout() = R.layout.item_follower

    override fun bind(viewBinding: ItemFollowerBinding, position: Int) {
        viewBinding.setFollower(follower)
    }
}