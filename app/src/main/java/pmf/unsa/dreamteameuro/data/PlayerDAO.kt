package pmf.unsa.dreamteameuro.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PlayerDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPlayer(player: Player)

    @Query("SELECT * FROM player_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Player>>
}