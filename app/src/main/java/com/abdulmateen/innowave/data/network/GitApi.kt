package com.abdulmateen.innowave.data.network

import com.google.gson.JsonObject
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface GitApi {
    @GET("users/{username}")
    suspend fun searchUser(
        @Path("username") username: String

    ): Response<JsonObject>

    companion object {
        operator fun invoke(networkConnectionInterceptor: NetworkConnectionInterceptor
        ) : GitApi{

            val okkHttpclient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okkHttpclient)
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(GitApi::class.java)
        }
    }
}