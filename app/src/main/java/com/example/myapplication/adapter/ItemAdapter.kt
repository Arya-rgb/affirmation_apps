package com.example.myapplication.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.detail.DetailActivity
import com.example.myapplication.model.Affirmation

class ItemAdapter(private val context: Context, private val dataset: List<Affirmation>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)

        val detail = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(detail, DetailActivity::class.java)
            moveDetail.putExtra(DetailActivity.EXTRA_WORD, context.resources.getString(item.stringResourceId))
            moveDetail.putExtra(DetailActivity.EXTRA_PHOTO, item.imageResourceId)
            detail.startActivity(moveDetail)
        }

    }

    override fun getItemCount(): Int = dataset.size
}