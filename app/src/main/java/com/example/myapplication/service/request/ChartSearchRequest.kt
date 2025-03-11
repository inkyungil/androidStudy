package com.example.wowapplication.service.request

data class ChartSearchRequest(
    val asTimeFrom: String?,
    val asTimeTo: String?,
    val bcode: String?,
    val scode: String?,
    val ascode: String?
)
