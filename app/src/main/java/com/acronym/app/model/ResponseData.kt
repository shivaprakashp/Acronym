package com.acronym.app.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponseData (
    @SerializedName("sf"  ) var sf  : String?        = null,
    @SerializedName("lfs" ) var lfs : ArrayList<Lf> = arrayListOf()
)