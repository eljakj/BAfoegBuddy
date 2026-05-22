package com.example.bafoegbuddy.controller

import com.example.bafoegbuddy.model.ApplicationStatus
import com.example.bafoegbuddy.model.ApplicationType
import com.example.bafoegbuddy.model.BafogApplication

class ApplicationController {

    fun createFirstApplication(
        id: Int,
        userId: Int,
        createdAt: String
    ): BafogApplication {
        return BafogApplication(
            id = id,
            userId = userId,
            applicationType = ApplicationType.FIRST_APPLICATION,
            status = ApplicationStatus.IN_PREPARATION,
            createdAt = createdAt,
            lastUpdatedAt = createdAt
        )
    }

    fun changeStatus(
        application: BafogApplication,
        newStatus: ApplicationStatus,
        updatedAt: String
    ): BafogApplication {
        return application.copy(
            status = newStatus,
            lastUpdatedAt = updatedAt
        )
    }
}
