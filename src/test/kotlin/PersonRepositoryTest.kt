import org.example.repositories.PersonRepository
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals

class PersonRepositoryTest {
    private val personRepository = PersonRepository()

    @Test
    @DisplayName("전체 사람 데이터 개수 테스트")
    fun allCountTest(){
        println("초기 사람 데이터의 개수 테스트 중")
        assertEquals(1_000, personRepository.findAll().count())
        println("성공")
    }

    @Test
    @DisplayName("성별이 Male이 아닌 데이터 개수 테스트")
    fun notMaleTest(){
        println("성별이 Male이 아닌 데이터의 개수를 테스트합니다.")
        println("filter 를 활용하여 gender가 Male이 아닌 데이터의 개수를 출력하도록 합니다.")
        assertEquals(525, personRepository.findAll().count())
    }

    @Test
    @DisplayName("IP ADDRESS가 111로 시작하는 데이터 개수 테스트")
    fun ipaddressTest(){
        println("IP ADDRESS가 111로 시작하는 데이터의 개수를 테스트합니다.")
        println("filter 를 활용하여 ip가 111로 시작하는 데이터의 개수를 출력하도록 합니다.")
        assertEquals(5, personRepository.findAll().count())
    }

    @Test
    @DisplayName("언어가 Korean이나 English인 데이터 개수 테스트")
    fun languageCountTest(){
        println("language가 Korean이나 English인 데이터의 개수를 테스트합니다.")
        println("filter 를 활용하여 language가 Korean이나 English인 데이터의 개수를 출력하도록 합니다.")
        assertEquals(24, personRepository.findAll().count())
    }

    @Test
    @DisplayName("ip_address가 123으로 시작하고 email이 .com으로 끝나는 데이터 개수 테스트")
    fun ipaddressAndEmailCountTest(){
        println("ip_address가 123으로 시작하고 email이 .com으로 끝나는 데이터의 개수를 테스트합니다.")
        println("filter 를 활용하여 ip_address가 123으로 시작하고 email이 .com으로 끝나는 데이터의 개수를 출력하도록 합니다.")
        assertEquals(2, personRepository.findAll().count())
    }
}