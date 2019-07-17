package com.abdulmateen.innowave.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.abdulmateen.innowave.data.db.entities.Follower

@Dao
interface FollowerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllFollowers(followers : List<Follower>)

    @Query("SELECT * FROM Follower")
    fun getFollowers() : LiveData<List<Follower>>

    @Query("DELETE FROM Follower")
    fun deleteExistedFollowers()

}