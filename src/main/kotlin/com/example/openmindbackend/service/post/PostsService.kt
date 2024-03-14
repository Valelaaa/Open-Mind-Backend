package com.example.openmindbackend.service.post

import com.example.openmindbackend.entity.post.Post
import com.example.openmindbackend.entity.post.PostCategories
import com.example.openmindbackend.entity.post.PostRequestBody
import com.example.openmindbackend.repository.comments.CommentsRepository
import com.example.openmindbackend.repository.posts.PostsRepository
import com.example.openmindbackend.repository.user.UserRepository
import lombok.RequiredArgsConstructor
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import java.util.*

@Service
@RequiredArgsConstructor
class PostsService(
    private val postsRepository: PostsRepository,
    private val userRepository: UserRepository,
) {
    init {
        addAllPosts()
    }

    private final fun getMockPost(): Post = Post(
        title = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.".take(
            300
        ),
        user = userRepository.fetchByNickname("janedoe"),
        description = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of \"de Finibus Bonorum et Malorum\" (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, \"Lorem ipsum dolor sit amet..\", comes from a line in section 1.10.32.".take(
            300
        ),
        createdDate = Date(
            2024 - 1900, 0, 20,
            21, 30
        ),
    )

    private final fun addAllPosts() {
        postsRepository.addAll(
            mutableListOf(

                Post(
                    title = "How to manage your money better, daily? Any available lessons?",
                    description = "description",
                    user = userRepository.fetchByNickname("johndoe")
                ),
                Post(
                    title = "I would like to save money online like in my banking account, but to not touch them. Is it possible?",
                    description = "description",
                    user = userRepository.fetchByNickname("janedoe")

                ),
                Post(
                    title = "Can we expedite transaction confirma-tions? Cuz yesterday I just tried some and no result...",
                    description = "description",
                    user = userRepository.fetchByNickname("johnsnow")
                ),
                getMockPost(),
                Post(
                    title = "How to manage your money better, daily? Any available lessons?",
                    description = "description",
                    user = userRepository.fetchByNickname("johnwick")

                ),
                Post(
                    title = "I would like to save money online like in my banking account, but to not touch them. Is it possible?",
                    description = "description",
                    user = userRepository.fetchByNickname("johnsick"),
                    category = PostCategories.FEATURE
                ),
                Post(
                    title = "Can we expedite transaction confirma-tions? Cuz yesterday I just tried some and no result...",
                    description = "description",
                    category = PostCategories.FEATURE,
                    user = userRepository.fetchByNickname("janedoe")
                ),
                Post(
                    title = "I would like to save money online like in my banking account, but to not touch them. Is it possible?",
                    description = "description",
                    category = PostCategories.BUG,
                    user = userRepository.fetchByNickname("johnwick")

                ),
                Post(
                    title = "Can we expedite transaction confirma-tions? Cuz yesterday I just tried some and no result...",
                    description = "description",
                    category = PostCategories.BUG,
                    user = userRepository.fetchByNickname("johnsnow")

                ),
                getMockPost(),
            )
        )
    }

    fun getAllPosts(category: PostCategories?): List<Post> {
        if (category == null)
            return postsRepository.fetchAll()
        return postsRepository.fetchPosts(category)
    }

    fun getPostById(id: String): Post {
        TODO("Return post by id")
    }

    fun createOrUpdateService(@RequestBody postRequest: PostRequestBody): ResponseEntity<Void> {
        val user = userRepository.fetchByNickname("johnSnow")
        postRequest.userId = user.userId
        val postCategory: PostCategories = try {
            PostCategories.valueOf(postRequest.category.uppercase())
        } catch (e: IllegalArgumentException) {
            PostCategories.BUG
        }
        val post = Post(
            title = postRequest.title,
            description = postRequest.description,
            category = postCategory,
            user = user
        )
        return if (postsRepository.contains(post)) {
            postsRepository.updateEntity(post)
            ResponseEntity.status(HttpStatus.OK).build()
        } else {
            postsRepository.updateEntity(post)
            ResponseEntity.status(HttpStatus.CREATED).build()
        }
        TODO("Not yet implemented")
    }


}