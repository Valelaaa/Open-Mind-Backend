package com.example.openmindbackend.repository.user

import com.example.openmindbackend.entity.user.User
import com.example.openmindbackend.repository.BaseRepository
import org.springframework.stereotype.Repository

@Repository

class UserRepository : BaseRepository<User> {
    val mockUserRepository: MutableList<User> = mutableListOf(
        User(nickname = "janedoe", firstName = "Jane", lastName = "Doe"),
        User(nickname = "johndoe", firstName = "John", lastName = "Doe"),
        User(nickname = "johnwick", firstName = "John", lastName = "Wick"),
        User(nickname = "johnsick", firstName = "John", lastName = "Sick"),
        User(nickname = "johnsnow", firstName = "John", lastName = "Snow")
    )

    override fun fetchById(id: String): User {
        TODO("Not yet implemented")
    }

    override fun fetchAll(): List<User> {
        TODO("Not yet implemented")
    }

    override fun updateEntity(entity: User) {
        mockUserRepository.add(entity)
    }

    override fun contains(entity: User): Boolean {
        return mockUserRepository.contains(entity)
    }

    fun fetchByNickname(nickname: String): User {
        val user = mockUserRepository.firstOrNull { it.nickname == nickname }
        return user ?: User("unknown", "unknown", "unknown")
    }
}