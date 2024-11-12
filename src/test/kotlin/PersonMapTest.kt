import org.example.repositories.PersonRepository
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test
import kotlin.test.assertEquals

class PersonMapTest {
    private val personRepository = PersonRepository()

    @Test
    @DisplayName("first_name이 John으로 시작하는 사람들의 email 주소들")
    fun firstNameLikeJohnsEmails(){
        println("first_name이 John으로 시작하는 사람들의 email 주소들을 출력합니다.")
        println("map과 filter 를 활용하여 first_name이 John으로 시작하는 사람들의 email 주소들을 출력하도록 합니다.")
        val expect: List<String> = listOf("jplace66@youku.com", "jkenninghamgi@rambler.ru");
        assertArrayEquals(expect.toTypedArray(), personRepository.findAll().toTypedArray())
    }

    @Test
    @DisplayName("last_name이 Leete인 사람들의 full name")
    fun lastNameLeetesFullname(){
        println("last_name이 Leete인 사람들의 full name을 출력합니다.")
        println("map과 filter 를 활용하여 last_name이 Leete인 사람들의 full name을 출력하도록 합니다.")
        println("fullname이란 {first_name last_name}을 의미합니다.(가운데에 띄워쓰기)")
        val expect: List<String> = listOf("Had Leete", "Amby Leete");
        assertArrayEquals(expect.toTypedArray(), personRepository.findAll().toTypedArray())
    }

    @Test
    @DisplayName("language가 Korean인 사람들의 성별이 Male인지 여부")
    fun languageKoreanMale(){
        println("language가 Korean인 사람들의 성별이 Male인지 여부를 출력합니다.")
        println("map과 filter 를 활용하여 language가 Korean인 사람들의 성별이 Male인지 여부를 출력합니다.")
        val except: List<Boolean> = listOf(false, true, true, true, false, true, true)
        assertArrayEquals(except.toTypedArray(), personRepository.findAll().toTypedArray())
    }

}