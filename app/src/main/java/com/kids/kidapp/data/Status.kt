package com.kids.kidapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Status(
    val Time: String,
    val data: List<ListData>
):Parcelable
