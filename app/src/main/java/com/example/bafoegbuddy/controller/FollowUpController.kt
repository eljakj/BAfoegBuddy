package com.example.bafoegbuddy.controller

import com.example.bafoegbuddy.model.FollowUpRequest
import com.example.bafoegbuddy.model.FollowUpStatus

class FollowUpController {

    fun getOpenFollowUps(followUps: List<FollowUpRequest>): List<FollowUpRequest> {
        return followUps.filter { followUp ->
            followUp.status != FollowUpStatus.DONE
        }
    }

    fun markAsDone(followUp: FollowUpRequest): FollowUpRequest {
        return followUp.copy(status = FollowUpStatus.DONE)
    }

    fun markAsInProgress(followUp: FollowUpRequest): FollowUpRequest {
        return followUp.copy(status = FollowUpStatus.IN_PROGRESS)
    }
}
