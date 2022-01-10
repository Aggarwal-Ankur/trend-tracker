package com.dataworks.trendtracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.dataworks.trendtracker.databinding.FragmentTopTrendsBinding

class TopTrendsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding : FragmentTopTrendsBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_top_trends ,container, false)

        val application = requireNotNull(this.activity).application

        binding.lifecycleOwner = this

        return binding.root

    }


}