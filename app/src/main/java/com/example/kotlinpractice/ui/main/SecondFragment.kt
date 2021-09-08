package com.example.kotlinpractice.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.kotlinpractice.R
import com.example.kotlinpractice.databinding.FragmentSecondBinding
import com.example.kotlinpractice.di.qualifier.AppHash
import com.example.kotlinpractice.ui.data.MyRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding

    @Inject
    lateinit var repository: MyRepository

    @AppHash
    @Inject
    lateinit var applicationHash: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_second, container, false)
        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_mainFragment)
        }
        return binding.root
    }
}