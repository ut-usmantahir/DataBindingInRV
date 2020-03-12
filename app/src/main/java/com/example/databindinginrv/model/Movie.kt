package com.example.databindinginrv.model

import android.media.Image
import org.intellij.lang.annotations.Language

/*
data class Movie (
    val id : Int,
    val image: String,
    val is_new : Int,
    val language : String,
    val like_percent : Int,
    val rating : String,
    val title : String,
    val type : String,
    val vote_count : Int
)
*/

data class Movie (
    var name:String,
    var realname:String,
    var team:String,
    var firstappearance:String,
    var createdby:String,
    var publisher:String,
    var imageurl:String,
    var bio:String
)

