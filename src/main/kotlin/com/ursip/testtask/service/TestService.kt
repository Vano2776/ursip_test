package com.ursip.testtask.service

import com.ursip.testtask.dto.TestDto
import java.util.UUID

interface TestService {

    fun findAll(): List<TestDto>

    fun findById(id: UUID): TestDto

    fun create(testDto: TestDto): TestDto

    fun update(id: UUID, testDto: TestDto): TestDto

    fun delete(id: UUID)
}