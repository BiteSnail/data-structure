import org.example.constants.Code
import org.example.models.Signal
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class SignalTest {
    @Test
    fun testSignal() {
        val customCode: Code = Code.SAMSUNG
        val dataCode: Code = Code.POWER

        val sample = Signal(customCode, dataCode)

        assertTrue(sample.toString().contains(customCode.code)
                || sample.toString().contains(dataCode.code))
    }
}