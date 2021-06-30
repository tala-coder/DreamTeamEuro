package pmf.unsa.dreamteameuro.list.repository

import pmf.unsa.dreamteameuro.list.network.PlayersList
import pmf.unsa.dreamteameuro.list.network.RetrofitInstance
import retrofit2.Response

class Repository {
    suspend fun getPlayers(): Response<PlayersList> {
        return RetrofitInstance.api.getPlayers()
    }
}