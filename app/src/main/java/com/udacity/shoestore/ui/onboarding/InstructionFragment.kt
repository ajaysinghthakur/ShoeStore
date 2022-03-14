package com.udacity.shoestore.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionBinding


class InstructionFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentInstructionBinding>(inflater, R.layout.fragment_instruction, container, false)

        binding.instructionsNextButton.setOnClickListener {
            val action = WelcomeFragmentDirections.actionWelcomeToInstruction()
            NavHostFragment.findNavController(this).navigate(action)
        }

        return binding.root
    }

}