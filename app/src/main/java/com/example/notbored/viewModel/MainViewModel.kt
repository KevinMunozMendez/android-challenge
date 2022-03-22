package com.example.notbored.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notbored.common.entities.ActivityEntity
import com.example.notbored.model.MainInteractor
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val interactor: MainInteractor = MainInteractor()

    private val participants = MutableLiveData<String>()
    private val categories = MutableLiveData<String>()
    private val suggestion = MutableLiveData<ActivityEntity>()

    val getParticipants: LiveData<String> = participants
    val getCategories: LiveData<String> = categories
    val getSuggestion: LiveData<ActivityEntity> = suggestion

    fun setParticipants(numberParticipants: String) {
        Log.i("participants", numberParticipants)
        participants.value = numberParticipants
    }

    fun setCategories(category: String) {
        Log.i("category", category)
        categories.value = category
    }

    fun setSuggestion() {
        val endpoint = "activity?type=${categories.value}&participants=${participants.value}"
        Log.i("jajajaj xd", endpoint)
        viewModelScope.launch {
            suggestion.value = interactor.getContacts(endpoint)
        }
    }


}