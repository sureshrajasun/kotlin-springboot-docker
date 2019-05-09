package com.zenika.microservices.kotlinspringdemo

import com.zenika.microservices.kotlinspringdemo.exception.AppException
import com.zenika.microservices.kotlinspringdemo.exception.CurrencyNotFoundException
import com.zenika.microservices.kotlinspringdemo.model.ExchangeValue
import com.zenika.microservices.kotlinspringdemo.repo.ExchangeRepo
import com.zenika.microservices.kotlinspringdemo.service.ExchangeService
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.util.*

import org.mockito.BDDMockito.given
import org.mockito.Mockito.`when`

@RunWith(SpringRunner::class)
@SpringBootTest
class KotlinSpringDemoApplicationTests {

	@Mock
	internal var exchangeValueRepository: ExchangeRepo? = null

	@InjectMocks
	private val exchangeService: ExchangeService? = null

	@Test
	fun sellSGD() {

		`when`(exchangeValueRepository!!.findByCurrency("USD")).thenReturn(Optional.of<ExchangeValue>(getExchangeValue()))
		val actualValue = 73.67025195226168
		val expectedValue = exchangeService!!.sellSGD("USD", "100")
		Assert.assertEquals(actualValue, expectedValue)

	}

	@Test
	fun buySGD() {

		`when`(exchangeValueRepository!!.findByCurrency("USD")).thenReturn(Optional.of<ExchangeValue>(getExchangeValue()))
		val actualValue = 133.92
		val expectedValue = exchangeService!!.buySGD("USD", "100")

		Assert.assertEquals(actualValue, expectedValue)
	}

	@Test(expected = CurrencyNotFoundException::class)
	fun shouldThrowCurrencyNotFoundException() {

		given(exchangeValueRepository!!.findByCurrency("ABC")).willReturn(Optional.empty<ExchangeValue>())
		exchangeService!!.buySGD("ABC", "100")
	}


	@Test(expected = AppException::class)
	fun shouldThrowAppException() {

		given(exchangeValueRepository!!.findByCurrency("USD")).willReturn(Optional.of<ExchangeValue>(getExchangeValue()))
		exchangeService!!.buySGD("USD", "100USD")
	}

	private fun getExchangeValue(): ExchangeValue {
		return ExchangeValue(1L, "USD",1.3392,1.3574)
	}
}
