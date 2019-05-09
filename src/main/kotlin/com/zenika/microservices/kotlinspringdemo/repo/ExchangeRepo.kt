package com.zenika.microservices.kotlinspringdemo.repo

import com.zenika.microservices.kotlinspringdemo.model.ExchangeValue
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface ExchangeRepo : JpaRepository<ExchangeValue, Long> {

    fun findByCurrency(currency: String): Optional<ExchangeValue>
}