package com.zenika.microservices.kotlinspringdemo.controller

import com.zenika.microservices.kotlinspringdemo.service.ExchangeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
class ExchangeController {

    @Autowired
    lateinit var service: ExchangeService

    @GetMapping("/currency-exchange/buySGD/{currency}/value/{value}")
    fun buySGD(@PathVariable currency: String, @PathVariable value: String): String {

        return " Convert from " + currency + " " + value + " to SGD you will get : " +
                service.buySGD(currency, value) + " SGD."

    }

    @GetMapping("/currency-exchange/sellSGD/{currency}/value/{value}")
    fun sellSGD(@PathVariable currency: String, @PathVariable value: String): String {

        return " Convert from SGD " + value + " to " + currency + " you will get : " +
                "" + service.sellSGD(currency, value) + " " + currency

    }


}