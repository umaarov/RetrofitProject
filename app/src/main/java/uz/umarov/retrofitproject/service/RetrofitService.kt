package uz.umarov.retrofitproject.service

import retrofit2.Call
import retrofit2.http.GET
import uz.umarov.retrofitproject.models.Movie

interface RetrofitService {

    @GET("marvel")
    fun getMovie(): Call<List<Movie>>

}