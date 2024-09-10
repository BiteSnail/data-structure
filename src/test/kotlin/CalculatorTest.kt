import org.example.Calculator
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CalculatorTest {
    private var a: Int = 0
    private var b: Int = 0

    @BeforeAll
    fun init() {
        a = 3
        b = 6
    }

    @Test
    fun add() {
        val expectedValue = 9

        val actualValue = Calculator().add(a, b)

        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun subtract() {
        val expectedValue = -3

        val actualValue = Calculator().subtract(a, b)

        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun multiply() {
        val expectedValue = 18

        val actualValue = Calculator().multiply(a, b)

        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun divide() {
        val expectedValue = 0

        val actualValue = Calculator().divide(a, b)

        assertEquals(expectedValue, actualValue)
    }
}