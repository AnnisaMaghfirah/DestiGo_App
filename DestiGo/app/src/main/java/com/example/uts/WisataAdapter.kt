package com.example.uts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WisataAdapter (private val context: Context, private val wisata: List<WisataClass>, val listener: (WisataClass) -> Unit)
    : RecyclerView.Adapter<WisataAdapter.WisataViewHolder>(){
    class WisataViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val wisataimg = view.findViewById<ImageView>(R.id.image)
        val wisataname = view.findViewById<TextView>(R.id.tv_name)
        val wisatalocation = view.findViewById<TextView>(R.id.tv_location)
        val wisatarate = view.findViewById<TextView>(R.id.tv_rating)
        val ratingbar = view.findViewById<RatingBar>(R.id.ratingbar)

        fun bindView(wisata: WisataClass, listener: (WisataClass) -> Unit){
            wisataimg.setImageResource(wisata.wisataimg)
            wisataname.text = wisata.wisataname
            wisatalocation.text = wisata.wisatalocation
            wisatarate.text = wisata.wisatarate
            ratingbar.rating = wisata.ratingbar.toFloat()
            itemView.setOnClickListener{
                (listener(wisata))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WisataViewHolder {
        return WisataViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: WisataViewHolder, position: Int) {
        holder.bindView(wisata[position], listener)
    }

    override fun getItemCount(): Int = wisata.size

}