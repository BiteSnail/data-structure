package org.example.utils

import java.sql.Connection
import java.sql.DriverManager

object DataSource {
    fun getConnection(): Connection {
        return DriverManager.getConnection("jdbc:sqlite:test.db")
    }
}