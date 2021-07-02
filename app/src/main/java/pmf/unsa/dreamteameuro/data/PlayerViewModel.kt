package pmf.unsa.dreamteameuro.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlayerViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Player>>
    private val repository: PlayerRepository

    init {
        val playerDAO = PlayerDatabase.getDatabase(application).playerDao()
        repository = PlayerRepository(playerDAO)
        readAllData = repository.readAllData
    }

    fun addPlayer(player: Player){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addPlayer(player)
        }
    }

    fun deletaAllPlayers(player: Player){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addPlayer(player)
        }
    }

    fun deletePlayer(player: Player){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletePlayer(player)
        }
    }

    fun deleteAllPlayers(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllPlayers()
        }
    }

}