package com.example.bafoegbuddy.model

data class FollowUpRequest(
    val id: Int,
    val applicationId: Int,
    val message: String,
    val receivedAt: String,
    val dueDate: String,
    val status: FollowUpStatus
)

enum class FollowUpStatus {
    OPEN,
    IN_PROGRESS,
    DONE
}
