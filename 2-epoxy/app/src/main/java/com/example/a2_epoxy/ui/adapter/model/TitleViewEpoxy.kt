package com.example.a2_epoxy.ui.adapter.model

import android.widget.TextView
import com.airbnb.epoxy.*
import com.example.a2_epoxy.R
import com.example.a2_epoxy.ui.adapter.KotlinEpoxyHolder

@EpoxyModelClass(layout = R.layout.movie_title_view)
abstract class TitleViewEpoxy : EpoxyModelWithHolder<TitleViewEpoxy.Holder>() {

    @EpoxyAttribute
    var movieTitle: Int? = null

    override fun bind(holder: Holder) = with(holder){
        movieTextView.setText(movieTitle!!)
    }

    class Holder : KotlinEpoxyHolder() {
        val movieTextView by bind<TextView>(R.id.movie_textView)
    }
}