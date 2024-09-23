package org.example.interfaces

import org.example.entities.BitcoinPayment
import org.example.entities.CreditCardPayment
import org.example.entities.PayPalPayment

interface Payment {
    fun pay(amount: Double)

    // TODO("Payment를 상속받는 새로운 결제 방식 MobilePayment를 생성해보자")
    companion object {
        fun create(type: String): Payment {
            return when (type) {
                "bitcoin" -> BitcoinPayment()
                "credit" -> CreditCardPayment()
                "paypal" -> PayPalPayment()
                else -> throw IllegalArgumentException("지원하지 않는 결제 방식입니다.")
            }
        }
    }
}