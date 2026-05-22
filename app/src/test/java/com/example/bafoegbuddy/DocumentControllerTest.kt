package com.example.bafoegbuddy

import com.example.bafoegbuddy.controller.DocumentController
import com.example.bafoegbuddy.model.DocumentItem
import com.example.bafoegbuddy.model.DocumentStatus
import org.junit.Assert.assertEquals
import org.junit.Test

class DocumentControllerTest {

    private val controller = DocumentController()

    @Test
    fun documentCanBeMarkedAsAvailable() {
        val document = DocumentItem(
            id = 1,
            applicationId = 1,
            name = "Immatrikulationsbescheinigung",
            status = DocumentStatus.MISSING,
            isRequired = true
        )

        val updatedDocument = controller.markAsAvailable(document)

        assertEquals(DocumentStatus.AVAILABLE, updatedDocument.status)
    }

    @Test
    fun documentCanBeMarkedAsUploaded() {
        val document = DocumentItem(
            id = 1,
            applicationId = 1,
            name = "Mietvertrag",
            status = DocumentStatus.AVAILABLE,
            isRequired = true
        )

        val updatedDocument = controller.markAsUploaded(document)

        assertEquals(DocumentStatus.UPLOADED, updatedDocument.status)
    }

    @Test
    fun documentCanBeMarkedAsMissing() {
        val document = DocumentItem(
            id = 1,
            applicationId = 1,
            name = "Einkommensnachweis Eltern",
            status = DocumentStatus.UPLOADED,
            isRequired = true
        )

        val updatedDocument = controller.markAsMissing(document)

        assertEquals(DocumentStatus.MISSING, updatedDocument.status)
    }

    @Test
    fun documentCanBeMarkedAsInReview() {
        val document = DocumentItem(
            id = 1,
            applicationId = 1,
            name = "Krankenversicherungsnachweis",
            status = DocumentStatus.UPLOADED,
            isRequired = true
        )

        val updatedDocument = controller.markAsInReview(document)

        assertEquals(DocumentStatus.IN_REVIEW, updatedDocument.status)
    }
}