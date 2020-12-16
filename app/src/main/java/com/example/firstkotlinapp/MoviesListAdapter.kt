package com.example.firstkotlinapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MoviesListAdapter(private val clickListener: OnRecyclerItemClicked) : RecyclerView.Adapter<MoviesListAdapter.MoviesListViewHolder>() {

    private var movies = listOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesListViewHolder {
        return MoviesListViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.view_holder_movie, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MoviesListViewHolder, position: Int) {
        holder.onBind(movies[position])
        holder.itemView.setOnClickListener { clickListener.onClick(movies[position]) }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun bindMovies(newMovies: List<Movie>) {
        movies = newMovies
    }

    class MoviesListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameMovieHolder: TextView =
                itemView.findViewById(R.id.name_of_movie_on_poster_textView)
        private val posterHolder: ImageView = itemView.findViewById(R.id.poster_of_movie_imageView)
        private val genreHolder: TextView =
                itemView.findViewById(R.id.film_genre_on_poster_textView)
        private val ageLimitHolder: TextView =
                itemView.findViewById(R.id.age_limit_on_poster_textView)
        private val reviewsHolder: TextView =
                itemView.findViewById(R.id.reviews_number_on_poster_textView)
        private val lengthMovieHolder: TextView =
                itemView.findViewById(R.id.movie_length_on_poster_textView)

        fun onBind(movie: Movie) {
            Glide.with(itemView.context)
                    .load(movie.poster)
                    .apply(imageOption)
                    .into(posterHolder)

            nameMovieHolder.text = movie.nameMovie
            genreHolder.text = movie.genre
            ageLimitHolder.text = movie.ageLimit
            reviewsHolder.text = movie.reviews
            lengthMovieHolder.text = movie.lengthMovie
        }

        companion object {
            private val imageOption = RequestOptions()
                    .placeholder(R.drawable.ic_avatar_placeholder)
                    .fallback(R.drawable.ic_avatar_placeholder)
        }
    }


}

interface OnRecyclerItemClicked {
    fun onClick(movie: Movie)
}


