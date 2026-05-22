package com.example.bafoegbuddy

import com.example.bafoegbuddy.controller.FollowUpController
import com.example.bafoegbuddy.model.FollowUpRequest
import com.example.bafoegbuddy.model.FollowUpStatus
import org.junit.Assert.assertEquals
import org.junit.Test

class FollowUpControllerTest {

    private val controller = FollowUpController()

    @Test
    fun openFollowUps_areFilteredCorrectly() {
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

        val openFollowUps = controller.getOpenFollowUps(followUps)

        assertEquals(1, openFollowUps.size)
        assertEquals("Bitte Einkommensnachweis Eltern nachreichen.", openFollowUps[0].message)
    }

    @Test
    fun followUpCanBeMarkedAsDone() {
        val followUp = FollowUpRequest(
            id = 1,
            applicationId = 1,
            message = "Bitte Mietbescheinigung nachreichen.",
            receivedAt = "2026-06-01",
            dueDate = "2026-06-15",
            status = FollowUpStatus.OPEN
        )

        val updatedFollowUp = controller.markAsDone(followUp)

        assertEquals(FollowUpStatus.DONE, updatedFollowUp.status)
    }

    @Test
    fun followUpCanBeMarkedAsInProgress() {
        val followUp = FollowUpRequest(
            id = 1,
            applicationId = 1,
            message = "Bitte Krankenversicherungsnachweis nachreichen.",
            receivedAt = "2026-06-01",
            dueDate = "2026-06-15",
            status = FollowUpStatus.OPEN
        )

        val updatedFollowUp = controller.markAsInProgress(followUp)

        assertEquals(FollowUpStatus.IN_PROGRESS, updatedFollowUp.status)
    }
}