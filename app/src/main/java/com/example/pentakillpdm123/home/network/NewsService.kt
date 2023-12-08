package com.example.pentakillpdm123.home.network

import com.example.pentakillpdm123.home.model.NewsModel
import retrofit2.http.GET

interface NewsService {
    @GET("noticias/")
    suspend fun getNew(): List<NewsModel>
}