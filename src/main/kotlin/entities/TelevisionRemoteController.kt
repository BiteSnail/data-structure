package org.example.entities

import org.example.constants.Code
import org.example.models.Signal

class TelevisionRemoteController(customCode: Code): RemoteController(customCode){
    override fun onClickPowerButton() {
        sendSignal(Signal(customCode = customCode, dataCode = Code.POWER))
    }

    override fun onClickUpButton() {
        sendSignal(Signal(customCode = customCode, dataCode = Code.UP))
    }

    override fun onClickDownButton() {
        sendSignal(Signal(customCode = customCode, dataCode = Code.DOWN))
    }

}