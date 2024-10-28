import entities.UserComparator
import org.example.entities.User
import org.junit.jupiter.api.DisplayName
import java.time.LocalDateTime
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertTrue

class ComparatorTest {
    private fun createUsers(count: Int): List<User> {
        return (0 until count).map {
            val randId = Random.nextLong(1, Long.MAX_VALUE)
            User(
                randId,
                "user${randId}",
                updateAt = LocalDateTime.now().plusNanos(randId)
            )
        }
    }

    private fun assertUserTest(users: List<User>, testFun: (User, User) -> Boolean) {
        (1 until users.size).forEach { idx ->
            assertTrue(testFun(users[idx - 1], users[idx]))
        }
    }

    @Test
    @DisplayName("ID를 기준으로 오름차순")
    fun sortByIdDescendingTest() {
        var users = createUsers(100)

        //Hint. sortedBy()의 매개변수는?
        //users = users.sortedBy()

        assertUserTest(users, { o1, o2 -> o1.id < o2.id })
    }

    @Test
    @DisplayName("updateAt을 기준으로 내림차순")
    fun sortByUpdateAtDescendingTest() {
        var users = createUsers(200)

        //Hint. sortedWith()에서 내림차순을 위해서는?
        //users = users.sortedWith()

        assertUserTest(users, { o1, o2 -> o1.updateAt > o2.updateAt })
    }

    @Test
    @DisplayName("updateAt을 기준으로 내림차순, 만약 updatedAt이 같으면 ID를 기준으로 오름차순")
    fun compareByUpdateAtDescendingAndIdAscendingTest() {
        var users = createUsers(300)

        //Hint. UserComparator의 compare 정의하기
        users = users.sortedWith(UserComparator)

        assertUserTest(
            users,
            { o1, o2 -> if (o1.updateAt == o2.updateAt) o1.id < o2.id else o1.updateAt > o2.updateAt })
    }
}