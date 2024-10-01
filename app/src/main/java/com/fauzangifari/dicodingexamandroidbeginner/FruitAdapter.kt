package com.fauzangifari.dicodingexamandroidbeginner

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FruitAdapter(private val listFruit: ArrayList<DataFruit>) : RecyclerView.Adapter<FruitAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val fruitTitle: TextView = itemView.findViewById(R.id.fruit_name)
        val fruitDescription: TextView = itemView.findViewById(R.id.fruit_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_fruit, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listFruit.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listFruit[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.imgPhoto)
        holder.fruitTitle.text = name
        holder.fruitDescription.text = description
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listFruit[holder.adapterPosition])
        }
    }

    fun setOnItemClickCallback(onItemClickCallback: FruitAdapter.OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: DataFruit)
    }
}