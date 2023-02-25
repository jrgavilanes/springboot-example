package es.janrax.myapi.users

import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class UserDaoService {
    var maxUser = 0
    var users = mutableListOf<User>(
        User(
            id = ++maxUser,
            name = "juanra1",
            birthDate = LocalDate.now().minusYears(30),
        ),
        User(
            id = ++maxUser,
            name = "juanra2",
            birthDate = LocalDate.now().minusYears(31),
        ),
    )

    fun findAll(): List<User> {
        return users
    }

    fun findOne(id: Int): User? {
        return users.firstOrNull { it.id == id }
    }

    fun save(user: User): User {
        if (user.id == 0) {
            user.id = ++maxUser
        }
        users.add(user)
        return user
    }

    fun deleteById(userId: Int): User? {
//        users.removeIf { it.id == userId } // Alternative
        val user = findOne(userId)
        user?.let {
            users.remove(it)
        }
        return user
    }
}
