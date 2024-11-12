import org.example.utils.mergeSort
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MergeSortingTest {
    @Test
    @DisplayName("머지 소트 테스트")
    fun testMergeSort() {
        val list = listOf(4, 7, 1, 3, 2, 6, 5)
        val sortedList = list.mergeSort()
        assert(sortedList == listOf(1, 2, 3, 4, 5, 6, 7))
    }

}