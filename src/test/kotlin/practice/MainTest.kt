package practice

import org.example.airConditioner
import org.example.constants.Code
import org.example.main
import org.example.television
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

@DisplayName("통합 테스트")
class MainTest {
    @Test
    @DisplayName("리모컨 전환 테스트: 1번")
    fun changeRemoteControllerTest() {
        val commands = listOf(Code.CHANGE, Code.POWER, Code.UP)

        main(commands)

        assertTrue(television?.getChannelInfo()?.contains("2") ?: false)
    }

    @Test
    @DisplayName("리모컨 전환 테스트 2: 여러번")
    fun manyChangeRemoteControllerTest() {
        val commands = listOf(Code.CHANGE, Code.CHANGE, Code.CHANGE, Code.POWER, Code.UP)

        main(commands)

        assertTrue(television?.getChannelInfo()?.contains("2") ?: false)
    }

    @Test
    @DisplayName("온도조절")
    fun temperatureControllerTest() {
        val commands = listOf(Code.POWER, Code.UP, Code.UP)

        main(commands)

        assertTrue(airConditioner?.getTargetTemperatureInfo()?.contains("28.0") ?: false)
    }

    @Test
    @DisplayName("채널조절")
    fun channelControllerTest() {
        val commands = listOf(Code.CHANGE, Code.POWER, Code.DOWN, Code.DOWN)

        main(commands)

        assertTrue(television?.getChannelInfo()?.contains("998") ?: false)
    }
}