package com.example.bafoegbuddy.controller

import com.example.bafoegbuddy.model.DocumentItem
import com.example.bafoegbuddy.model.DocumentStatus
import kotlin.math.roundToInt

class RequirementChecker {

    fun getMissingRequiredDocuments(documents: List<DocumentItem>): List<DocumentItem> {
        return documents.filter { document ->
            document.isRequired && document.status == DocumentStatus.MISSING
        }
    }

    fun calculateCompletionPercentage(documents: List<DocumentItem>): Int {
        val requiredDocuments = documents.filter { it.isRequired }

        if (requiredDocuments.isEmpty()) {
            return 100
        }

        val completedDocuments = requiredDocuments.filter { document ->
            document.status == DocumentStatus.AVAILABLE ||
            document.status == DocumentStatus.UPLOADED ||
            document.status == DocumentStatus.IN_REVIEW
        }

        return ((completedDocuments.size.toDouble() / requiredDocuments.size.toDouble()) * 100).roundToInt()
    }

    fun isApplicationComplete(documents: List<DocumentItem>): Boolean {
        return getMissingRequiredDocuments(documents).isEmpty()
    }
}
