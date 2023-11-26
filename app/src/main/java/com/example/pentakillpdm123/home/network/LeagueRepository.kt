package com.example.pentakillpdm123.home.network

import com.example.pentakillpdm123.RetrofitInstance

import com.example.pentakillpdm123.home.model.LeagueModel


class LeagueRepository {
    private val leagueService = RetrofitInstance.leagueService

    suspend fun getLeague(): List<LeagueModel> {

        return leagueService.getLeagues()
    }
}