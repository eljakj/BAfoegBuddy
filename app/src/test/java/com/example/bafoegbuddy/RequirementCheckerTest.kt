package com.example.bafoegbuddy

import com.example.bafoegbuddy.controller.RequirementChecker
import com.example.bafoegbuddy.model.DocumentItem
import com.example.bafoegbuddy.model.DocumentStatus
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class RequirementCheckerTest {

    private val checker = RequirementChecker()

    @Test
    fun missingRequiredDocuments_areDetectedCorrectly() {
        val documents = listOf(
            DocumentItem(
                id = 1,
                applicationId = 1,
                name = "Immatrikulationsbescheinigung",
                status = DocumentStatus.UPLOADED,
                isRequired = true
            ),
            DocumentItem(
                id = 2,
                applicationId = 1,
                name = "Einkommensnachweis Eltern",
                status = DocumentStatus.MISSING,
                isRequired = true
            ),
            DocumentItem(
                id = 3,
                applicationId = 1,
                name = "Optionales Dokument",
                status = DocumentStatus.MISSING,
                isRequired = false
            )
        )

        val missingDocuments = checker.getMissingRequiredDocuments(documents)

        assertEquals(1, missingDocuments.size)
        assertEquals("Einkommensnachweis Eltern", missingDocuments[0].name)
    }

    @Test
    fun completionPercentage_isCalculatedCorrectly() {
        val documents = listOf(
            DocumentItem(
                id = 1,
                applicationId = 1,
                name = "Immatrikulationsbescheinigung",
                status = DocumentStatus.UPLOADED,
                isRequired = true
            ),
            DocumentItem(
                id = 2,
                applicationId = 1,
                name = "Mietvertrag",
                status = DocumentStatus.AVAILABLE,
                isRequired = true
            ),
            DocumentItem(
                id = 3,
                applicationId = 1,
                name = "Einkommensnachweis Eltern",
                status = DocumentStatus.MISSING,
                isRequired = true
            )
        )

        val percentage = checker.calculateCompletionPercentage(documents)

        assertEquals(67, percentage)
    }

    @Test
    fun applicationIsComplete_whenNoRequiredDocumentIsMissing() {
        val documents = listOf(
            DocumentItem(
                id = 1,
                applicationId = 1,
                name = "Immatrikulationsbescheinigung",
                status = DocumentStatus.UPLOADED,
                isRequired = true
            ),
            DocumentItem(
                id = 2,
                applicationId = 1,
                name = "Mietvertrag",
                status = DocumentStatus.AVAILABLE,
                isRequired = true
            )
        )

        val isComplete = checker.isApplicationComplete(documents)

        assertTrue(isComplete)
    }

    @Test
    fun applicationIsNotComplete_whenRequiredDocumentIsMissing() {
        val documents = listOf(
            DocumentItem(
                id = 1,
                applicationId = 1,
                name = "Immatrikulationsbescheinigung",
                status = DocumentStatus.UPLOADED,
                isRequired = true
            ),
            DocumentItem(
                id = 2,
                applicationId = 1,
                name = "Einkommensnachweis Eltern",
                status = DocumentStatus.MISSING,
                isRequired = true
            )
        )

        val isComplete = checker.isApplicationComplete(documents)

        assertFalse(isComplete)
    }
}