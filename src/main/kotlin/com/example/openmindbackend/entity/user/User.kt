package com.example.openmindbackend.entity.user

import com.example.openmindbackend.entity.post.Post
import com.example.openmindbackend.entity.comment.Comment
import com.example.openmindbackend.entity.rating.RatingInfo
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import java.util.*

@Entity
class User(
    @Id
    val userId: String = UUID.randomUUID().toString(),
    val nickname: String = "nickname",
    val firstName: String = "firstName",
    val lastName: String = "lastName",
    val userPicture: String? = null,

    @OneToMany(mappedBy = "user")
    val posts: List<Post> = emptyList(),

    @OneToMany(mappedBy = "user")
    val comments: List<Comment> = emptyList(),

    @OneToMany(mappedBy = "user")
    val ratings: List<RatingInfo> = emptyList()
)
