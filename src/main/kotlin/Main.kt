package org.example

import org.example.constants.Code
import org.example.entities.AirConditioner
import org.example.entities.AirConditionerRemoteController
import org.example.entities.Television
import org.example.entities.TelevisionRemoteController


var application: Application? = null
var television:Television? = null
var airConditioner:AirConditioner? = null

fun timeGone() {
    television?.receiveSignal()
    airConditioner?.receiveSignal()
}

fun main(commands: List<Code>) {
    application = Application()
    television = Television(Code.LG)
    airConditioner = AirConditioner(Code.SAMSUNG)

    application?.addRemoteController(AirConditionerRemoteController(Code.SAMSUNG))
    application?.addRemoteController(TelevisionRemoteController(Code.LG))

    for (command in commands) {
        application?.onClickButton(command)
        timeGone()
    }
}