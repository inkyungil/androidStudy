package com.example.wowapplication.service.response

data class AsReportDetailDataResponse(
    val idx: Int?,
    val bcode: String?,
    val scode: String?,
    val ascode: String?,
    val content: String?,
    val id: String?,
    val asTime: String?,
    val bname: String?,
    val sname: String?,
    val asname: String?,
    val photos: List<String> = emptyList()
)