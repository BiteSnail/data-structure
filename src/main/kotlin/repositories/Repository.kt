package org.example.repositories

interface Repository<T, K> {
    fun findAll(): List<T>
}