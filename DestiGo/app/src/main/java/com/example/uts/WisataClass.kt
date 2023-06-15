package com.example.uts

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WisataClass(
    val wisataimg: Int,
    val wisataname: String,
    val wisatalocation: String,
    val wisatadesc: String,
    val wisatarate: String,
    val ratingbar: Double,

) : Parcelable