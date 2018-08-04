package inc.ahmedmourad.cinematics.mvvm.model.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors

object ApiClient {

    private const val BASE_URL = "http://api.themoviedb.org/3/"

    @Volatile
    private var INSTANCE: Retrofit? = null

    fun getInstance(): Retrofit = INSTANCE ?: synchronized(this) {
        INSTANCE ?: buildClient().also { INSTANCE = it }
    }

    private fun buildClient() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .callbackExecutor(Executors.newSingleThreadExecutor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

}