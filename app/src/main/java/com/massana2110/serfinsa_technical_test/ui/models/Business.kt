package com.massana2110.serfinsa_technical_test.ui.models

import android.net.Uri

data class Business(
    val name: String,
    val department: String,
    val municipality: String,
    val dui: String,
    val image: Uri?,
    val contactNumber: String,
    val contactEmail: String,
    val state: BusinessStates
)

enum class BusinessStates {
    ACCEPTED,
    DENIED,
    REVISION
}