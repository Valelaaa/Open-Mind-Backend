package com.example.openmindbackend.controller

import com.example.openmindbackend.entity.post.*
import com.example.openmindbackend.service.post.PostsService
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.*
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("api/posts")
@RequiredArgsConstructor
class PostsController(
    private val postsService: PostsService,
    private val mapper: PostMapper
) {
    @GetMapping
    fun getPosts(@RequestParam(name = "category", required = false) category: String?): Page<PostDto> {
        val postCategory: PostCategories? = try {
            PostCategories.valueOf(category.orEmpty().uppercase())
        } catch (e: IllegalArgumentException) {
            null
        }

        val postList = postsService.getAllPosts(postCategory).map(mapper::postToDto)
        return PageImpl(postList, PageRequest.of(0, 2), postList.size.toLong())
    }

    @GetMapping("/post/{postId}")
    fun getPostById(@PathVariable("postId") id: String): Post {
        return postsService.getPostById(id)
    }

    @PostMapping
    fun createOrUpdatePost(@RequestBody postRequest: PostRequestBody): ResponseEntity<Void> {
        return postsService.createOrUpdateService(postRequest)
    }

}