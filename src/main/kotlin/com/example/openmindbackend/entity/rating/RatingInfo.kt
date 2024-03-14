package com.example.openmindbackend.entity.rating

import jakarta.persistence.*
import java.util.*

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "rating_entity_type", discriminatorType = DiscriminatorType.STRING)
open class RatingInfo(
    @Id
    val id: String = UUID.randomUUID().toString(),

    val currentRating: Int = 0,

    @Enumerated(EnumType.STRING)
    @Column(name = "rating_type")
    val ratingType: RatingType = RatingType.POST,
    @OneToOne(mappedBy = "ratingInfo")
    val userVote: UserVote? = null
)