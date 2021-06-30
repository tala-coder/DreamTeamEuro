package pmf.unsa.dreamteameuro.list.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface SofaApi {
    @Headers(
        "x-rapidapi-key: 9f56abd52bmsh5d06c3a0587ea7cp1297b7jsnee15583cbce3",
        "x-rapidapi-host: sofascore.p.rapidapi.com"
    )
    @GET("/teams/get-squad?teamId=4717")
    suspend fun getPlayers(): Response<PlayersList>
}