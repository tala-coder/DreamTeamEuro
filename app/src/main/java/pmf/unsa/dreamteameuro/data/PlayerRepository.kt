package pmf.unsa.dreamteameuro.data

import androidx.lifecycle.LiveData


class PlayerRepository(private val playerDAO: PlayerDAO) {

    val readAllData: LiveData<List<Player>> = playerDAO.readAllData()

    suspend fun addPlayer(player: Player){
        playerDAO.addPlayer(player)
    }


    suspend fun deleteAllPlayers(){
        playerDAO.deleteAllPlayers()
    }
}