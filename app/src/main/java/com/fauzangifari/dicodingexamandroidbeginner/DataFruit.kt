package com.fauzangifari.dicodingexamandroidbeginner

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataFruit(
    var name: String,
    var description: String,
    var photo: Int,
    var benefit: String,
): Parcelable
