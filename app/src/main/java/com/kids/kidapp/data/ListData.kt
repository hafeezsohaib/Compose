package com.kids.kidapp.data
import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class ListData(val name: String,
                    val id: Int,
                    val imageUrl: String,
                    val color: String,
                    val category: String,
                    val sound: Sound,
                    val dataSound: List<ListData>? = null):Parcelable
