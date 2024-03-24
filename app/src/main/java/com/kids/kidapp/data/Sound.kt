package com.kids.kidapp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sound(val categoryName:String,
                 val name: String,
                 val fileName: String):Parcelable
