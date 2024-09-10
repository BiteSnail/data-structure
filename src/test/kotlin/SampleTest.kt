import org.example.Sample
import kotlin.test.Test
import kotlin.test.assertEquals

class SampleTest {
    private val testSample: Sample = Sample()

    @Test
    fun testSum() {
        val expectedSum = 12
        val a = 3
        val b = 9

        val actualSum = testSample.sum(a, b)

        assertEquals(expectedSum, actualSum)
    }

    @Test
    fun wrongAnswer() {
        val expectedSum = 12
        val a= 3
        val b = 8

        val actualSum = testSample.sum(a, b)

        assertEquals(expectedSum, actualSum)
    }
}