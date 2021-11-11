package com.example.restapi.ui.adapter.album

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.restapi.R
import com.example.restapi.data.model.album.Album
import kotlinx.android.synthetic.main.album_rv_item_view.*
import kotlinx.android.synthetic.main.album_rv_item_view.view.*

class AlbumAdapter() : RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>(){
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
         itemView.album_id.text = "id : ${item?.id.toString()}"
         itemView.album_user_id.text = "userid : ${item?.userId.toString()}"
         itemView.album_title.text = "title : ${item?.album_title}"
      }
   }
}