package com.example.wowapplication.service.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AsReportListSearchAsCodeData(
    val code: String,
    val name: String,
    val count: Int
): Parcelable
