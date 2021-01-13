package com.example.firstkotlinapp

class MoviesDataSource {
    fun getMovies(): List<Movie> {
        return listOf(
                Movie(
                        "Avengers:End Game",
                        R.drawable.poster_avengers_end_game,
                        "Action, Adventure, Fantasy",
                        "13+",
                        "125 Reviews",
                        "137 MIN",
                        4F
                ),
                Movie(
                        "Tenet",
                        R.drawable.poster_tenet,
                        "Action, Sci-Fi, Thriller",
                        "16+",
                        "98 Reviews",
                        "97 MIN",
                        3F
                ),
                Movie(
                        "Black Widow",
                        R.drawable.poster_black_widow,
                        "Action, Adventure, Sci-Fi",
                        "13+",
                        "38 Reviews",
                        "102 MIN",
                        5F
                ),
                Movie(
                        "Wonder Woman 1984",
                        R.drawable.poster_wonder_woman_1984,
                        "Action, Adventure, Fantasy",
                        "13+",
                        "74 Reviews",
                        "120 MIN",
                        4F
                )
        )
    }
}