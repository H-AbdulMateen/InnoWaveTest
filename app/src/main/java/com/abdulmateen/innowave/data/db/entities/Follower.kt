package com.abdulmateen.innowave.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Follower(
    @PrimaryKey(autoGenerate = false)
    val id: Int? ,
    val login: String?,
    val avatar_url: String?,
    val url: String?,
    val gravatar_id: String?
)