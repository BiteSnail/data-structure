package org.example.storages

class FileStorage {
    private val storage: MutableSet<String> = mutableSetOf()

    fun store(value: String) {
        storage.add(value)
    }

    fun find(key: String): String? {
        return storage.firstOrNull { it.contains(key) }
    }
}