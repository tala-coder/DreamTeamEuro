package pmf.unsa.dreamteameuro.list.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SofaApi {
    @Headers(
        "x-rapidapi-key: 9f56abd52bmsh5d06c3a0587ea7cp1297b7jsnee15583cbce3",
        "x-rapidapi-host: sofascore.p.rapidapi.com"
    )

  @GET("/teams/get-squad")
    suspend fun getPlayers(
            @Query("teamId")teamId: Int
    ): Response<PlayersListX>
}