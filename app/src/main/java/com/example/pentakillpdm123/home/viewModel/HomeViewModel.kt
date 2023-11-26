package com.example.pentakillpdm123.home.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pentakillpdm123.home.model.LeagueModel
import com.example.pentakillpdm123.home.network.LeagueRepository
import kotlinx.coroutines.launch

class HomeViewModel: ViewModel() {
    private val repository = LeagueRepository()

    private val _leagueCards = MutableLiveData<List<LeagueModel>>()
    val leagueCards: LiveData<List<LeagueModel>> = _leagueCards

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
}
