package org.example

import org.example.interfaces.Payment

fun main() {
    println("결제 수단을 입력해 주세요.")
    val type = readln()

    val payment = Payment.create(type)

    payment.pay(11111.0)
}