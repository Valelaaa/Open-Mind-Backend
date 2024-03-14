package com.example.openmindbackend.entity.comment

import com.example.openmindbackend.entity.rating.RatingInfo
import com.example.openmindbackend.entity.rating.RatingType
import com.example.openmindbackend.entity.user.User
import jakarta.persistence.*
import java.util.*

@Entity
data class Comment(
    @Id
    val commentId: String = UUID.randomUUID().toString(),
    @ManyToOne
    val parentComment: Comment? = null,
    val message: String = "",
    val createdDate: Date = Date(System.currentTimeMillis()),
    @ManyToOne
    val user: User = User(),
    val modificationDate: Date = Date(System.currentTimeMillis()),

    @OneToMany(mappedBy = "parentComment")
    val subComments: List<Comment> = emptyList(),

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "rating_id")
    val rating: RatingInfo = RatingInfo(ratingType = RatingType.COMMENT)
)