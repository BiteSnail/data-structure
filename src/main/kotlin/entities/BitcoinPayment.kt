package org.example.entities

import org.example.interfaces.Payment

class BitcoinPayment: Payment {
    override fun pay(amount: Double) {
        println("비트코인으로 $amount 원 결제하였습니다.")
    }
}