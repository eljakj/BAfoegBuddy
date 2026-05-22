package com.example.bafoegbuddy.service

class NotificationService {

    fun createDeadlineMessage(title: String, daysLeft: Long): String {
        return "Frist: $title endet in $daysLeft Tagen."
    }

    fun createMissingDocumentMessage(count: Int): String {
        return "Es fehlen noch $count Unterlagen."
    }
}
