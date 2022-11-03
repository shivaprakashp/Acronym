package com.acronym.app.retrofit

import com.acronym.app.model.ResponseData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Apiiinterface {

    @GET("?")
    fun getService(@Query("sf") sf : String) : Call<List<ResponseData>>
}