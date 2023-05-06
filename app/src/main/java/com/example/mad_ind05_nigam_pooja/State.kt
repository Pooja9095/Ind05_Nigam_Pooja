package com.example.mad_ind05_nigam_pooja
//Import necessary packages
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
// Annotate the data class with @Parcelize to enable Parcelable implementation
@Parcelize
// Define the State data class
data class State(
    val name: String, // State name
    val nickname: String, // State nickname
    val area: String,  // State area
    val flagResId: Int, // Resource ID for the flag image
    val mapResId: Int // Resource ID for the map image
) : Parcelable // Make the data class Parcelable to enable passing between activities
