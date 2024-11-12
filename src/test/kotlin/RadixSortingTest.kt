import org.example.utils.lexicographicalSort
import org.example.utils.radixSort
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RadixSortingTest {
    @Test
    @DisplayName("LSD 기수 정렬")
    fun testRadixSort() {
        val list = mutableListOf(170, 45, 75, 90, 802, 24, 2, 66)
        list.radixSort()
        println("Sorted array: ${list.joinToString { it.toString() }}")
    }

    @Test
    @DisplayName("MSD 기수 정렬")
    fun testMSDRadixSort() {
        val list = mutableListOf(170, 45, 75, 90, 802, 24, 2, 66)
        list.lexicographicalSort()
        println("Sorted array: ${list.joinToString { it.toString() }}")
    }
}