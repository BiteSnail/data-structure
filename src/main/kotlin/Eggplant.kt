package org.example

class Eggplant {
    private var nutrients: Int = 0
    var flower: Flower? = null
    var fruit: Fruit? = null

    fun storeNutrients(nutrients: Int) {
        this.nutrients = nutrients
    }

    fun makeFlower() {
        if(nutrients >= 5){
            flower = Flower(Color.Purple)
            nutrients -= 5
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
        fruit = Fruit(Color.Purple, Shape.Long)
    }
}