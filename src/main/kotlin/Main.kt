package org.example

fun CALCULATEArea(Width: Int, HEIGHT: Int): Int {
    var Result = Width * HEIGHT
    return Result
}

fun main() {
    val area_value = CALCULATEArea(5, 10)
    println("Area is $area_value")
}