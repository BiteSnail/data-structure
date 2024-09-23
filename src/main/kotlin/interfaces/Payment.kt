package org.example.interfaces

import org.example.entities.BitcoinPayment
import org.example.entities.CreditCardPayment
import org.example.entities.MobilePayment
import org.example.entities.PayPalPayment

interface Payment {
    fun pay(amount: Double)

    companion object {
        fun create(type: String): Payment {
            return when (type) {
                "bitcoin" -> BitcoinPayment()
                "credit" -> CreditCardPayment()
                "paypal" -> PayPalPayment()
                "mobile" -> MobilePayment()
                else -> throw IllegalArgumentException("지원하지 않는 결제 방식입니다.")
            }
        }
    }
}