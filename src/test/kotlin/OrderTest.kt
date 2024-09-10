import org.example.Customer
import org.example.Order
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class OrderTest {

    @Test
    fun getTotalItems() {
        val customer = Customer(id = 1, name = "John Doe")
        val order = Order(orderId = 101, customer = customer, items = listOf("Apple", "Banana", "Orange"))

        val totalItems = order.getTotalItems()

        assertEquals(3, totalItems)
    }

    @Test
    fun getOrderSummary() {
        val customer = Customer(id = 1, name = "John Doe")
        val order = Order(orderId = 101, customer = customer, items = listOf("Apple", "Banana"))

        val summary = order.getOrderSummary()

        assertTrue(summary.contains("John Doe")
                && summary.contains("101")
                && summary.contains("2"))
    }
}