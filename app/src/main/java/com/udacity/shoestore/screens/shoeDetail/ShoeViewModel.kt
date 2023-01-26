package com.udacity.shoestore.screens.shoeDetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe
import timber.log.Timber

class ShoeViewModel: ViewModel(){

    var myShoe: Shoe = Shoe("", 0.0, "", "")

    private var _shoes = MutableLiveData<MutableList<Shoe>>()
    val shoes: LiveData<MutableList<Shoe>>
        get() = _shoes

    private var _eventFinishedOrCanceled = MutableLiveData<Boolean>()
    val eventFinishedOrCanceled: LiveData<Boolean>
    get() = _eventFinishedOrCanceled

    init {
        _shoes.value = mutableListOf()
        _eventFinishedOrCanceled.value = false
        resetMyShoe()
    }

    fun onSave(){
        _shoes.value?.add(myShoe)
        _eventFinishedOrCanceled.value = true
    }

    fun onCancel(){
        resetMyShoe()
        _eventFinishedOrCanceled.value = true
    }

    private fun resetMyShoe() {
        myShoe = Shoe("", 0.0, "", "")
    }

    fun eventComplete(){
        resetMyShoe()
        _eventFinishedOrCanceled.value = false
    }

}