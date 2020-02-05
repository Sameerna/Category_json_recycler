package com.example.recycler_json_task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.categories.view.*


class CategoryAdapter (val categorry : List<Categorry>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryViewHolder {
        return  CategoryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.categories,parent,false)
        )
    }

    override fun getItemCount() = categorry.size

    override fun onBindViewHolder(holder: CategoryAdapter.CategoryViewHolder, position: Int) {
        val category = categorry[position]
        holder.view.textViewi.text = category.i.toString()
        holder.view.textViewn.text= category.n
        holder.view.textViewa.text = category.a
        Glide.with(holder.view.context)
            .load(category.p)
            .into(holder.view.imageView)
    }
 class CategoryViewHolder(val view: View): RecyclerView.ViewHolder(view)
}













