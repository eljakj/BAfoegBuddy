package com.example.bafoegbuddy.model

data class Deadline(
    val id: Int,
    val applicationId: Int,
    val title: String,
    val dueDate: String,
    val isDone: Boolean
)
