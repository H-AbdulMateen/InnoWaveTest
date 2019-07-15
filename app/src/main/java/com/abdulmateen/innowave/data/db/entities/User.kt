package com.abdulmateen.innowave.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

const val CURRENT_USER_ID = 0

@Entity
data class User (
    var id: Int? ,
    var name: String?,
    var email: String?,
    var login: String?,
    var avatar_url: String?,
    var gravatar_id: String?,
    var url: String?,
    var html_url: String?,
    var company: String?,
    var followers_url: String?,
    var created_at: String?,
    var updated_at: String?
){
    @PrimaryKey(autoGenerate = false)
    var uid: Int = CURRENT_USER_ID
}