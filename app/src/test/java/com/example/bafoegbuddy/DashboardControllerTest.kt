package com.example.bafoegbuddy

import com.example.bafoegbuddy.controller.DashboardController
import com.example.bafoegbuddy.model.Deadline
import com.example.bafoegbuddy.model.DocumentItem
import com.example.bafoegbuddy.model.DocumentStatus
import com.example.bafoegbuddy.model.FollowUpRequest
import com.example.bafoegbuddy.model.FollowUpStatus
import org.junit.Assert.assertEquals
import org.junit.Test

class DashboardControllerTest {

    private val controller = DashboardController()

    @Test
    fun dashboardSummary_isCalculatedCorrectly() {
        val documents = listOf(
            DocumentItem(
                id = 1,
                applicationId = 1,
                name = "Immatrikulationsbescheinigung",
                status = DocumentStatus.UPLOADED,
                isRequired = true
            ),
            DocumentItem(
                id = 2,
                applicationId = 1,
                name = "Mietvertrag",
                status = DocumentStatus.AVAILABLE,
                isRequired = true
            ),
            DocumentItem(
                id = 3,
                applicationId = 1,
                name = "Einkommensnachweis Eltern",
                status = DocumentStatus.MISSING,
                isRequired = true
            )
        )

        val deadlines = listOf(
            Deadline(
                id = 1,
                applicationId = 1,
                title = "Nachforderung einreichen",
                dueDate = "2026-06-15",
                isDone = false
            ),
            Deadline(
                id = 2,
                applicationId = 1,
                title = "Alte Frist",
                dueDate = "2026-05-01",
                isDone = true
            )
        )

        val followUps = listOf(
            FollowUpRequest(
                id = 1,
                applicationId = 1,
                message = "Bitte Einkommensnachweis Eltern nachreichen.",
                receivedAt = "2026-06-01",
                dueDate = "2026-06-15",
                status = FollowUpStatus.OPEN
            ),
            FollowUpRequest(
                id = 2,
                applicationId = 1,
                message = "Mietvertrag wurde geprüft.",
                receivedAt = "2026-05-20",
                dueDate = "2026-05-30",
                status = FollowUpStatus.DONE
            )
        )

        val summary = controller.buildSummary(
            documents = documents,
            deadlines = deadlines,
            followUps = followUps
        )

        assertEquals(67, summary.completionPercentage)
        assertEquals(1, summary.missingDocumentCount)
        assertEquals(1, summary.openDeadlineCount)
        assertEquals(1, summary.openFollowUpCount)
    }
}