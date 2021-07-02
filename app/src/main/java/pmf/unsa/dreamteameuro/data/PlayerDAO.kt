package pmf.unsa.dreamteameuro.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PlayerDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPlayer(player: Player)

    @Query("SELECT * FROM player_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Player>>

    @Delete
    suspend fun deletePlayer(player: Player)

    @Query("DELETE FROM player_table")
    suspend fun deleteAllPlayers()
}