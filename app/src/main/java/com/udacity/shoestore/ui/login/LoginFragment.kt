package com.udacity.shoestore.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentLoginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container,false)

        binding.login.setOnClickListener {
            this.navigationToShoeList()
        }

        binding.signup.setOnClickListener {
            this.navigationToWelcome()
        }

        return binding.root
    }

    private fun navigationToWelcome() {
        val action = LoginFragmentDirections.actionLoginToWelcome()
        NavHostFragment.findNavController(this).navigate(action)
    }

    private fun navigationToShoeList() {
        val action = LoginFragmentDirections.actionLoginFragmentToShoeListFragment()
        NavHostFragment.findNavController(this).navigate(action)
    }
}