package org.example.entities

import org.example.models.Signal
import org.example.objects.Air
import org.example.constants.Code

abstract class RemoteController(protected val customCode: Code) {
    protected fun sendSignal(signal: Signal) {
        Air.waves.add(signal)
    }
    abstract fun onClickPowerButton()
    abstract fun onClickUpButton()
    abstract fun onClickDownButton()
}