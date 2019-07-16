package com.abdulmateen.innowave.ui.home.profile

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel;
import com.abdulmateen.innowave.data.db.entities.User
import com.abdulmateen.innowave.data.repositories.UserRepository
import android.R
import com.squareup.picasso.Picasso


class ProfileViewModel(
    repository: UserRepository
) : ViewModel() {
    val user = repository.getUser()


    companion object {
        @JvmStatic
        @BindingAdapter("avatar_url")
        fun loadImage(view: ImageView, avatar_url: String) {

            Picasso.get()
                .load(avatar_url)
//            .placeholder(R.drawable)
                .into(view)
        }
    }

}
