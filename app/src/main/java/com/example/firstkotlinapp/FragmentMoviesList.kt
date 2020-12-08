package com.example.firstkotlinapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentMoviesList : Fragment() {
    private var recyclerMoviesList: RecyclerView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_movies_list, container, false)
        /* view.findViewById<ImageView>(R.id.poster_avengers_end_game_imageView).setOnClickListener {
            fragmentManager?.beginTransaction()
                    ?.addToBackStack(null)
                    ?.replace(R.id.main_container, FragmentMoviesDetails())
                    ?.commit()
        }*/
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerMoviesList = view.findViewById(R.id.rv_movies_list)
        recyclerMoviesList?.adapter = MoviesListAdapter()
        recyclerMoviesList?.layoutManager = GridLayoutManager(context,2)
    }

    override fun onStart() {
        super.onStart()
        updateData()
    }

    override fun onDetach() {
        recyclerMoviesList = null
        super.onDetach()
    }

    private fun updateData() {
        (recyclerMoviesList?.adapter as? MoviesListAdapter)?.apply {
            bindMovies(MoviesDataSource().getMovies())
        }
    }

}


