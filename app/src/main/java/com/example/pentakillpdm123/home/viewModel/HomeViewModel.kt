package com.example.pentakillpdm123.home.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pentakillpdm123.home.model.LeagueModel
import com.example.pentakillpdm123.home.model.MatchModel
import com.example.pentakillpdm123.home.network.LeagueRepository
import com.example.pentakillpdm123.home.network.MatchRepository
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    private val repository = LeagueRepository()
    private val repository1 = MatchRepository()

    private val _leagueCards = MutableLiveData<List<LeagueModel>>()
    val leagueCards: LiveData<List<LeagueModel>> = _leagueCards
    private val _matchCards = MutableLiveData<List<MatchModel>>()
    val matchCards: LiveData<List<MatchModel>> = _matchCards

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
}
