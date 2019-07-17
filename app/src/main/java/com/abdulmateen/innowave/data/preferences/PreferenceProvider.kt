package com.abdulmateen.innowave.data.preferences

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

private const val KEY_USERNAME = "key_username"

class PreferenceProvider(
    context: Context
) {

    private val appContext = context.applicationContext

    private val preference: SharedPreferences
        get() = PreferenceManager.getDefaultSharedPreferences(appContext)


    fun savePrefUser(username: String) {
        preference.edit().putString(
            KEY_USERNAME,
            username
        ).apply()
    }

    fun getPrfUser(): String? {
        return preference.getString(KEY_USERNAME, null)
    }

}