import org.example.Mapper
import org.example.NumberGenerator
import org.example.ParallelMapper
import org.example.SerialMapper
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.streams.asStream
import kotlin.system.measureTimeMillis

class MapperTest {
    private fun measureFourierProcessTime(fileName: String, mapper: Mapper): Long {
        return measureTimeMillis {
            File(fileName).useLines { lines ->
                mapper.fourier(lines.asStream().map { it.toLong() })
            }
        }
    }

    @Test
    @DisplayName("병렬 처리 vs 직렬 처리")
    fun parallelAndSerialProcess() {
        val fileName = "large_numbers.txt"
        val numSize = 100_000_000

        if (!File(fileName).exists()) {
            NumberGenerator.generateLargeFile(fileName, numSize)
        }
        val serialTime = measureFourierProcessTime(fileName, SerialMapper())
        val parallelTime = measureFourierProcessTime(fileName, ParallelMapper())
        println("SerialTime: $serialTime ms, parallelTime: $parallelTime ms")

        assertTrue(serialTime > parallelTime)
    }
}