package com.ursip.testtask.controller

import com.ursip.testtask.dto.TestDto
import com.ursip.testtask.service.TestService
import com.ursip.testtask.service.impl.TestServiceImpl
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/test")
class TestController(
    private val testService: TestService
) {

    @GetMapping
    fun findAll(): List<TestDto> {
        return testService.findAll()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: UUID): TestDto {
        return testService.findById(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody testDto: TestDto): TestDto{
        return testService.create(testDto)
    }

    @PatchMapping("/{id}")
    fun update(@PathVariable("id") id: UUID, @RequestBody testDto: TestDto): TestDto {
        return testService.update(id, testDto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete (@PathVariable("id") id: UUID) {
        return testService.delete(id)
    }
}