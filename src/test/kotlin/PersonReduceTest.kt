import org.example.repositories.PersonRepository
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals

class PersonReduceTest {
    private val personRepository = PersonRepository();

    @Test
    @DisplayName("language가 Korean인 사람 중 가장 긴 이메일")
    fun longestEmail() {
        println("language가 Korean인 사람 중 가장 긴 이메일을 출력합니다.")
        println("filter, (map), reduce를 활용해 가장 긴 이메일을 출력하도록 합니다.")
        val expect = "mravenshearnn@istockphoto.com"
        val actual = personRepository.findAll().get(0).email
        assertEquals(expect, actual)
    }
}