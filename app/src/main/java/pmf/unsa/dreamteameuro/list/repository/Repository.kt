package pmf.unsa.dreamteameuro.list.repository


import pmf.unsa.dreamteameuro.list.network.PlayersListX
import pmf.unsa.dreamteameuro.list.network.RetrofitInstance
import retrofit2.Response

class Repository {
    suspend fun getPlayers(teamId: Int): Response<PlayersListX> {
        return RetrofitInstance.api.getPlayers(teamId)
    }
}