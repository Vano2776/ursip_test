package com.ursip.testtask.exception

import org.springframework.http.HttpStatus
import java.util.UUID

class TestNotFoundException(id: UUID): BaseException(
    HttpStatus.NOT_FOUND,
    RestError(description = "Test not fund with id = $id")
)