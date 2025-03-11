package com.example.wowapplication.service.response

data class AsReportListSearchResponse(
    val success: Boolean,
    val totalCount: Int,
    val ascodeCounts: MutableList<CodeNameData>,
    val data: MutableList<AsReportResponse>
)
