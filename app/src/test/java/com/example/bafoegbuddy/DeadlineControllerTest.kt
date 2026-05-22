package com.example.bafoegbuddy

import com.example.bafoegbuddy.controller.DeadlineController
import com.example.bafoegbuddy.model.Deadline
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import java.time.LocalDate

class DeadlineControllerTest {

    private val controller = DeadlineController()

    @Test
    fun openDeadlines_areFilteredCorrectly() {
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

        val openDeadlines = controller.getOpenDeadlines(deadlines)

        assertEquals(1, openDeadlines.size)
        assertEquals("Nachforderung einreichen", openDeadlines[0].title)
    }

    @Test
    fun daysLeft_areCalculatedCorrectly() {
        val deadline = Deadline(
            id = 1,
            applicationId = 1,
            title = "Nachforderung einreichen",
            dueDate = "2026-06-15",
            isDone = false
        )

        val today = LocalDate.of(2026, 6, 10)

        val daysLeft = controller.calculateDaysLeft(deadline, today)

        assertEquals(5, daysLeft)
    }

    @Test
    fun deadlineIsCritical_whenOnlyThreeDaysLeft() {
        val deadline = Deadline(
            id = 1,
            applicationId = 1,
            title = "Nachforderung einreichen",
            dueDate = "2026-06-13",
            isDone = false
        )

        val today = LocalDate.of(2026, 6, 10)

        val isCritical = controller.isDeadlineCritical(deadline, today)

        assertTrue(isCritical)
    }

    @Test
    fun deadlineIsNotCritical_whenMoreThanThreeDaysLeft() {
        val deadline = Deadline(
            id = 1,
            applicationId = 1,
            title = "Nachforderung einreichen",
            dueDate = "2026-06-20",
            isDone = false
        )

        val today = LocalDate.of(2026, 6, 10)

        val isCritical = controller.isDeadlineCritical(deadline, today)

        assertFalse(isCritical)
    }
}