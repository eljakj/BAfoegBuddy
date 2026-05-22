package com.example.bafoegbuddy.controller

import com.example.bafoegbuddy.model.DocumentItem
import com.example.bafoegbuddy.model.DocumentStatus

class DocumentController {

    fun markAsAvailable(document: DocumentItem): DocumentItem {
        return document.copy(status = DocumentStatus.AVAILABLE)
    }

    fun markAsUploaded(document: DocumentItem): DocumentItem {
        return document.copy(status = DocumentStatus.UPLOADED)
    }

    fun markAsMissing(document: DocumentItem): DocumentItem {
        return document.copy(status = DocumentStatus.MISSING)
    }

    fun markAsInReview(document: DocumentItem): DocumentItem {
        return document.copy(status = DocumentStatus.IN_REVIEW)
    }
}
