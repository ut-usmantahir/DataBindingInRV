package com.example.databindinginrv

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
//import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.databindinginrv.model.Movie
import com.example.databindinginrv.R
import com.example.databindinginrv.databinding.LayoutMovieItemBinding
import kotlinx.android.synthetic.main.layout_movie_item.view.*


class MyMovieAdapter(private val context: Context, private val movieList: MutableList<Movie>): RecyclerView.Adapter<MyMovieAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            : MyViewHolder {
        return MyViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.layout_movie_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        Log.v("UsmanonBindViewHolder",
            movieList[position].name +" TEAM "+
                    movieList[position].team +" CREATEDBY "+
                    movieList[position].createdby)

        Glide.with(context)
            .load(movieList[position].imageurl)
            .into(holder.binding.imageMovie);
       // Picasso.get().load(movieList[position].imageurl).into(holder.image)
        holder.binding.movie = movieList[position]
//        holder.binding.txtTeam.text = movieList[position].team
//        holder.binding.txtCreatedby.text = movieList[position].createdby

    }

    /*class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var image: ImageView
        var txt_name: TextView
        var txt_team: TextView
        var createdby: TextView

        init {
            image = itemView.image_movie
            txt_name = itemView.txt_name
            txt_team = itemView.txt_team
            createdby = itemView.txt_createdby

        }
    }*/

     inner class MyViewHolder(
         val binding: LayoutMovieItemBinding
     ) : RecyclerView.ViewHolder(binding.root)
}



