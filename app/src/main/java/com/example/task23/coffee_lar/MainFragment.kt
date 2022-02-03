package com.example.task23.coffee_lar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.task23.R
import com.example.task23.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentMainBinding>(inflater, R.layout.fragment_main, container, false)

        val coffies = mutableListOf<Coffee>()
        coffies.add(Coffee(R.drawable.coffee2, "Latte Art Speciality", "Expresso with milk"))
        coffies.add(Coffee(R.drawable.coffee1, "Long Black coffee", "Access water-milk"))
        coffies.add(Coffee(R.drawable.coffee2, "Long Black coffee", "Access water-milk"))
        coffies.add(Coffee(R.drawable.coffee1, "Long Black coffee", "Access water-milk"))
        coffies.add(Coffee(R.drawable.coffee2, "Long Black coffee", "Access water-milk"))
        coffies.add(Coffee(R.drawable.coffee1, "Long Black coffee", "Access water-milk"))
        coffies.add(Coffee(R.drawable.coffee2, "Long Black coffee", "Access water-milk"))
        coffies.add(Coffee(R.drawable.coffee1, "Long Black coffee", "Access water-milk"))

        val myAdapter = CoffeeAdapter(coffies, findNavController())
        val myDecoration = LinearHorizontalSpacingDecoration(resources.getDimensionPixelSize(R.dimen.recycler_spacing))

        with(binding.recyclerCoffee) {
            layoutManager = ProminentLayoutManager(context)
            adapter = myAdapter
            addItemDecoration(myDecoration)
            PagerSnapHelper().attachToRecyclerView(this)
        }

            val categories = mutableListOf<Category>()
            categories.add(Category("Coffee", R.drawable.coffies))
            categories.add(Category("Milkshacke", R.drawable.milkshake))
            categories.add(Category("Coffee", R.drawable.coffies))
            categories.add(Category("Milkshacke", R.drawable.milkshake))
            categories.add(Category("Coffee", R.drawable.coffies))
            binding.recylerCategory.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            binding.recylerCategory.adapter = CategoriesAdapter(categories)



            return binding.root
        }
}