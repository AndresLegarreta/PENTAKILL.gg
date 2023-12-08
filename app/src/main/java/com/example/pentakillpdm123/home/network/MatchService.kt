package com.example.pentakillpdm123.home.network


import com.example.pentakillpdm123.home.model.MatchModel
import retrofit2.http.GET
import retrofit2.http.Query

interface MatchService {



    @GET("partidosand/")
    suspend fun getMatches(): List<MatchModel>
}