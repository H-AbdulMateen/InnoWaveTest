package com.abdulmateen.innowave.ui.home.followers

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.abdulmateen.innowave.R
import com.abdulmateen.innowave.data.db.entities.Follower
import com.abdulmateen.innowave.databinding.ItemFollowerBinding
import com.bumptech.glide.Glide
import com.xwray.groupie.databinding.BindableItem

class FollowerItem (
    private val follower: Follower
) : BindableItem<ItemFollowerBinding>(){

    override fun getLayout() = R.layout.item_follower

    override fun bind(viewBinding: ItemFollowerBinding, position: Int) {
        viewBinding.setFollower(follower)
    }

    companion object {
        @JvmStatic
        @BindingAdapter("avatar_url")
        fun loadImage(view: ImageView, url: String) {

            Glide
                .with(view)
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.git_logo)
                .into(view);
//            Picasso.get()
//                .load(avatar_url)
////            .placeholder(R.drawable)
//                .into(view)
        }
    }
}