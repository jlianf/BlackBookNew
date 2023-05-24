package com.jalian.blackbook

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jalian.blackbook.model.Field

class MateriAdapter(context: FragmentMateri, private val listMateriItem: List<Any>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ItemViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val tittle : TextView = itemView.findViewById(R.id.tv_tittle_materilist)
        val subttile : TextView = itemView.findViewById(R.id.tv_subtittle_materilist)
    }

    override fun onCreateViewHolder(viewgroup : ViewGroup, i : Int): RecyclerView.ViewHolder {
        val layoutView = LayoutInflater.from(viewgroup.context).inflate(
            R.layout.materi_list, viewgroup,false
        )
        return ItemViewHolder(layoutView)
    }

    override fun getItemCount(): Int {
        return listMateriItem.size
    }

    override fun onBindViewHolder(viewHolder : RecyclerView.ViewHolder, i: Int) {
        val itemViewHolder = viewHolder as ItemViewHolder
        val materi =listMateriItem[1] as Field
        itemViewHolder.tittle.text = materi.title
        itemViewHolder.subttile.text = materi.subTitle
    }

}