package org.example.utils

import kotlin.math.pow

fun <T : Comparable<T>> List<T>.mergeSort(): List<T> {
    if (this.size < 2) return this
    val middle = this.size / 2

    val left = this.subList(0, middle).mergeSort()
    val right = this.subList(middle, this.size).mergeSort()

    return merge(left, right)
}

private fun <T : Comparable<T>> merge(left: List<T>, right: List<T>): List<T> {
    var leftIndex = 0
    var rightIndex = 0

    val result = mutableListOf<T>()

    while (leftIndex < left.size && rightIndex < right.size) {
        val leftElement = left[leftIndex]
        val rightElement = right[rightIndex]
        if (leftElement < rightElement) {
            result.add(leftElement)
            leftIndex += 1
        } else if (leftElement > rightElement) {
            result.add(rightElement)
            rightIndex++
        } else {
            result.add(leftElement)
            leftIndex++
            result.add(rightElement)
            rightIndex++
        }
    }
    if (leftIndex < left.size) {
        result.addAll(left.subList(leftIndex, left.size))
    }
    if (rightIndex < right.size) {
        result.addAll(right.subList(rightIndex, right.size))
    }
    return result
}

//LSD 기반의 RadixSort
fun MutableList<Int>.radixSort() {
    val base = 10
    var done = false
    var digits = 1
    while (!done) {
        done = true
        val buckets = arrayListOf<MutableList<Int>>().apply {
            for (i in 0 until base) {
                this.add(arrayListOf()) //base 크기만큼의 배열 생성
            }
        }
        this.forEach { //여기에서의 this는 객체 자기 자신을 의미함. MutableList
                number ->
            val remainPart = number / digits
            val digit = remainPart % base
            buckets[digit].add(number)
            if (remainPart > 0) { //digits이 모든 number보다 클 때 종료
                done = false
            }
        }
        digits *= base
        this.clear() //초기화 및 다음 상태 입력
        this.addAll(buckets.flatten()) //2차원 리스트를 1차원 리스트로 변환
    }
}

fun MutableList<Int>.lexicographicalSort() {
    val sorted = msdRadixSorted(this, 0)
    this.clear()
    this.addAll(sorted)
}

//MSD 기반의 RadixSort
private fun msdRadixSorted(list: MutableList<Int>, position: Int): MutableList<Int> {
    val base = 10
    if (position > list.maxDigits()) return list

    val buckets = arrayListOf<MutableList<Int>>().apply {
        for (i in 0 until base) {
            this.add(arrayListOf())
        }
    }
    // 결과로서 전달될 리스트
    val priorityBucket = arrayListOf<Int>()
    list.forEach { number ->
        val digit = number.digit(position)
        // digit이 null이면 마지막 자릿수까지 본 것
        // 그러므로 전달될 리스트에 추가
        if (digit == null) {
            priorityBucket.add(number)
            return@forEach
        }
        // digit이 null이 아니면 다음 버킷에 추가
        buckets[digit].add(number)
    }
    priorityBucket.addAll(
        buckets.reduce { result, bucket ->
            // 만약 버킷이 비었다면 다음 버킷으로 넘어감
            if (bucket.isEmpty()) return@reduce result
            // 버킷이 비어있지 않다면 재귀적으로 정렬
            result.addAll(msdRadixSorted(bucket, position + 1))
            result
        }
    )
    return priorityBucket
}

fun Int.digits(): Int {
    // 숫자의 자릿수를 반환
    var num = this
    var count = 0
    while (num != 0) {
        num /= 10
        count++
    }
    return count
}

fun Int.digit(atPosition: Int): Int? {
    // 숫자의 특정 자릿수의 값을 반환
    // atPosition은 0부터 시작
    if (atPosition > digits()) return null
    var num = this
    val correctedPosition = (atPosition + 1).toDouble()
    while (num / (10.0.pow(correctedPosition).toInt()) != 0) { //0이면 맨 앞의 자릿수
        num /= 10
    }
    return num % 10
}

private fun MutableList<Int>.maxDigits(): Int {
    // list에서 가장 큰 값을 찾아서 그 값의 자릿수를 반환
    return this.maxOrNull()?.digits() ?: 0
}