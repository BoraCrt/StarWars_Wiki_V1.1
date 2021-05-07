package tr.edu.medipol.starwars_koin.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import tr.edu.medipol.starwars_koin.network.SwapiService
import tr.edu.medipol.starwars_koin.network.networkCall

class MainViewModel(private val swapiService: SwapiService) : ViewModel() {
   fun getPeople()= liveData  { emit (networkCall { swapiService.getPeople(1) }) }


}