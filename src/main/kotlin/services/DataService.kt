package org.example.services

import org.example.storages.DatabaseStorage

class DataService(private val storage: DatabaseStorage) {
    private fun validate(data: String) {
        if (data.isEmpty()) {
            throw IllegalArgumentException("데이터가 비었습니다.")
        }
    }

    fun saveData(data: String) {
        validate(data)
        storage.store(data)
    }

    fun getData(key: String): String? {
        return storage.find(key)
    }
}