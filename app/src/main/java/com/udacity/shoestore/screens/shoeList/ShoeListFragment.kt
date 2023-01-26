package com.udacity.shoestore.screens.shoeList

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeLayoutBinding
import com.udacity.shoestore.screens.shoeDetail.ShoeViewModel

class ShoeListFragment : Fragment() {

    private val shoeViewModel: ShoeViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding  = DataBindingUtil.inflate(inflater,
            R.layout.fragment_shoe_list,
            container,
            false)

        shoeViewModel.shoes.observe(viewLifecycleOwner, Observer { shoes ->
            for(shoe in shoes){
                DataBindingUtil.inflate<ShoeLayoutBinding>(
                    inflater,
                    R.layout.shoe_layout,
                    binding.shoeListLinearlayout,
                    true
                ).apply {
                    this.shoe = shoe
                }
            }
        })

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
    if(item.itemId == R.id.logout_menu){
        findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment())
    }
            return super.onOptionsItemSelected(item)
    }

}