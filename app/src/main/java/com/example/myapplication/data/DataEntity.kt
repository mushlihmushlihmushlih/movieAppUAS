package com.example.myapplication.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataEntity(
    var id: Int? = null,
    var name: String? = null,
    var desc: String? = null,
    var poster: String
) : Parcelable