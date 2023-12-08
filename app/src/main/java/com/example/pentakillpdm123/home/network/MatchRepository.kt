package com.example.pentakillpdm123.home.network

import com.example.pentakillpdm123.RetrofitInstance


import com.example.pentakillpdm123.home.model.MatchModel


class MatchRepository {
    private val matchService = RetrofitInstance.matchService

    suspend fun getMatch(): List<MatchModel> {

        return matchService.getMatches()
    }
}