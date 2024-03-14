package com.example.openmindbackend.entity.post

import java.util.*

data class PostRequestBody(
    var userId:String?= UUID.randomUUID().toString(),
    val title:String,
    val description:String?,
    val category:String,
)