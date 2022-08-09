package com.ursip.testtask.exception

import org.springframework.http.HttpStatus
import java.lang.RuntimeException

abstract class BaseException(
    val httpStatus: HttpStatus,
    val restError: RestError
): RuntimeException(restError.description)