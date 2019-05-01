package it.reply.iriscube.unito

import android.support.test.rule.ActivityTestRule
import it.reply.iriscube.unito.activity.LoginActivity
import org.junit.Rule
import org.junit.Test

/**
 * Created by Reply.
 */

class LoginActivityTest {

    @get:Rule
    val mActivityTestRule = ActivityTestRule<LoginActivity>(LoginActivity::class.java)

    @Test
    fun shouldContainUsernameInput() {
        //TODO: Check that username TextView is visible
    }

    @Test
    fun usernameInputShouldApplyCorrectHint() {
        //TODO: Check that username TextView hint is exactly "Inserisci username o email"
    }

    @Test
    fun shouldContainPasswordInput() {
        //TODO: Check that password TextView is visible
    }


    @Test
    fun passwordInputShouldApplyCorrectHint() {
        //TODO: Check that password TextView hint is exactly "Inserisci password"
    }

    @Test
    fun shouldContainLoginButton() {
        //TODO: Check that login Button is visible
        // Find the button by id
    }

    @Test
    fun shouldContainLoginButtonFindByText() {
        //TODO: Check that login Button is visible
        // Find the button by text
    }

    @Test
    fun loginButtonShouldApplyCorrectText() {
        //TODO: Check that login Button text is exactly "Entra"
    }

    @Test
    fun loginWithoutUsernameShouldDisplayError() {
        //TODO: Check that the username message error is visibile when username is empty
    }

    @Test
    fun loginWithUsernameShouldntDisplayError() {
        //TODO: Check that the username message error is hidden when username is not empty
    }

    @Test
    fun loginWithEmptyPasswordShouldDisplayError() {
        //TODO: Check that the password message error is visibile when password is empty
    }

    @Test
    fun loginWithPasswordShouldntDisplayError() {
        //TODO: Check that the password message error is hidden when pasword is not empty
    }


    @Test
    fun loginWithIncorrectCredentialsShouldDisplayError() {
        //TODO: Check that the wrong credentials error is visible when username equals to "username" and password equals to "password"
    }

    @Test
    fun successfulLoginShouldOpenMainScreen() {
        //TODO: Check that the login is successful
    }
}