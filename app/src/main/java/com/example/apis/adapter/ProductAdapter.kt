package com.example.apis.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apis.R
import com.example.apis.model.Product
import com.example.apis.view.MainActivity
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class ProductAdapter(val context: Context, val itemList: List<Product>): RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(view: View): RecyclerView.ViewHolder(view){
        val brand: TextView = view.findViewById(R.id.txt_brand)
        val title: TextView = view.findViewById(R.id.txt_title)
        val desc: TextView = view.findViewById(R.id.txt_desc)
        val img: ShapeableImageView = view.findViewById(R.id.img)
        val rating: TextView = view.findViewById(R.id.rating)
        val dis: TextView = view.findViewById(R.id.discount)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_item_row, parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val currentItem = itemList[position]
        holder.title.text = currentItem.title
        holder.brand.text = currentItem.brand
        holder.dis.text = currentItem.discountPercentage.toString()
        holder.rating.text = currentItem.rating.toString()
        holder.desc.text = currentItem.description
     /*   Picasso.get()
            .load(currentItem.images)
            .into(holder.img)
*/
    }
}