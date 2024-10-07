package org.example

import org.example.services.DataService
import org.example.storages.FileStorage

fun main(data: List<String>, key: String) {
    val service: DataService = DataService(FileStorage())

    data.forEach { service.saveData(it) }
    println(service.getData(key) ?: "Not found")
}