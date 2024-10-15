package com.example.islamiapproute.main.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapproute.R
import java.util.zip.Inflater

class ContentAdapter(val list: List<Pair<String,Int>>):RecyclerView.Adapter<ContentAdapter.ViewHolder>(){

    var onItemClicked:OnItemClicked? = null

    class ViewHolder(itemView:View ):RecyclerView.ViewHolder(itemView){
        val title:TextView = itemView.findViewById(R.id.name)
        val ayat:TextView = itemView.findViewById(R.id.ayat_count)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_quran,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContentAdapter.ViewHolder, position: Int) {
        holder.title.text = list[position].first
        holder.ayat.text =list[position].second.toString()
        holder.itemView.setOnClickListener {
            onItemClicked?.onClick(position,list[position].first)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
    fun interface OnItemClicked{
        fun onClick(position: Int,title:String)
    }
}