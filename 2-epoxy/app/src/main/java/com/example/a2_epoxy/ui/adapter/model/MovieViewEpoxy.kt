package com.example.a2_epoxy.ui.adapter.model

import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.a2_epoxy.R
import com.example.a2_epoxy.data.Movie
import com.example.a2_epoxy.ui.adapter.KotlinEpoxyHolder

@EpoxyModelClass(layout = R.layout.movie_view)
abstract class MovieViewEpoxy : EpoxyModelWithHolder<MovieViewEpoxy.Holder>() {

    @EpoxyAttribute
    lateinit var movie: Movie
    @EpoxyAttribute
    lateinit var onclick: (Movie) -> Unit

    override fun bind(holder: Holder) = with(holder){
        imageView.setImageDrawable(
            getView().context.let {
                ContextCompat.getDrawable(
                    it,
                    movie.imgPoster,
                )
            }
        )

        holder.textView.text = movie.name
        getView().setOnClickListener { onclick(movie) }
    }

    class Holder:KotlinEpoxyHolder() {
        val imageView by bind<ImageView>(R.id.imageView)
        val textView by bind<TextView>(R.id.textView)
    }
}