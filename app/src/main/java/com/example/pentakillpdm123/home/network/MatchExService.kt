package com.example.pentakillpdm123.home.network

import com.example.pentakillpdm123.home.model.MatchExModel
import retrofit2.http.GET

interface MatchExService {



    @GET("partidosand/")
    suspend fun getMatchEx(): List<MatchExModel>
}