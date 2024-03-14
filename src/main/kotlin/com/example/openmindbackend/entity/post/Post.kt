package com.example.openmindbackend.entity.post

import com.example.openmindbackend.entity.comment.Comment
import com.example.openmindbackend.entity.rating.RatingInfo
import com.example.openmindbackend.entity.rating.RatingType
import com.example.openmindbackend.entity.user.User
import jakarta.persistence.*
import lombok.Builder
import java.util.*

@Entity
@Builder
data class Post(
    @Id
    var postId: String = UUID.randomUUID().toString(),

    var title: String = "No title",

    var description: String? = null,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User = User(),

    var createdDate: Date = Date(System.currentTimeMillis()),

    @OneToMany(mappedBy = "post")
    var comments: List<Comment> = emptyList(),

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "rating_id")
    val rating: RatingInfo = RatingInfo(ratingType = RatingType.POST),

    val category: PostCategories = PostCategories.BUG
)
