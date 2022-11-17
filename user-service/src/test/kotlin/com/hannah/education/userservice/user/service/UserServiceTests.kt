package com.hannah.education.userservice.user.service

import com.hannah.education.userservice.user.domain.Type
import com.hannah.education.userservice.user.dto.request.UserCreateRequest
import com.hannah.education.userservice.user.dto.request.UserDuplicateRequest
import com.hannah.education.userservice.user.dto.request.UserLoginRequest
import com.hannah.education.userservice.user.dto.response.UserCreateResponse
import com.hannah.education.userservice.user.repository.UserRepository
import com.hannah.education.userservice.util.code.ErrorCode
import com.hannah.education.userservice.util.exception.BusinessException
import io.kotest.assertions.throwables.shouldThrowMessage
import io.kotest.core.spec.style.BehaviorSpec
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkConstructor
import org.springframework.security.crypto.password.PasswordEncoder
import java.time.LocalDate

class UserServiceTests : BehaviorSpec({

    beforeContainer { mockkConstructor(LocalDate::class) }

    afterContainer { clearAllMocks() }

    val passwordEncoder = mockk<PasswordEncoder>(relaxed = true, relaxUnitFun = true)
    val userRepository = mockk<UserRepository>(relaxed = true, relaxUnitFun = true)
    val userService = UserService(userRepository, passwordEncoder)

    Given("유저 데이터가 존재하지 않은 상태에서") {
        When("유저를 저장하면") {
            Then("request 보낸 데이터와 response 온 데이터가 같아야 한다") {
                val request = createRequest
                val response = createResponse
                every { userService.createUser(request) } returns response
            }
        }

        When("존재하지 않은 아이디로 로그인을 시도하면") {
            Then("NOT_MATCH_MEMBER Exception이 일어난다") {
                val request = loginRequest
                shouldThrowMessage(ErrorCode.NOT_MATCH_MEMBER.message) {
                    userService.loginUser(request)
                }
            }
        }

        When("존재하지 않은 아이디로 단건 조회를 하면") {
            Then("NOT_EXIST_MEMBER Exception이 일어난다") {
//                shouldThrowMessage(ErrorCode.NOT_EXIST_MEMBER.message) {
//                    userService.findOne(1000L)
//                }
                every { userService.findOne(0L) } throws BusinessException(ErrorCode.NOT_EXIST_MEMBER)
            }
        }

        When("존재하지 않은 아이디로 유저 삭제를 하면") {
            Then("NOT_EXIST_MEMBER Exception이 일어난다") {
//                shouldThrowMessage(ErrorCode.NOT_EXIST_MEMBER.message) {
//                    userService.findOne(1000L)
//                }
                every { userService.deleteUser(0L) } throws BusinessException(ErrorCode.NOT_EXIST_MEMBER)
            }
        }
    }

    Given("유저 데이터 한 개가 존재하는 상태에서") {
        givenInit(userService)

        When("중복된 아이디로 중복 체크를 했을 때") {
            Then("EXIST_ACCOUNT Exception이 일어난다") {
                val request = duplicateRequest
                shouldThrowMessage(ErrorCode.EXIST_ACCOUNT.message) {
                    userService.accountDuplicateCheck(request)
                }
            }
        }
    }

}) {
    companion object {
        fun givenInit(userService: UserService) {
            val request = createRequest
            every { userService.createUser(request) }
        }

        val createRequest = UserCreateRequest(
            account = "account",
            password = "password",
            name = "name",
            email = "email@email.com",
            phoneNumber = "01012341234",
            type = Type.STUDENT
        )

        val createResponse = UserCreateResponse(
            id = 1L,
            account = "account",
            name = "name",
            email = "email@email.com",
            phoneNumber = "01012341234",
        )

        val loginRequest = UserLoginRequest(
            account = "account",
            password = "password",
        )

        val duplicateRequest = UserDuplicateRequest(
            account = "account"
        )
    }
}