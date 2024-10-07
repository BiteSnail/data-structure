import org.example.main
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertEquals

fun captureOutput(block: () -> Unit): String {
    val outputStream = ByteArrayOutputStream()
    val printStream = PrintStream(outputStream)
    val oldOut = System.out

    try {
        System.setOut(printStream)
        block()
    } finally {
        System.setOut(oldOut)
    }

    return outputStream.toString().trim()
}

class DataServiceTest {
    @Test
    @DisplayName("빈 문자열 에러 체크")
    fun emptyStringTest() {
        val data = listOf("BOB", "JANE", "SAM", "KIM", "LEE", "")
        val key = "LEE"

        assertThrows<IllegalArgumentException> { main(data, key) }
    }

    @Test
    @DisplayName("정상 조회 테스트")
    fun okStringTest() {
        val data = listOf("BOB", "JANE", "SAM", "KIM", "LEE")
        val key = "BOB"

        val output = captureOutput { main(data, key) }

        assertEquals("BOB", output)
    }

    @Test
    @DisplayName("비정상 조회 테스트")
    fun errorStringTest() {
        val data = listOf("BOB", "JANE", "SAM", "KIM", "LEE")
        val key = "BAK"

        val output = captureOutput { main(data, key) }

        assertEquals("Not found", output)
    }
}