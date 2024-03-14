package com.example.openmindbackend.repository.comments

import com.example.openmindbackend.entity.comment.Comment
import com.example.openmindbackend.repository.BaseRepository
import com.example.openmindbackend.repository.user.UserRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Repository

@Repository
@RequiredArgsConstructor
class CommentsRepository() : BaseRepository<Comment> {
    val mockCommentsRepository: MutableList<Comment> = mutableListOf()


    override fun fetchById(id: String): Comment {
        TODO("Not yet implemented")
    }

    override fun fetchAll(): List<Comment> {
        TODO("Not yet implemented")
    }

    override fun updateEntity(entity: Comment) {
        mockCommentsRepository.add(entity)
    }

    override fun contains(entity: Comment): Boolean {
        return mockCommentsRepository.contains(entity)
    }

    fun addAll(listOfComments: MutableList<Comment>) {
        mockCommentsRepository.addAll(listOfComments)
    }
}