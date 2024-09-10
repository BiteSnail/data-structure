package org.example

class Order(val orderId: Int, val customer: Customer, val items: List<String>) {
    fun getTotalItems(): Int {
        return 0;
    }

    fun getOrderSummary(): String {
        return ""
    }
}