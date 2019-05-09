package com.zenika.microservices.kotlinspringdemo.exception

class CurrencyNotFoundException(message: String) : RuntimeException(message) {
    companion object {
        private val serialVersionUID = -6204181911452576422L
    }

}
