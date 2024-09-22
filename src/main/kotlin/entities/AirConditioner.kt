package org.example.entities

import org.example.constants.Code
import org.example.objects.Air

class AirConditioner(private val customCode: Code) {
    private val defaultTargetTemperature: Double = 26.0
    private val maxTargetTemperature: Double = 40.0
    private val minTargetTemperature: Double = 10.0
    private var targetTemperature: Double = defaultTargetTemperature
    private var isCelsius: Boolean = true
    private var turnOn: Boolean = false

    private fun turnOnOrOff() {
        turnOn = !turnOn
    }

    private fun targetTemperatureUp() {
        if(targetTemperature+1 > maxTargetTemperature) {
            return
        }
        targetTemperature++
    }

    private fun targetTemperatureDown() {
        if(targetTemperature-1 < minTargetTemperature) {
            return
        }
        targetTemperature--
    }

    fun receiveSignal() {
        if((Air.waves.peek()?.customCode ?: Code.NONE) != customCode){
            return
        }
        val signal = Air.waves.peek()
        when (signal.dataCode) {
            Code.POWER -> turnOnOrOff()
            Code.UP -> targetTemperatureUp()
            Code.DOWN -> targetTemperatureDown()
            else -> return
        }
    }

    fun getTargetTemperatureInfo(): String {
        return "현재 설정 온도는 ${if (isCelsius) "섭씨" else "화씨"} ${targetTemperature}도 입니다."
    }
}