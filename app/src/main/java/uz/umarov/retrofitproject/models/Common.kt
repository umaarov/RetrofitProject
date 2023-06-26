package uz.umarov.retrofitproject.models

import uz.umarov.retrofitproject.service.RetrofitService

object Common {

    var BASE_URL = "https://www.simplefiedcoding.net/demos/"

    val retrofitService: RetrofitService
        get() = RetrofitClient.getRetrofit(BASE_URL).create(RetrofitService::class.java)

}