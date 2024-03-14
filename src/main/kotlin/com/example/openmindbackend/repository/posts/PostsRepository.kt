package com.example.openmindbackend.repository.posts

import com.example.openmindbackend.entity.post.Post
import com.example.openmindbackend.entity.post.PostCategories
import com.example.openmindbackend.repository.BaseRepository
import com.example.openmindbackend.repository.comments.CommentsRepository
import com.example.openmindbackend.repository.user.UserRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Repository
import java.util.*

@Repository
@RequiredArgsConstructor
class PostsRepository(
    private val commentsRepository: CommentsRepository,
) : BaseRepository<Post> {
    private val mockRepository: MutableList<Post> = mutableListOf()

    fun addAll(postList: List<Post>) {
        mockRepository.addAll(postList)
    }

    fun fetchPosts(category: PostCategories?): List<Post> {
        return mockRepository.filter { it.category == category }
    }

    override fun fetchById(id: String): Post {
        TODO("Not yet implemented")
    }

    override fun fetchAll(): List<Post> {
        return mockRepository
    }

    override fun updateEntity(entity: Post) {
        if (mockRepository.contains(entity)) {
            val index = mockRepository.indexOfFirst { it.postId == entity.postId }
            mockRepository[index] = entity
        } else {
            mockRepository.add(entity)
        }
    }

    override fun contains(entity: Post): Boolean {
        return mockRepository.contains(entity)
    }

}
