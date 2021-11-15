package com.example.hilt_demo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hilt_demo.R
import com.example.hilt_demo.data.model.album.Album
import kotlinx.android.synthetic.main.album_rv_item_view.view.*
import javax.inject.Inject

class AlbumAdapter @Inject constructor() : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>(){
    private var data : ArrayList<Album>?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        return AlbumViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.album_rv_item_view,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        val item = data?.get(position)
        holder.bindView(item)
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }

    fun setData(list: ArrayList<Album>){
        data = list
        notifyDataSetChanged()
    }

    class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Album?) {
            "id : ${item?.id.toString()}".also { itemView.album_id.text = it }
            "userid : ${item?.userId.toString()}".also { itemView.album_user_id.text = it }
            "title : ${item?.album_title}".also { itemView.album_title.text = it }
        }
    }
}
