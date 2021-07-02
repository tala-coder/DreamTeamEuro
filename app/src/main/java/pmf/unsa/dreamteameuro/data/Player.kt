package pmf.unsa.dreamteameuro.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player_table")

data class Player(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val position: String,
    val age: Int
)
