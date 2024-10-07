package org.example

import org.example.services.DataService
import org.example.storages.DatabaseStorage

fun main(data: List<String>, key: String) {
    val service: DataService = DataService(DatabaseStorage())

    data.forEach { service.saveData(it) }
    println(service.getData(key) ?: "Not found")
}