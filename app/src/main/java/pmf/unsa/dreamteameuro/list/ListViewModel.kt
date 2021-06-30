package pmf.unsa.dreamteameuro.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pmf.unsa.dreamteameuro.list.network.PlayersList
import pmf.unsa.dreamteameuro.list.repository.Repository
import retrofit2.Response

class ListViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Response<PlayersList>> = MutableLiveData()

    fun getPlayers() {
        viewModelScope.launch {
            val response: Response<PlayersList> = repository.getPlayers()
            myResponse.value = response
        }
    }
}