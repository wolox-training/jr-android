package ar.com.wolox.android.example.ui.utils

import ar.com.wolox.android.example.model.User
import ar.com.wolox.android.example.service.UserAuthService
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Collections

class RetrofitServicesMockManager {

    companion object {

        private const val correctEmail: String = "email@email.com"
        private const val correctPassword: String = "password"
        private const val incorrectPassword: String = "incorrectPassword"
        private const val incorrectEmail: String = "incorrectEmail@email.com"

        fun getCorrectUser(): User {
            val correctUser = User()
            correctUser.password = correctPassword
            correctUser.email = correctEmail
            return correctUser
        }

        fun getCorrectUserWithIncorrectPassword(): User {
            val correctUserIncorrectPassword = User()
            correctUserIncorrectPassword.password = incorrectPassword
            correctUserIncorrectPassword.email = correctEmail
            return correctUserIncorrectPassword
        }

        fun getIncorrectUser(): User {
            val incorrectUser = User()
            incorrectUser.password = incorrectPassword
            incorrectUser.email = incorrectEmail
            return incorrectUser
        }

        fun mockAuthServiceCorrectResponse(): UserAuthService {
            val mockUserAuthService = mock(UserAuthService::class.java)
            val mockCall = mockCall(mockCorrectResponse())
            `when`(mockUserAuthService.findUserByEmail(correctEmail)).thenReturn(mockCall)
            return mockUserAuthService
        }

        fun mockAuthServiceIncorrectResponse(): UserAuthService {
            val mockUserAuthService = mock(UserAuthService::class.java)
            val mockCall = mockCall(mockIncorrectResponse())
            `when`(mockUserAuthService.findUserByEmail(incorrectEmail)).thenReturn(mockCall)
            return mockUserAuthService
        }

        private fun mockCall(responseList: List<User>): Call<List<User>> {
            val mockCall: Call<List<User>> = mock(Call::class.java) as Call<List<User>>
            val response: Response<List<User>> = mock(Response::class.java) as Response<List<User>>
            `when`(response.body()).thenReturn(responseList)

            `when`(mockCall.enqueue(any())).thenAnswer {
                (it.getArgument(0) as Callback<List<User>>).onResponse(mockCall, response)
            }
            return mockCall
        }

        fun mockCorrectResponse(): List<User> {
            val user = User()
            user.email = correctEmail
            user.password = correctPassword
            return Collections.singletonList(user)
        }

        fun mockIncorrectResponse(): List<User> {
            val user = User()
            user.email = incorrectEmail
            user.password = correctPassword
            return Collections.singletonList(user)
        }
    }
}
