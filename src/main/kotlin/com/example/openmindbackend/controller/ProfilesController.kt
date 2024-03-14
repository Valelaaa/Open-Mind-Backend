package com.example.openmindbackend.controller

import com.example.openmindbackend.service.post.ProfilesService
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
@RestController
@RequestMapping("api/profiles")
@RequiredArgsConstructor
class ProfilesController(private val profilesService: ProfilesService) {

}