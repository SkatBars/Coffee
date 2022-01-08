package com.example.task23.coffee_lar.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.task23.R
import com.example.task23.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentDetailBinding>(inflater, R.layout.fragment_detail, container, false)

        Log.i("QWE", "createView")
        binding.viewPagerDetail.adapter = DetailPagerAdapter(listOf(R.drawable.coffee1, R.drawable.coffee2, R.drawable.coffee1))
        binding.dotsIndicator.setViewPager2(binding.viewPagerDetail)
        return binding.root
    }
}