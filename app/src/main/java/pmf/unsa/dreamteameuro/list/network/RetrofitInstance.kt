package pmf.unsa.dreamteameuro.list.network

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

object RetrofitInstance {
    private const val BASE_URL = "https://sofascore.p.rapidapi.com"


    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: SofaApi by lazy {
        retrofit.create(SofaApi::class.java)
    }
}

