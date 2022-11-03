package com.acronym.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.acronym.app.model.ResponseData
import com.acronym.app.repository.CentralRepository

class MainActivityViewModel : ViewModel() {


    var servicesLiveData: MutableLiveData<ResponseData>? = null

    fun getUser(data : String) : LiveData<ResponseData>? {
        servicesLiveData = CentralRepository.getServiceApiCall(data)
        return servicesLiveData
    }
}