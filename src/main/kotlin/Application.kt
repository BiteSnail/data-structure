package org.example

import org.example.constants.Code
import org.example.entities.RemoteController

class Application {
    private val remoteControllers: MutableList<RemoteController> = mutableListOf()
    private var index: Int = 0

    private fun changeRemoteController() {
        index = (index + 1) % remoteControllers.size
    }

    fun addRemoteController(remoteController: RemoteController) {
        remoteControllers.add(remoteController)
    }

    fun onClickButton(code: Code) {
        when (code) {
            Code.POWER -> remoteControllers[index].onClickPowerButton()
            Code.UP -> remoteControllers[index].onClickUpButton()
            Code.DOWN -> remoteControllers[index].onClickDownButton()
            Code.CHANGE -> changeRemoteController()
            else -> return
        }
    }
}