package com.example.bafoegbuddy.model

data class BafogApplication(
    val id: Int,
    val userId: Int,
    val applicationType: ApplicationType,
    val status: ApplicationStatus,
    val createdAt: String,
    val lastUpdatedAt: String
)

enum class ApplicationType {
    FIRST_APPLICATION,
    FOLLOW_UP_APPLICATION
}

enum class ApplicationStatus {
    IN_PREPARATION,
    SUBMITTED,
    MISSING_DOCUMENTS,
    APPROVED,
    REJECTED
}
