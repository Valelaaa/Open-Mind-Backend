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
    fun getPosts(
        @RequestParam(name = "category", required = false) category: String?,
        @RequestParam(name = "pageNumber", required = false, defaultValue = "0") pageNumber: Int,
        @RequestParam(name ="pageSize", required = false, defaultValue = "100") pageSize:Int,
        @RequestParam(name = "sortType", required = false, defaultValue = "fresh") sortType:String,
        @RequestParam(name = "sortOrder", required = false, defaultValue = "asc") sortOrder:String,
    ): Page<PostDto> {

        val postList = postsService.getAllPosts(category, sortType, sortOrder).map(mapper::postToDto)
        return PageImpl(postList, PageRequest.of(pageNumber, pageSize), postList.size.toLong())
    }

    @GetMapping("/post/{postId}")
    fun getPostById(@PathVariable("postId") id: String): ResponseEntity<PostDto> {
        return postsService.getPostById(id)
    }

    @PostMapping
    fun createOrUpdatePost(@RequestBody postRequest: PostRequestBody): ResponseEntity<Void> {
        return postsService.createOrUpdateService(postRequest)
    }

    @PatchMapping("/{postId}")
    fun updatePost(@PathVariable("postId") id: String, @RequestBody postRequest: PostRequestBody) {

    }

}