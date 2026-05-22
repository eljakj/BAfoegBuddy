package com.example.bafoegbuddy.controller

import com.example.bafoegbuddy.model.Deadline
import com.example.bafoegbuddy.model.DocumentItem
import com.example.bafoegbuddy.model.FollowUpRequest
import com.example.bafoegbuddy.model.FollowUpStatus

data class DashboardSummary(
    val completionPercentage: Int,
    val missingDocumentCount: Int,
    val openDeadlineCount: Int,
    val openFollowUpCount: Int
)

class DashboardController(
    private val requirementChecker: RequirementChecker = RequirementChecker()
) {

    fun buildSummary(
        documents: List<DocumentItem>,
        deadlines: List<Deadline>,
        followUps: List<FollowUpRequest>
    ): DashboardSummary {
        return DashboardSummary(
            completionPercentage = requirementChecker.calculateCompletionPercentage(documents),
            missingDocumentCount = requirementChecker.getMissingRequiredDocuments(documents).size,
            openDeadlineCount = deadlines.count { !it.isDone },
            openFollowUpCount = followUps.count { it.status != FollowUpStatus.DONE }
        )
    }
}
