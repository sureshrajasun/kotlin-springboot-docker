package com.zenika.microservices.kotlinspringdemo.controller

import com.zenika.microservices.kotlinspringdemo.exception.AppException
import com.zenika.microservices.kotlinspringdemo.exception.CurrencyNotFoundException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler


@ControllerAdvice
class ControllerErrorHandler {

    @ExceptionHandler(CurrencyNotFoundException::class)
    fun handleCurrencyNotFoundException(e: CurrencyNotFoundException): ResponseEntity<String> {
        logger.error("CurrencyNotFoundException occurs.", e)
        return ResponseEntity("Currency Not Found.", HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(AppException::class)
    fun handleGeneralException(e: AppException): ResponseEntity<String> {
        logger.error("Exception occurs.", e)
        return ResponseEntity("Application Exception", HttpStatus.BAD_REQUEST)
    }

    companion object {

        private val logger = LoggerFactory.getLogger(ControllerErrorHandler::class.java)
    }

}