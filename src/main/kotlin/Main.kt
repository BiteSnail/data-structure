package org.example

fun main() {
    val map: Map<String, Int> = mapOf("Math" to 99, "Korean" to 88, "Science" to 90);

    println("전체 평균은 ${map.values.sum()}점 입니다.")
}