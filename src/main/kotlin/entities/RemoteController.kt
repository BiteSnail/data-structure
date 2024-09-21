package org.example.entities

import org.example.models.Signal

abstract class RemoteController {
    abstract fun sendSignal(signal: Signal)
    abstract fun onClickPowerButton()
    abstract fun onClickUpButton()
    abstract fun onClickDownButton()
}