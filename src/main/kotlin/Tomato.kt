package org.example

class Tomato {
    private var nutrients: Int = 0
    var flower: Flower? = null
    var fruit: Fruit? = null

    fun storeNutrients(nutrients: Int) {
        this.nutrients += nutrients
    }

    fun makeFlower() {
        if(nutrients >= 10){
            flower = Flower(Color.Yellow)
            nutrients -= 10
        }
    }

    fun bloomFlower() {
        flower?.bloom()
    }

    fun witherFlower() {
        flower?.wither()
    }

    fun makeFruit() {
        if(flower?.canBear != true){
            return
        }
        flower = null
        fruit = Fruit(Color.Red, Shape.Round)
    }
}