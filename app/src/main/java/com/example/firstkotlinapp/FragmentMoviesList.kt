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
    private var adapterMoviesList: MoviesListAdapter? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_movies_list, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerMoviesList = view.findViewById(R.id.rv_movies_list)
        adapterMoviesList = MoviesListAdapter(clickListener)
        recyclerMoviesList?.adapter = adapterMoviesList
        val displayMetrics = context?.resources?.displayMetrics
        val screenWidthDp = displayMetrics!!.widthPixels / displayMetrics.density
        val columnWidthDp = resources.getDimensionPixelSize(R.dimen.width_holder_movie) / displayMetrics.density
        val noOfColumns = (screenWidthDp / columnWidthDp).toInt()
        recyclerMoviesList?.layoutManager = GridLayoutManager(context, noOfColumns)
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
        adapterMoviesList?.bindMovies(MoviesDataSource().getMovies())
    }

    private fun doOnClick(movie: Movie) {
        fragmentManager?.beginTransaction()
                ?.addToBackStack(null)
                ?.replace(R.id.main_container, FragmentMoviesDetails())
                ?.commit()
    }

    private val clickListener = object : OnRecyclerItemClicked {
        override fun onClick(movie: Movie) {
            doOnClick(movie)
        }
    }

}


