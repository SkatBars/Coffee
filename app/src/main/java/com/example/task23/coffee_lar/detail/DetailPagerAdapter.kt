package com.example.task23.coffee_lar.detail

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.task23.R
import com.example.task23.databinding.PagerItemBinding

class DetailPagerAdapter(private val images: List<Int>): RecyclerView.Adapter<DetailPagerAdapter.DetailHolder>()
{

    class DetailHolder(private val binding: PagerItemBinding, private val context: Context): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind(imageId: Int) {
            Toast.makeText(context, "dsfdsf", Toast.LENGTH_LONG)
            binding.imgPager.setImageDrawable(context.getDrawable(imageId))
        }

        companion object {
            fun from(parent: ViewGroup): DetailHolder {
                Toast.makeText(parent.context, "from", Toast.LENGTH_LONG)
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = DataBindingUtil.inflate<PagerItemBinding>(layoutInflater, R.layout.pager_item, parent, false)
                return DetailHolder(binding, parent.context)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailHolder {
        return DetailHolder.from(parent)
    }

    override fun onBindViewHolder(holder: DetailHolder, position: Int) {
        holder.bind(images[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }

}