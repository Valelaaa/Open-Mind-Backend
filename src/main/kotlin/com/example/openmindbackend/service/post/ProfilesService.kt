package com.example.openmindbackend.service.post

import com.example.openmindbackend.repository.profiles.ProfilesRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class ProfilesService (private val profilesRepository: ProfilesRepository){

}
