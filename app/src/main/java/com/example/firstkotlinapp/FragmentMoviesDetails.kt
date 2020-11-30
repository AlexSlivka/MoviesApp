package com.example.firstkotlinapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentMoviesDetails : Fragment() {
    private var movieDetailsFragmentClick: MovieDetailsFragmentClicks? = null
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_movies_details, container, false)
        view?.findViewById<TextView>(R.id.back_textView)?.apply {
            setOnClickListener {
                movieDetailsFragmentClick?.backToMoviesListFragment()
            }
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MovieDetailsFragmentClicks) {
            movieDetailsFragmentClick = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        movieDetailsFragmentClick = null
    }

    interface MovieDetailsFragmentClicks {
        fun backToMoviesListFragment()
    }
}

