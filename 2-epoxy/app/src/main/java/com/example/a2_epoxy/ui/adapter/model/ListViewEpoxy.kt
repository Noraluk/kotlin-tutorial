package com.example.a2_epoxy.ui.adapter.model

import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.a2_epoxy.R
import com.example.a2_epoxy.data.CardList
import com.example.a2_epoxy.ui.adapter.KotlinEpoxyHolder

@EpoxyModelClass(layout = R.layout.list_view)
abstract class ListViewEpoxy : EpoxyModelWithHolder<ListViewEpoxy.Holder>() {

    @EpoxyAttribute
    lateinit var cardList: CardList

    override fun bind(holder: Holder) = with(holder) {
        holder.titleTextView.text = cardList.title
        holder.descriptionTextView.text = cardList.description

        holder.imageView.setImageDrawable(
            getView().context.let {
                ContextCompat.getDrawable(
                    it,
                    cardList.profilePic,
                )
            }
        )
    }

    class Holder: KotlinEpoxyHolder() {
        val imageView by bind<ImageView>(R.id.list_imageView)
        val titleTextView by bind<TextView>(R.id.list_title_textView)
        val descriptionTextView by bind<TextView>(R.id.list_description_textView)
    }
}