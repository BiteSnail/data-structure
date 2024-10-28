package entities

import org.example.entities.User

object UserComparator : Comparator<User> {
    override fun compare(o1: User, o2: User): Int {
        return -1
    }
}
