package com.zenika.microservices.kotlinspringdemo.service

import com.zenika.microservices.kotlinspringdemo.exception.AppException
import com.zenika.microservices.kotlinspringdemo.exception.CurrencyNotFoundException
import com.zenika.microservices.kotlinspringdemo.model.ExchangeValue
import com.zenika.microservices.kotlinspringdemo.repo.ExchangeRepo
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class ExchangeService {
    private val logger = LoggerFactory.getLogger(ExchangeService::class.java)

    @Autowired
    lateinit var repository: ExchangeRepo

    @Throws(CurrencyNotFoundException::class)
    fun buySGD(currency: String, value: String): Double? {

        val exchangeValue = getCurrency(currency)
        logger.debug(" Exchange value object : {}", exchangeValue.toString())
        val currValue = getCurrencyValue(value)
        val conversionRate: Double
        conversionRate = currValue * exchangeValue.buy

        logger.debug(" Convert from {} {} to SGD you will get : {} SGD", currency, value, conversionRate)
        return conversionRate
    }

    @Throws(CurrencyNotFoundException::class)
    fun sellSGD(currency: String, value: String): Double? {

        val exchangeValue = getCurrency(currency)
        logger.debug(" Exchange value object : {}", exchangeValue.toString())

        val currValue = getCurrencyValue(value)
        val conversionRate: Double?
        conversionRate = currValue / exchangeValue.sell

        logger.debug(" Convert from SGD {} to {} you will get : {} ", value, currency, conversionRate)

        return conversionRate

    }

    private fun getCurrencyValue(value: String): Double {
        try {
            return java.lang.Double.parseDouble(value)
        } catch (e: NumberFormatException) {
            throw AppException(String.format("Currency value %s is invalid.", value))
        }

    }

    private fun getCurrency(currency: String): ExchangeValue {
        val exchangeValueOptional = repository.findByCurrency(currency)
        return if (exchangeValueOptional.isPresent()) {
            exchangeValueOptional.get()
        } else {
            throw CurrencyNotFoundException(String.format("'%s' Currency Not Found.", currency))
        }
    }


}