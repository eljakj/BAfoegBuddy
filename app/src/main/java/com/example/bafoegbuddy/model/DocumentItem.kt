package com.example.bafoegbuddy.model

data class DocumentItem(
    val id: Int,
    val applicationId: Int,
    val name: String,
    val status: DocumentStatus,
    val isRequired: Boolean
)

enum class DocumentStatus {
    MISSING,
    AVAILABLE,
    UPLOADED,
    IN_REVIEW
}
