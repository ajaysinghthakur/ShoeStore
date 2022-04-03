package com.udacity.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class ShoeListViewModel: ViewModel() {

    private var _shoeList = MutableLiveData<MutableList<Shoe>>()
    val  shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    init {
        Timber.i("in init")
        _shoeList.value = mutableListOf()
        addShoe("Shoe10", 8.0, "Company10", "desc10")
        addShoe("Go Run", size = 11.0, company = "Sketchers", description = "running shoes")
    }

    fun addShoe(name: String, size: Double, company: String, description: String) {
        Timber.i("Adding shoe")
        _shoeList.value?.add(Shoe(name, size, company, description))
        Timber.i(_shoeList.value?.joinToString())
    }



}