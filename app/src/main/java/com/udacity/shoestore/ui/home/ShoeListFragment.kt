package com.udacity.shoestore.ui.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShowRowBinding
import com.udacity.shoestore.models.ShoeListViewModel
import timber.log.Timber


/**
 * A simple [Fragment] subclass.
 * Use the [ShoeListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeListFragment : Fragment() {

    private val viewModel : ShoeListViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val  binding: FragmentShoeListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        viewModel.shoeList.observe(this as LifecycleOwner, Observer {
            for (shoe in viewModel.shoeList.value!!) {
                val rowBinding = ShowRowBinding.inflate(inflater)
                rowBinding.shoeData = shoe
                binding.innerLayout.addView(rowBinding.root)
            }
        })

        binding.addFab.setOnClickListener {
            Timber.i("in addShoeButton listener")
            Timber.i(viewModel.shoeList.value?.joinToString(separator = "\n"))
            val action = ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
            findNavController().navigate(action)
        }

        // to show option menu
        setHasOptionsMenu(true)

        return binding.root
    }



    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.logout_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.loginFragment -> {
                logout()
            }
        }
        return super.onOptionsItemSelected(item)
    }


    private fun logout() {
        val action = ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment()
        findNavController().navigate(action)
    }
}