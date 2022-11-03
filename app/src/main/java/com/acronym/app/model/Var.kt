package com.acronym.app.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Var (
    @SerializedName("lf"    ) var lf    : String? = null,
    @SerializedName("freq"  ) var freq  : Int?    = null,
    @SerializedName("since" ) var since : Int?    = null
)