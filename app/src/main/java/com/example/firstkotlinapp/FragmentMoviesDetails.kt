package com.example.firstkotlinapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentMoviesDetails : Fragment() {

    private var recyclerMoviesDetail: RecyclerView? = null
    private var adapterMoviesDetail: MoviesDetailsAdapter? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_movies_details, container, false)
        view.findViewById<TextView>(R.id.back_textView).setOnClickListener {
            fragmentManager?.popBackStack()
        }
        val ratingStar:RatingBar = view.findViewById(R.id.ratingBar_star)
        ratingStar.rating= 4F
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerMoviesDetail = view.findViewById(R.id.rv_actors_list)
        adapterMoviesDetail = MoviesDetailsAdapter()
        recyclerMoviesDetail?.adapter = adapterMoviesDetail
        recyclerMoviesDetail?.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
    }

    override fun onStart() {
        super.onStart()
        updateData()
    }

    override fun onDetach() {
        recyclerMoviesDetail = null
        super.onDetach()
    }

    private fun updateData() {
       adapterMoviesDetail?.bindActors(ActorsDataSource().getActors())
    }
}

