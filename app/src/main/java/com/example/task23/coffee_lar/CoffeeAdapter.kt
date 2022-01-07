package com.example.task23.coffee_lar

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.task23.databinding.CoffeeItemLayoutBinding

class CoffeeAdapter(private val coffies: List<Coffee>, private val context: Context) : RecyclerView.Adapter<CoffeeAdapter.CoffeeViewHolder>() {

    class CoffeeViewHolder(private val binding: CoffeeItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind(context: Context, coffee: Coffee) {
            binding.imgCoffee.setImageDrawable(context.getDrawable(coffee.img))
            binding.descriptionCoffee.text = coffee.description
            binding.nameCoffee.text = coffee.name
        }

        companion object {
            fun from(parent:ViewGroup): CoffeeViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CoffeeItemLayoutBinding.inflate(layoutInflater, parent, false)
                return CoffeeViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeViewHolder {
        return CoffeeViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CoffeeViewHolder, position: Int) {
        holder.bind(context, coffies[position])
    }

    override fun getItemCount(): Int {
        return coffies.size
    }

}