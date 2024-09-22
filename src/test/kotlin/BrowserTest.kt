import org.example.Browser
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("브라우저 테스트")
class BrowserTest {
    private lateinit var browser: Browser

    @BeforeEach
    fun setUp() {
        browser = Browser()
    }

    @Test
    @DisplayName("사이트 접속 테스트")
    fun testVisitAndGetCurrentPage() {
        browser.visit("A")
        browser.visit("B")

        val actualValue = browser.getCurrentPage()

        assertEquals("B", actualValue)
    }

    @Test
    @DisplayName("뒤로가기 테스트")
    fun testGoBack() {
        browser.visit("A")
        browser.visit("B")
        browser.visit("C")

        val actualGoBackValue = browser.goBack()
        val actualValue = browser.getCurrentPage()

        assertEquals("B", actualGoBackValue)
        assertEquals("B", actualValue)
    }

    @Test
    @DisplayName("앞으로가기 테스트")
    fun testGoForward() {
        browser.visit("A")
        browser.visit("B")
        browser.visit("C")

        val actualGoBackValue = browser.goBack()
        val actualGoForwardValue = browser.goForward()
        val actualValue = browser.goForward()

        assertEquals("B", actualGoBackValue)
        assertEquals("C", actualGoForwardValue)
        assertEquals("C", actualValue)
    }

    @Test
    @DisplayName("뒤로간 후 새로운 사이트 방문")
    fun testGoBackAndVisit() {
        browser.visit("A")
        browser.visit("B")

        browser.goBack()
        browser.visit("C")

        val actualGoForwardValue = browser.goForward()
        val actualValue = browser.getCurrentPage()

        assertEquals("C", actualValue)
        assertEquals(null, actualGoForwardValue)
    }
}