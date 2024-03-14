package com.example.openmindbackend.entity.post

import com.example.openmindbackend.entity.comment.Comment
import com.example.openmindbackend.entity.rating.RatingInfo
import com.example.openmindbackend.entity.user.User
import java.util.*

data class PostDto(
    val postId: String = UUID.randomUUID().toString(),
    var title: String,
    var description: String = "",
    val author: User = User("Unknown"),
    var createdDate: Date = Date(System.currentTimeMillis()),
    var comments: List<Comment> = listOf(),
    val rating: RatingInfo = RatingInfo(postId),
    val category: PostCategories = PostCategories.BUG
)
