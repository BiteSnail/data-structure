package org.example.entities

import org.example.constants.Code
import org.example.objects.Air

class Television(private val customCode: Code) {
    private val maxChannel: Int = 999
    private val defaultChannel: Int = 1
    private var channel: Int = defaultChannel
    private var turnOn: Boolean = false

    private fun turnOnOrOff() {
        turnOn = !turnOn
    }

    private fun channelUp() {
        if(channel+1 > maxChannel) {
            channel = defaultChannel
            return
        }
        channel++
    }

    private fun channelDown() {
        if(channel-1 < defaultChannel){
            channel = maxChannel
            return
        }
        channel--
    }

    fun receiveSignal() {
        if((Air.waves.peek()?.customCode ?: Code.NONE) != customCode){
            return
        }
        val signal = Air.waves.peek()
        when (signal.dataCode) {
            Code.POWER -> turnOnOrOff()
            Code.UP -> channelUp()
            Code.DOWN -> channelDown()
            else -> return
        }
    }

    fun getChannelInfo(): String {
        return "현재 채널은 ${channel}번 입니다."
    }
}