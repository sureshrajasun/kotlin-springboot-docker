package com.zenika.microservices.kotlinspringdemo.exception

class AppException(message: String) : RuntimeException(message) {
    companion object {

        private val serialVersionUID = -620418191145264127L
    }

}