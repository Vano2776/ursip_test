package com.ursip.testtask.service.impl

import com.ursip.testtask.database.repository.TestRepository
import com.ursip.testtask.dto.TestDto
import com.ursip.testtask.exception.TestNotFoundException
import com.ursip.testtask.mapping.refresh
import com.ursip.testtask.mapping.toDto
import com.ursip.testtask.mapping.toTest
import com.ursip.testtask.service.TestService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class TestServiceImpl(
    private val testRepository: TestRepository
): TestService {

    @Transactional
    override fun findAll(): List<TestDto> {
        return testRepository.findAll().map { it.toDto() }
    }

    @Transactional
    override fun findById(id: UUID): TestDto {
        return testRepository.findByIdOrNull(id)
            ?.toDto()
            ?: throw TestNotFoundException(id)
    }

    @Transactional
    override fun create(testDto: TestDto): TestDto {
        return testRepository.save(testDto.toTest()).toDto()
    }

    @Transactional
    override fun update(id: UUID, testDto: TestDto): TestDto {
        val test = testRepository.findByIdOrNull(id) ?: throw TestNotFoundException(id)
        return testRepository.save(test.refresh(testDto)).toDto()
    }

    @Transactional
    override fun delete(id: UUID) {
        val test = testRepository.findByIdOrNull(id) ?: throw TestNotFoundException(id)
        testRepository.delete(test)
    }
}