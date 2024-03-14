package com.example.openmindbackend.service.comment

import com.example.openmindbackend.entity.comment.Comment
import com.example.openmindbackend.repository.comments.CommentsRepository
import com.example.openmindbackend.repository.user.UserRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class CommentService(
    private val commentsRepository: CommentsRepository,
    private val userRepository: UserRepository
) {
    init{
        addAll()
    }
    private final fun addAll() {
        commentsRepository.addAll(
            mutableListOf(
                Comment(
                    user = userRepository.fetchByNickname("johndoe"),
                    message = "Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur",
                    subComments = mutableListOf(
                        Comment(
                            user = userRepository.fetchByNickname("johnwick"),
                            message = "@RichardMcClintock Hala Madrid!",
                        ),
                        Comment(
                            user = userRepository.fetchByNickname("johnwick"),
                            message = "@JohnWick Mb u r wrong?"
                        ),
                        Comment(user = userRepository.fetchByNickname("johnsick"), message = "I like ponies"),
                        Comment(
                            user = userRepository.fetchByNickname("johnwick"),
                            message = "@RichardMcClintock Hala Madrid!",
                        ),
                        Comment(
                            user = userRepository.fetchByNickname("johnwick"),
                            message = "@JohnWick Mb u r wrong?"
                        ),
                        Comment(user = userRepository.fetchByNickname("johnsick"), message = "I like ponies"),
                        Comment(
                            user = userRepository.fetchByNickname("johnwick"),
                            message = "@RichardMcClintock Hala Madrid!",
                        ),
                        Comment(
                            user = userRepository.fetchByNickname("johnwick"),
                            message = "@JohnWick Mb u r wrong?"
                        ),
                        Comment(user = userRepository.fetchByNickname("johnsick"), message = "I like ponies"),
                        Comment(
                            user = userRepository.fetchByNickname("johnwick"),
                            message = "@RichardMcClintock Hala Madrid!",
                        ),
                        Comment(
                            user = userRepository.fetchByNickname("johnwick"),
                            message = "@JohnWick Mb u r wrong?"
                        ),
                        Comment(user = userRepository.fetchByNickname("johnsick"), message = "I like ponies"),
                    )

                ),
                Comment(user = userRepository.fetchByNickname("johnsnow"), message = "Winter is coming")
            )
        )
    }
}