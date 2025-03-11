package com.example.wowapplication.service.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AsReportResponse(
    val idx: String?,
    val bcode: String?,
    val scode: String?,
    val ascode: String?,
    val id: String?,
    val asTime: String?,
    val bname: String?,
    val sname: String?,
    val asname: String?
) : Parcelable