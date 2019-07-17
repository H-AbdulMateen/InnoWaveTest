package com.abdulmateen.innowave.ui.home.profile

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import com.abdulmateen.innowave.data.repositories.UserRepository
import com.bumptech.glide.Glide


class ProfileViewModel(
    repository: UserRepository
) : ViewModel() {
    val user = repository.getUser()


    companion object {
        @JvmStatic
        @BindingAdapter("avatar_url")
        fun loadImage(view: ImageView, url: String) {

            Glide
                .with(view)
                .load(url)
                .centerCrop()
                .placeholder(com.abdulmateen.innowave.R.drawable.git_logo)
                .into(view);
//            Picasso.get()
//                .load(avatar_url)
////            .placeholder(R.drawable)
//                .into(view)
        }
    }

}
