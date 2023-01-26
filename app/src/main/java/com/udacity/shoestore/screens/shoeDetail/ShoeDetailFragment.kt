package com.udacity.shoestore.screens.shoeDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding


class ShoeDetailFragment : Fragment() {


    private val shoeViewModel: ShoeViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
            binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_shoe_detail,
                container,
                false)

        binding.shoeViewModel = shoeViewModel

        shoeViewModel.eventFinishedOrCanceled.observe(viewLifecycleOwner, Observer { hasFinished ->
            if(hasFinished){
                goToShoeList()
                shoeViewModel.eventComplete()
            }
        })

        return binding.root
    }

    private fun goToShoeList(){
       findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
    }

}