package com.example.fyp.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataSponsor(
    var id : String = "",
    var email : String = "",
    var pass : String = "",
    var companyName : String = "",
    var designation : String = "",
    var name : String = "",
    var image : String = ""
)  : Parcelable