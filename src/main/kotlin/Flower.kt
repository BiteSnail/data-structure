package org.example

class Flower(val color: Color) {
    var isBlooming: Boolean = false
    var hasBloomed: Boolean = false
    val canBear: Boolean
        get() = hasBloomed

    fun bloom(){
        if(hasBloomed){
            return
        }
        isBlooming = true
    }

    fun wither(){
        isBlooming = false
        hasBloomed = true
    }
}