package com.example.wowapplication.service.request

data class AsReportSearchRequest(
    val page: String,
    val asTimeFrom: String?,
    val asTimeTo: String?,
    val bcode: String?,
    val scode: String?,
    val ascode: String?
)
