package com.kids.kidapp.data

import com.google.gson.annotations.SerializedName

data class StatusResponse(
    @SerializedName("Status")
    val status: Status
)
