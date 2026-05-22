package com.example.bafoegbuddy.data

import com.example.bafoegbuddy.model.BafogApplication
import com.example.bafoegbuddy.model.Deadline
import com.example.bafoegbuddy.model.DocumentItem
import com.example.bafoegbuddy.model.FollowUpRequest

interface BafogRepository {

    fun getApplicationsForUser(userId: Int): List<BafogApplication>

    fun getDocuments(applicationId: Int): List<DocumentItem>

    fun getDeadlines(applicationId: Int): List<Deadline>

    fun getFollowUps(applicationId: Int): List<FollowUpRequest>
}
