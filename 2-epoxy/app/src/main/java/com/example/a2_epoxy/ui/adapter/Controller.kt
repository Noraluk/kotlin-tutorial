package com.example.a2_epoxy.ui.adapter

import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.EpoxyController
import com.example.a2_epoxy.R
import com.example.a2_epoxy.data.CardList
import com.example.a2_epoxy.data.Movie
import com.example.a2_epoxy.ui.adapter.model.*
import kotlin.properties.Delegates.observable

class Controller : EpoxyController() {

    var onclickItem: ((Movie) -> Unit?)? = null

    init {
      Carousel.setDefaultGlobalSnapHelperFactory(null)
    }

    var movies by observable(emptyList<Movie>()){ _, _, _ -> requestModelBuild()}
    var cardLists by observable(emptyList<CardList>()){_,_,_, -> requestModelBuild()}

    override fun buildModels() {
        AdsBannerViewEpoxyModel_().id("ADS_BANNER_VIEW").addTo(this)

        TitleViewEpoxy_()
            .id("TITLE_VIEW")
            .movieTitle(R.string.movie_title)
            .addTo(this)

        val movieModels = movies.map {
            MovieViewEpoxy_().apply {
                id(it.id)
                movie(it)
                onclick = { movieModel -> this@Controller.onclickItem?.invoke(movieModel) }
            }
        }

        CarouselModel_()
            .id("MOVIE")
            .numViewsToShowOnScreen(2f)
            .paddingDp(8)
            .models(movieModels)
            .addTo(this)

        TitleViewEpoxy_()
            .id("TITLE_VIEW")
            .movieTitle(R.string.list_title)
            .addTo(this)

        cardLists.forEach {
            ListViewEpoxy_()
                .id("LIST_VIEW")
                .cardList(it)
                .addTo(this)
        }
    }
}