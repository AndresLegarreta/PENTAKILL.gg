package com.example.pentakillpdm123.home.network

import com.example.pentakillpdm123.RetrofitInstance

import com.example.pentakillpdm123.home.model.MatchExModel

class MatchExRepository {
    private val matchExService = RetrofitInstance.matchExService

    suspend fun getMatchEx(): List<MatchExModel> {

        return matchExService.getMatchEx()
    }
}