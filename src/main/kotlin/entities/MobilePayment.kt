package org.example.entities

import org.example.interfaces.Payment

class MobilePayment: Payment {
    override fun pay(amount: Double) {
        println("모바일로 $amount 원 결제하였습니다.")
    }
}