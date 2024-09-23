package org.example

import org.example.entities.BitcoinPayment
import org.example.entities.CreditCardPayment
import org.example.entities.PayPalPayment

fun main() {
    println("결제 수단을 입력해 주세요.")
    val type = readln()

    // TODO(적절한 Payment 구체화 객체를 생성하는 로직을 별도의 팩토리 클래스로 만들어 보자.)
    val payment = when (type) {
        "bitcoin" -> BitcoinPayment()
        "paypal" -> PayPalPayment()
        "credit" -> CreditCardPayment()
        else -> throw IllegalArgumentException("지원하지 않는 결제 방식입니다.")
    }

    payment?.pay(11111.0) ?: "잘못된 접근입니다."
}