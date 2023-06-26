package uz.umarov.retrofitproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.umarov.retrofitproject.adapters.MovieAdapter
import uz.umarov.retrofitproject.databinding.ActivityMainBinding
import uz.umarov.retrofitproject.models.Common
import uz.umarov.retrofitproject.models.Movie
import uz.umarov.retrofitproject.service.RetrofitService


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var retrofitService: RetrofitService
    private val TAG = "MainActivity"
    lateinit var movieAdapter: MovieAdapter
    lateinit var list: ArrayList<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView((ActivityMainBinding.inflate(layoutInflater)).root)

        list = ArrayList()

        movieAdapter = MovieAdapter(list)
        retrofitService = Common.retrofitService

        retrofitService.getMovie().enqueue(object : Callback<List<Movie>> {
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                if (response.isSuccessful && response.body() != null) {
//                    val list = response.body()
//
//                    list?.forEach {
//                        Log.d(TAG, "onResponse: $it")
//                    }
                    list.addAll(response.body()!!)
                    movieAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {

            }

        })

        binding.rv.adapter = movieAdapter 

    }
}