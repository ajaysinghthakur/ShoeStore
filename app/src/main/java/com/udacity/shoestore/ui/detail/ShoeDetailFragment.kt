package com.udacity.shoestore.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.ShoeListViewModel

import com.udacity.shoestore.extension.validateDouble
import com.udacity.shoestore.extension.validateString


/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetailFragment : Fragment() {

    private val viewModel : ShoeListViewModel by activityViewModels()

    lateinit var fragmentViewBinding: FragmentShoeDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentViewBinding =  DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)


        fragmentViewBinding.canceButton.setOnClickListener {
            findNavController().navigateUp()
        }

        fragmentViewBinding.saveButton.setOnClickListener {
            if (validateInputs()) {
                val name = fragmentViewBinding.shoeNameText.text.toString()
                val size = fragmentViewBinding.sizeText.text.toString().toDouble()
                val company = fragmentViewBinding.companyText.text.toString()
                val descroption = fragmentViewBinding.descriptionText.text.toString()

                viewModel.addShoe(name = name, size = size, company = company, description = descroption)
                findNavController().navigateUp()
            } else {
                // show alert or something
            }

        }

        return fragmentViewBinding.root
    }

    private fun validateInputs() : Boolean {
        var validInputs = true

        if (!(fragmentViewBinding.shoeNameText.validateString())) {
            validInputs = false
        }
        if (!(fragmentViewBinding.companyText.validateString())) {
            validInputs = false
        }

        if (!(fragmentViewBinding.sizeText.validateDouble())) {
            validInputs = false
        }

        if (!(fragmentViewBinding.descriptionText.validateString())) {
            validInputs = false
        }

        return validInputs
    }
}