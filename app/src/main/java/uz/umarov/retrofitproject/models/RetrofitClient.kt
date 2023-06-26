package uz.umarov.retrofitproject.models

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.umarov.retrofitproject.models.Common.BASE_URL

object RetrofitClient {

    fun getRetrofit(baseUrl: String): Retrofit {


        val build = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()

        return build
    }

}