package org.example

class Pepper {
    private var nutrients: Int = 0
    var flower: Flower? = null
    var fruit: Fruit? = null

    fun storeNutrients(nutrients: Int) {
        this.nutrients = nutrients
    }

    fun makeFlower() {
        if(nutrients >= 7){
            flower = Flower(Color.White)
            nutrients -= 7
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
        fruit = Fruit(Color.Red, Shape.Long)
    }
}