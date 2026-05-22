package com.example.bafoegbuddy.service

import com.example.bafoegbuddy.controller.DeadlineController
import com.example.bafoegbuddy.model.Deadline
import java.time.LocalDate

class ReminderService(
    private val deadlineController: DeadlineController = DeadlineController()
) {

    fun shouldRemind(
        deadline: Deadline,
        today: LocalDate = LocalDate.now(),
        daysBefore: Long = 3
    ): Boolean {
        val daysLeft = deadlineController.calculateDaysLeft(deadline, today)
        return !deadline.isDone && daysLeft in 0L..daysBefore
    }
}
