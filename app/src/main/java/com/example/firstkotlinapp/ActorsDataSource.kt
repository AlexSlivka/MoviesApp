package com.example.firstkotlinapp

class ActorsDataSource {
    fun getActors(): List<Actor> {
        return listOf(
                Actor("Robert Downey Jr", R.drawable.actor_robert_downey),
                Actor("Chris Evans", R.drawable.actor_chris_evans),
                Actor("Mark Ruffalo", R.drawable.actor_ruffalo),
                Actor("Chris Hemsworth", R.drawable.actor_chris_hemsworth))

    }
}