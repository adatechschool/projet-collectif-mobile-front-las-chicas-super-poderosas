package com.example.projet_collectif_mobile.ui.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projet_collectif_mobile.models.ClassJson
import com.example.projet_collectif_mobile.models.SurfSpot

import com.example.projet_collectif_mobile.network.SpotsApi
import kotlinx.coroutines.launch

class SpotsViewModel : ViewModel() {/** The mutable State that stores the status of the most recent request */
//var spotsUiState: String by mutableStateOf("")
//private set

// Utilisation de LiveData pour permettre l'observation depuis l'Activity
private val _spotsUiState = MutableLiveData<List<SurfSpot>>()
    val spotsUiState: LiveData<List<SurfSpot>> = _spotsUiState
    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getSpotsList()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [MutableList].
     */
    fun getSpotsList() {
        viewModelScope.launch {
            //val listResult = SpotsApi.retrofitService.getSpots()
            //spotsUiState = listResult
            //}
            ////marsUiState = "Set the Mars API status response here!"
            println("coucou")
            try {
                println("kiki")
                val listResult = SpotsApi.retrofitService.getSpots()
                _spotsUiState.value = listResult
                println("Bob")
                //println(listResult)
            } catch (e: Exception) {
                println("caca")
                println(e)
                // Gérer les erreurs ici (ex : afficher un message d'erreur à l'utilisateur)
                _spotsUiState.value = emptyList()  // Pour éviter les erreurs si l'appel échoue
            }
        }
    }}