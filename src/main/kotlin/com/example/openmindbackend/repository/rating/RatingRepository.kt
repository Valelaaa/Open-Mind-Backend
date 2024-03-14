package com.example.openmindbackend.repository.rating

import com.example.openmindbackend.entity.rating.RatingInfo
import com.example.openmindbackend.repository.BaseRepository
import org.springframework.stereotype.Repository

@Repository
class RatingRepository : BaseRepository<RatingInfo>{
    override fun fetchById(id: String): RatingInfo {
        TODO("Not yet implemented")
    }

    override fun fetchAll(): List<RatingInfo> {
        TODO("Not yet implemented")
    }

    override fun updateEntity(entity: RatingInfo) {
        TODO("Not yet implemented")
    }

    override fun contains(entity: RatingInfo): Boolean {
        TODO("Not yet implemented")
    }

}