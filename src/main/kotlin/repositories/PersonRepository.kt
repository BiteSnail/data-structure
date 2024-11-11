package org.example.repositories

import org.example.entities.Person
import org.example.utils.DataSource

class PersonRepository: Repository<Person, Long> {
    override fun findAll(): List<Person> {
        val people = mutableListOf<Person>()
        DataSource.getConnection().use { connection ->
            connection.prepareStatement("SELECT * FROM Person").use { statement ->
                statement.executeQuery().use { resultSet ->
                    while (resultSet.next()) {
                        val person = Person(
                            id = resultSet.getLong("id"),
                            firstName = resultSet.getString("first_name"),
                            lastName = resultSet.getString("last_name"),
                            email = resultSet.getString("email"),
                            gender = resultSet.getString("gender"),
                            ipAddress = resultSet.getString("ip_address"),
                            language = resultSet.getString("language")
                        )
                        people.add(person)
                    }
                }
            }
        }
        return people
    }
}