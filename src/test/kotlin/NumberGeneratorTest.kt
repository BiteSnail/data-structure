import org.example.NumberGenerator
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class NumberGeneratorTest {
    @Test
    @DisplayName("랜덤 숫자 생성갯수 확인")
    fun generateNumberTest() {
        val fileName = "sample_number.txt"
        val numSize = 1_000

        NumberGenerator.generateLargeFile(fileName, numSize)

        File(fileName).useLines { lines ->
            assertEquals(numSize, lines.count())
        }
    }
}