package ar.com.wolox.android.example.ui.login

import ar.com.wolox.android.example.service.UserAuthService
import ar.com.wolox.android.example.ui.utils.RetrofitServicesMockManager
import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.tests.WolmoPresenterTest
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`

class LoginPresenterTest : WolmoPresenterTest<LoginView, LoginPresenter>() {

    @Mock
    lateinit var userSession: UserSession

    @Mock
    lateinit var retrofitServices: RetrofitServices

    override fun getPresenterInstance() = LoginPresenter(userSession, retrofitServices)

    @Test
    fun `given an empty email then an error is displayed`() {
        // GIVEN
        val email = ""
        val password = "asdf"

        // WHEN
        presenter.onLoginClicked(email, password)

        // THEN
        verify(view, times(1)).invalidateEmptyEmail()
    }

    @Test
    fun `given an empty password then an error is displayed`() {
        // GIVEN
        val email = "mail@mail.com"
        val password = ""

        // WHEN
        presenter.onLoginClicked(email, password)

        // THEN
        verify(view, times(1)).invalidateEmptyPassword()
    }

    @Test
    fun `given an invalid email then an error is displayed`() {
        // GIVEN
        val email = "a"
        val password = "asdf"

        // WHEN
        presenter.onLoginClicked(email, password)

        // THEN
        verify(view, times(1)).invalidateEmailFormat()
    }

    // Test service calls

    @Test
    fun `given a correct user and password when login button is clicked then user session should be updated`() {
        // GIVEN
        val user = RetrofitServicesMockManager.getCorrectUser()
        val userAuthService = RetrofitServicesMockManager.mockAuthServiceCorrectResponse()
        `when`(retrofitServices.getService(UserAuthService::class.java)).thenReturn(userAuthService)

        // WHEN
        presenter.onLoginClicked(user.email, user.password)

        // THEN
        verify(view, times(1)).goToHomePage()
    }

    @Test
    fun `given an incorrect user when login button is clicked then user session should be blank`() {
        // GIVEN
        val user = RetrofitServicesMockManager.getIncorrectUser()
        val userAuthService = RetrofitServicesMockManager.mockAuthServiceIncorrectResponse()
        `when`(retrofitServices.getService(UserAuthService::class.java)).thenReturn(userAuthService)

        // WHEN
        presenter.onLoginClicked(user.email, user.password)

        // THEN
        verify(view, times(0)).goToHomePage()
    }

    @Test
    fun `given a correct user and incorrect password when login button is clicked then user session should be blank`() {
        // GIVEN
        val user = RetrofitServicesMockManager.getCorrectUserWithIncorrectPassword()
        val userAuthService: UserAuthService = RetrofitServicesMockManager.mockAuthServiceCorrectResponse()
        `when`(userSession.username).thenReturn(user.email)
        `when`(retrofitServices.getService(UserAuthService::class.java)).thenReturn(userAuthService)

        // WHEN
        presenter.onLoginClicked(user.email, user.password)

        // THEN
        verify(view, times(0)).goToHomePage()
    }
}
