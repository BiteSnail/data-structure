import org.example.Color
import org.example.Tomtato
import org.example.Shape
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test

class TomtatoTest {
    @Test
    @DisplayName("톰테이토 꽃 만들기 실패 테스트")
    fun TomtatoMakeFailFlowerTest() {
        val tomtato = Tomtato()

        tomtato.storeNutrients(7)
        tomtato.makeFlower()

        assertNull(tomtato.flower)
    }

    @Test
    @DisplayName("톰테이토 꽃 만들기 성공 테스트")
    fun TomtatoMakeFlowerTest() {
        val tomtato = Tomtato()

        tomtato.storeNutrients(8)
        tomtato.makeFlower()

        assertNotNull(tomtato.flower)
    }

    @Test
    @DisplayName("톰테이토 꽃 피우기 테스트")
    fun TomtatoBloomTest() {
        val tomtato = Tomtato()

        tomtato.storeNutrients(8)
        tomtato.makeFlower()
        tomtato.bloomFlower()

        assertFalse(tomtato.flower!!.hasBloomed)
    }

    @Test
    @DisplayName("톰테이토 열매 맺기 실패 테스트")
    fun TomtatoBearFailTest() {
        val tomtato = Tomtato()

        tomtato.storeNutrients(8)
        tomtato.makeFlower()
        tomtato.bloomFlower()
        tomtato.makeFruit()

        assertNull(tomtato.fruit)
    }

    @Test
    @DisplayName("톰테이토 열매 맺기 테스트")
    fun TomtatoBearTest() {
        val tomtato = Tomtato()

        tomtato.storeNutrients(8)
        tomtato.makeFlower()
        tomtato.bloomFlower()
        tomtato.witherFlower()
        tomtato.makeFruit()

        assertNotNull(tomtato.fruit)
    }

    @Test
    @DisplayName("톰테이토 열매 색깔 및 모양 테스트")
    fun TomtatoFruitTest(){
        val tomtato = Tomtato()

        tomtato.storeNutrients(8)
        tomtato.makeFlower()
        tomtato.bloomFlower()
        tomtato.witherFlower()
        tomtato.makeFruit()

        assertEquals(Color.Purple, tomtato.fruit!!.color)
        assertEquals(Shape.Long, tomtato.fruit!!.shape)
    }

    @Test
    @DisplayName("톰테이토 꽃 색깔 테스트")
    fun TomtatoFlowerTest(){
        val tomtato = Tomtato()

        tomtato.storeNutrients(8)
        tomtato.makeFlower()
        tomtato.bloomFlower()

        assertEquals(Color.Purple, tomtato.flower!!.color)
    }
}
