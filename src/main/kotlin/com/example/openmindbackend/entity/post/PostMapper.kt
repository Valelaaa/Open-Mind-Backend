package com.example.openmindbackend.entity.post

import org.springframework.stereotype.Service

@Service
class PostMapper {
    fun postToDto(post: Post): PostDto {
        return PostDto(
            postId = post.postId,
            title = post.title,
            description = post.description.orEmpty(),
            author = post.user,
            createdDate = post.createdDate,
            comments = post.comments,
            rating = post.rating,
            category = post.category
        )
    }
    fun dtoToPost(postDto: PostDto): Post {
        return Post(
            postId = postDto.postId,
            title = postDto.title,
            description = postDto.description,
            user = postDto.author,
            createdDate = postDto.createdDate,
            comments = postDto.comments,
            rating = postDto.rating,
            category = postDto.category
        )
    }
}
