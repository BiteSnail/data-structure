package org.example

class Potato {
    private var nutrients: Int = 0
    var flower: Flower? = null
    var fruit: Fruit? = null

    fun storeNutrients(nutrients: Int) {
        this.nutrients += nutrients
    }

    fun makeFlower() {
        if(nutrients >= 2){
            flower = Flower(Color.Ivory)
            nutrients -= 2
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
        fruit = Fruit(Color.Green, Shape.Round)
    }
}