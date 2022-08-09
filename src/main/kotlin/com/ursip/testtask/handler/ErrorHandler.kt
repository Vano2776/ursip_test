package com.ursip.testtask.handler

import com.ursip.testtask.exception.BaseException
import com.ursip.testtask.exception.RestError
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ErrorHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler(BaseException::class)
    fun handleBaseException(e: BaseException): ResponseEntity<RestError> {
        return ResponseEntity(e.restError, e.httpStatus)
    }
}