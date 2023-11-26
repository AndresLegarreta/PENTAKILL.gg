package com.example.pentakillpdm123.home.network

import com.example.pentakillpdm123.home.model.LeagueModel
import retrofit2.http.GET



interface LeagueService {
    @GET("ligas/")
    suspend fun getLeagues(): List<LeagueModel>
}