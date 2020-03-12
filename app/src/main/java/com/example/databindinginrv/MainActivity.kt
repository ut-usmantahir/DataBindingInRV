package com.example.databindinginrv

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.databindinginrv.databinding.ActivityMainBinding
//import com.example.databindinginrv.databinding.ActivityMainBinding
import com.example.databindinginrv.model.Movie
import com.example.databindinginrv.network.MoviesApi
import com.example.databindinginrv.repository.MoviesRepository
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MyMovieAdapter
   // lateinit var binding: ActivityMainBinding

    lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
 //       setContentView(R.layout.activity_main)

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val repository = MoviesRepository(MoviesApi())


//        layoutManager = LinearLayoutManager(this)


        GlobalScope.launch(Dispatchers.Main) {
            val movies = repository.getMovies()
            // Toast.makeText(this@MainActivity,movies.toString(),Toast.LENGTH_LONG).show()
            Log.d("Usman",movies.toString())

            layoutManager = LinearLayoutManager(this@MainActivity)
            mainBinding.recyclerMovieList.layoutManager = layoutManager
            mainBinding.recyclerMovieList.setHasFixedSize(true)

            adapter = MyMovieAdapter(baseContext, movies as MutableList<Movie>)

//            adapter.notifyDataSetChanged()
            mainBinding.recyclerMovieList.adapter = adapter

        }


    }
}






























