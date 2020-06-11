package ar.com.wolox.android.example.ui.login

import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.tests.WolmoPresenterTest
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock

class LoginPresenterTest : WolmoPresenterTest<LoginView, LoginPresenter>() {

    @Mock
    lateinit var userSession: UserSession

    @InjectMocks
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
}
