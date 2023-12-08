package com.example.pentakillpdm123.home.network

import com.example.pentakillpdm123.RetrofitInstance
import com.example.pentakillpdm123.home.model.MatchModel
import com.example.pentakillpdm123.home.model.NewsModel

class NewsRepository {
    private val newsService = RetrofitInstance.newsService

    suspend fun getNew(): List<NewsModel> {

        return newsService.getNew()
    }
}