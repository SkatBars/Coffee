package com.example.task23.coffee_lar

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.task23.R
import com.example.task23.databinding.CategoriesItemLayoutBinding

class CategoriesAdapter(private val categories: List<Category>) : RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    class CategoriesViewHolder(private val binding: CategoriesItemLayoutBinding, private val context: Context) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind(category: Category) {
            binding.categoryTxtv.text = category.name
            binding.categorieImg.setImageDrawable(context.getDrawable(category.image))

        }

        companion object {
            fun from(parent: ViewGroup): CategoriesViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = DataBindingUtil.inflate<CategoriesItemLayoutBinding>(layoutInflater, R.layout.categories_item_layout, parent, false)
                return CategoriesViewHolder(binding, parent.context)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        return CategoriesViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount(): Int {
        return categories.size
    }

}