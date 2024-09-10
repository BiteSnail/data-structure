import org.example.Color
import org.example.Eggplant
import org.example.Shape
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import kotlin.test.Test

class EggplantTest {
    @Test
    @DisplayName("가지꽃 만들기 실패 테스트")
    fun eggPlantMakeFailFlowerTest() {
        val eggplant = Eggplant()

        eggplant.storeNutrients(4)
        eggplant.makeFlower()

        assertNull(eggplant.flower)
    }

    @Test
    @DisplayName("가지꽃 만들기 성공 테스트")
    fun eggPlantMakeFlowerTest() {
        val eggplant = Eggplant()

        eggplant.storeNutrients(5)
        eggplant.makeFlower()

        assertNotNull(eggplant.flower)
    }

    @Test
    @DisplayName("가지꽃 피우기 테스트")
    fun eggPlantBloomTest() {
        val eggplant = Eggplant()

        eggplant.storeNutrients(5)
        eggplant.makeFlower()
        eggplant.bloomFlower()

        assertFalse(eggplant.flower!!.hasBloomed)
    }

    @Test
    @DisplayName("가지 열매 맺기 실패 테스트")
    fun eggPlantBearFailTest() {
        val eggplant = Eggplant()

        eggplant.storeNutrients(5)
        eggplant.makeFlower()
        eggplant.bloomFlower()
        eggplant.makeFruit()

        assertNull(eggplant.fruit)
    }

    @Test
    @DisplayName("가지 열매 맺기 테스트")
    fun eggPlantBearTest() {
        val eggplant = Eggplant()

        eggplant.storeNutrients(5)
        eggplant.makeFlower()
        eggplant.bloomFlower()
        eggplant.witherFlower()
        eggplant.makeFruit()

        assertNotNull(eggplant.fruit)
    }

    @Test
    @DisplayName("가지 열매 색깔 및 모양 테스트")
    fun eggPlantFruitTest(){
        val eggplant = Eggplant()

        eggplant.storeNutrients(5)
        eggplant.makeFlower()
        eggplant.bloomFlower()
        eggplant.witherFlower()
        eggplant.makeFruit()

        assertEquals(Color.Purple, eggplant.fruit!!.color)
        assertEquals(Shape.Long, eggplant.fruit!!.shape)
    }

    @Test
    @DisplayName("가지 꽃 색깔 테스트")
    fun eggPlantFlowerTest(){
        val eggplant = Eggplant()

        eggplant.storeNutrients(5)
        eggplant.makeFlower()
        eggplant.bloomFlower()

        assertEquals(Color.Purple, eggplant.flower!!.color)
    }
}
