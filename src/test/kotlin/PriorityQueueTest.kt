import org.example.entities.User
import org.junit.jupiter.api.DisplayName
import java.time.LocalDateTime
import java.util.*
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertTrue

class PriorityQueueTest {
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

    private fun assertUserTest(users: PriorityQueue<User>, testFun: (User, User) -> Boolean) {
        var cur = users.remove()
        while (!users.isEmpty()) {
            val next = users.remove()
            assertTrue(testFun(cur, next))
            cur = next
        }
    }

    @Test
    @DisplayName("ID를 기준으로 내림차순")
    fun sortByIdDescendingTest() {
        //Hint. 생성자에 Comparator를 생성하세요.
        val queue = PriorityQueue<User>()

        queue.addAll(createUsers(100))

        assertUserTest(queue, { o1, o2 -> o1.id > o2.id })
    }

    @Test
    @DisplayName("updatedAt을 기준으로 오름차순")
    fun compareByUserNameDescendingAndUpdatedAtAscendingTest() {
        //Hint. 생성자에 Comparator를 생성하세요.
        val queue = PriorityQueue<User>()

        queue.addAll(createUsers(200))

        assertUserTest(queue, { o1, o2 -> o1.updateAt < o2.updateAt })
    }

    @Test
    @DisplayName("username을 기준으로 내림차순, 만약 같다면 updatedAt을 기준으로 오름차순")
    fun priorityQueueTest() {
        //Hint. 생성자에 Comparator를 생성하세요.
        val queue = PriorityQueue<User>()

        queue.addAll(createUsers(300))

        assertUserTest(
            queue,
            { o1, o2 -> if (o1.name == o2.name) o1.updateAt < o2.updateAt else o1.name > o2.name })
    }
}