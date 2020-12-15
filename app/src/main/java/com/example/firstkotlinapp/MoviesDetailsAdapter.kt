package com.example.firstkotlinapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MoviesDetailsAdapter : RecyclerView.Adapter<MoviesDetailsAdapter.MoviesDetailViewHolder>() {
    private var actors = listOf<Actor>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesDetailViewHolder {
        return MoviesDetailViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.view_holder_actor, parent, false))
    }

    override fun onBindViewHolder(holder: MoviesDetailViewHolder, position: Int) {
        holder.onBindActors(actors[position])
    }

    override fun getItemCount(): Int {
        return actors.size
    }

    fun bindActors(newActors: List<Actor>) {
        actors = newActors
    }

    class MoviesDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameActorHolder: TextView =
                itemView.findViewById(R.id.actor_holder_textView)
        private val avatarHolder: ImageView = itemView.findViewById(R.id.actor_holder_imageView)

        fun onBindActors(actor: Actor) {
            Glide.with(itemView.context)
                    .load(actor.avatar)
                    .apply(imageOption)
                    .into(avatarHolder)

            nameActorHolder.text = actor.nameActor

        }

        companion object {
            private val imageOption = RequestOptions()
                    .placeholder(R.drawable.ic_avatar_placeholder)
                    .fallback(R.drawable.ic_avatar_placeholder)
        }
    }


}
