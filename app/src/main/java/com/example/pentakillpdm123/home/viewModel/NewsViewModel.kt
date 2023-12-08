package com.example.pentakillpdm123.home.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pentakillpdm123.home.model.NewsModel
import com.example.pentakillpdm123.home.network.NewsRepository
import kotlinx.coroutines.launch

class NewsViewModel: ViewModel(){
    private val repository3 = NewsRepository()

    private val _newsCards = MutableLiveData<List<NewsModel>>()
    val newsCards: LiveData<List<NewsModel>> = _newsCards

    fun fetchNews() {
        viewModelScope.launch {
            try {
                val news = repository3.getNew()
                _newsCards.value = news
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}