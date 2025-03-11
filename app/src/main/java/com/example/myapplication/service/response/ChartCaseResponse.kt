package com.example.wowapplication.service.response

data class ChartCaseResponse(
    val success: Boolean,
    val totalCount: Int,
    val ascodeCounts: MutableList<CodeNameData>,
    val sigunCodeCounts: MutableList<CodeNameData>,
    val brandCounts: MutableList<CodeNameData>,
    val storeCounts: MutableList<CodeNameData>
)
