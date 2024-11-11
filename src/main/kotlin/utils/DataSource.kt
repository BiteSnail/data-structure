package org.example.utils

import java.sql.Connection
import java.sql.DriverManager

object DataSource {
    val connection: Connection = DriverManager.getConnection("jdbc:sqlite:test.db")

}