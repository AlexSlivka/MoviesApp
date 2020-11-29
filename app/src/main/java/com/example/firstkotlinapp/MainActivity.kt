package com.example.firstkotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), FragmentMoviesList.TransactionsFragmentClicks, FragmentMoviesDetails.MovieDetailsFragmentClicks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.main_container, FragmentMoviesList())
                    .commit()
        }
    }

    override fun goToMovieDetailsFragment() {
        supportFragmentManager.beginTransaction()
                .add(R.id.main_container, FragmentMoviesDetails())
                .commit()
    }

    override fun backToMoviesListFragment() {
        supportFragmentManager.beginTransaction()
                .add(R.id.main_container, FragmentMoviesList())
                .commit()
    }
}

