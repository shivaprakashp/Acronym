package com.acronym.app.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.acronym.app.model.ResponseData
import com.acronym.app.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object CentralRepository {

    val serviceCallData = MutableLiveData<ResponseData>()

    fun getServiceApiCall(data : String) : MutableLiveData<ResponseData>{

        val call = RetrofitClient.apiInterface.getService(data)

        call.enqueue(object: Callback<List<ResponseData>> {
            override fun onFailure(call: Call<List<ResponseData>>, t: Throwable) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<List<ResponseData>>,
                response: Response<List<ResponseData>>
            ) {
                // TODO("Not yet implemented")
                Log.v("DEBUG : ", response.body().toString())

                val data = response.body()

                if (data != null) {
                    serviceCallData.value = ResponseData(data.get(0).sf, data.get(0).lfs)
                }
            }
        })

        return serviceCallData
    }


}