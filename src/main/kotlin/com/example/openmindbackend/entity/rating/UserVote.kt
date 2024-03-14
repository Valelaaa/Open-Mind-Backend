package com.example.openmindbackend.entity.rating

import com.example.openmindbackend.entity.user.User
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import java.util.*

@Entity
data class UserVote(
    @Id
    val id: String = UUID.randomUUID().toString(),

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User = User(),

    @ManyToOne
    @JoinColumn(name = "rating_info_id")
    val ratingInfo: RatingInfo = RatingInfo(),

    val vote: Int = 0// 1 - liked, -1 - disliked, 0 - doesn't rated
)
