package com.example.pentakillpdm123

import com.example.pentakillpdm123.home.network.LeagueService
import com.example.pentakillpdm123.login.network.LoginService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://tasty-pig-flip-flops.cyclic.app/"
    private const val gist_URL = "https://gist.githubusercontent.com/"

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val loginService: LoginService by lazy {
        retrofit.create(LoginService::class.java)
    }
    val leagueService: LeagueService by lazy {
        retrofit.create(LeagueService::class.java)
    }
}