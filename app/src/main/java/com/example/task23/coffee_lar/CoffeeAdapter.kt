package com.example.task23.coffee_lar

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.example.task23.R
import com.example.task23.databinding.CoffeeItemLayoutBinding

class CoffeeAdapter(private val coffies: List<Coffee>, private val navContoller: NavController) : RecyclerView.Adapter<CoffeeAdapter.CoffeeViewHolder>() {
    private var previousHolder: CoffeeAdapter.CoffeeViewHolder? = null
    private var currentHolder: CoffeeAdapter.CoffeeViewHolder? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeViewHolder {

        return CoffeeViewHolder.from(parent, navContoller)
    }

    override fun onViewAttachedToWindow(holder: CoffeeViewHolder) {
        previousHolder?.decreaseItem()
        currentHolder?.increaseItem()

        previousHolder = currentHolder
        currentHolder = holder

        super.onViewAttachedToWindow(holder)
    }


    override fun onBindViewHolder(holder: CoffeeViewHolder, position: Int) {
        holder.bind(coffies[position])
    }

    override fun getItemCount(): Int {
        return coffies.size
    }

    class CoffeeViewHolder(
        private val binding: CoffeeItemLayoutBinding,
        private val context: Context,
        private val navContoller: NavController
    ) : RecyclerView.ViewHolder(binding.root) {

        fun increaseItem() {
            val anim = AnimationUtils.loadAnimation(context, R.anim.scale_in)
            binding.root.startAnimation(anim)
            anim.fillAfter = true
        }

        fun decreaseItem() {
            val anim = AnimationUtils.loadAnimation(context, R.anim.scale_out)
            binding.root.startAnimation(anim)
            anim.fillAfter = true
        }

        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind(coffee: Coffee) {
            binding.imgCoffee.setImageDrawable(context.getDrawable(coffee.img))
            binding.descriptionCoffee.text = coffee.description
            binding.nameCoffee.text = coffee.name

            binding.btnPesan.setOnClickListener {
                navContoller.navigate(R.id.detailFragment)
            }
        }

        companion object {
            fun from(parent: ViewGroup, navContoller: NavController): CoffeeViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = CoffeeItemLayoutBinding.inflate(layoutInflater, parent, false)
                return CoffeeViewHolder(binding, parent.context, navContoller)
            }
        }
    }

}