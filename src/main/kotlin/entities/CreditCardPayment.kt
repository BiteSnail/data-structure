package org.example.entities

import org.example.interfaces.Payment

class CreditCardPayment: Payment {
    override fun pay(amount: Double) {
        println("신용카드로 $amount 원 결제하였습니다.")
    }
}