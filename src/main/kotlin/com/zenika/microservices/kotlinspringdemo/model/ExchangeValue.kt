package com.zenika.microservices.kotlinspringdemo.model

import javax.persistence.*


@Entity
@Table(name="ExchangeValue")
data class ExchangeValue (

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = -1,

        @Column
        var currency: String = "",

        @Column
        var buy: Double = 0.0,

        @Column
        var sell: Double = 0.0

)