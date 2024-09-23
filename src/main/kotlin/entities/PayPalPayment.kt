package org.example.entities

import org.example.interfaces.Payment

class PayPalPayment: Payment {
    override fun pay(amount: Double) {
        println("PayPal로 $amount 원 결제하였습니다.")
    }
}