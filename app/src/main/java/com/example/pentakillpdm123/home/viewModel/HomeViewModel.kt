package com.example.pentakillpdm123.home.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pentakillpdm123.home.model.LeagueModel
import com.example.pentakillpdm123.home.model.MatchExModel
import com.example.pentakillpdm123.home.model.MatchModel
import com.example.pentakillpdm123.home.model.NewsModel
import com.example.pentakillpdm123.home.network.LeagueRepository
import com.example.pentakillpdm123.home.network.MatchExRepository
import com.example.pentakillpdm123.home.network.MatchRepository
import com.example.pentakillpdm123.home.network.NewsRepository
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    private val repository = LeagueRepository()
    private val repository1 = MatchRepository()
    private val repository2 = MatchExRepository()
    private val repository3 = NewsRepository()

    private val _leagueCards = MutableLiveData<List<LeagueModel>>()
    val leagueCards: LiveData<List<LeagueModel>> = _leagueCards
    private val _matchCards = MutableLiveData<List<MatchModel>>()
    val matchCards: LiveData<List<MatchModel>> = _matchCards
    private val _matchExCards = MutableLiveData<List<MatchExModel>>()
    val matchExCards: LiveData<List<MatchExModel>> = _matchExCards
    private val _newsCards = MutableLiveData<List<NewsModel>>()
    val newsCards: LiveData<List<NewsModel>> = _newsCards

    fun fetchLeagueCards() {
        viewModelScope.launch {
            try {
                val cards = repository.getLeague()
                _leagueCards.value = cards
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
    fun fetchMatchExCards() {
        viewModelScope.launch {
            try {
                val matchesEx = repository2.getMatchEx()
                _matchExCards.value = matchesEx
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
    fun fetchMatchCards() {
        viewModelScope.launch {
            try {

                val matches = repository1.getMatch()
                _matchCards.value = matches
                // Ahora, matches contendrá solo los primeros 3 partidos
                // Haz algo con la lista de partidos aquí
            } catch (e: Exception) {
                // Maneja los errores aquí
            }
        }
    }
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
