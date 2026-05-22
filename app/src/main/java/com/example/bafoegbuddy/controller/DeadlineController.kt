package com.example.bafoegbuddy.controller

import com.example.bafoegbuddy.model.Deadline
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class DeadlineController {

    fun getOpenDeadlines(deadlines: List<Deadline>): List<Deadline> {
        return deadlines.filter { deadline ->
            !deadline.isDone
        }
    }

    fun calculateDaysLeft(
        deadline: Deadline,
        today: LocalDate = LocalDate.now()
    ): Long {
        val dueDate = LocalDate.parse(deadline.dueDate)
        return ChronoUnit.DAYS.between(today, dueDate)
    }

    fun isDeadlineCritical(
        deadline: Deadline,
        today: LocalDate = LocalDate.now()
    ): Boolean {
        val daysLeft = calculateDaysLeft(deadline, today)
        return !deadline.isDone && daysLeft in 0L..3L
    }
}
