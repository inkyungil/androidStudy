package com.example.wowapplication.service.request

data class AsReportRequest(
    val bcode: Boolean,
    val scode: String?,
    val ascode: String?,
    val asTime: String?,
    val content: String?,
    val admin_idx: String?
)
