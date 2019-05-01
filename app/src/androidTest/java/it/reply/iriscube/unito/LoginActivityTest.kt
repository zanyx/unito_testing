package it.reply.iriscube.unito

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import it.reply.iriscube.unito.activity.LoginActivity
import org.hamcrest.Matchers.not
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
        onView(withId(R.id.userNameTextView)).check(matches(isDisplayed()))
    }

    @Test
    fun shouldContainPasswordInput() {
        onView(withId(R.id.passwordTextView)).check(matches(isDisplayed()))
    }


    @Test
    fun passwordInputShouldApplyCorrectHint() {
        onView(withId(R.id.passwordTextView)).check(matches(withHint(R.string.inserisci_password)))
    }

    @Test
    fun shouldContainLoginButton() {
        onView(withId(R.id.loginButton)).check(matches(isDisplayed()))
    }

    @Test
    fun shouldContainLoginButtonFindByText() {
        onView(withText(R.string.entra)).check(matches(isDisplayed()))
    }

    @Test
    fun loginButtonShouldApplyCorrectText() {
        onView(withId(R.id.loginButton)).check(matches(withText(R.string.entra)))
    }

    @Test
    fun loginWithoutUsernameShouldDisplayError() {
        onView(withId(R.id.userNameTextView)).perform(typeText(""), closeSoftKeyboard())
        onView(withId(R.id.loginButton)).perform(click())
        onView(withId(R.id.userNameErrorView)).check(matches(isDisplayed()))
    }

    @Test
    fun loginWithUsernameShouldntDisplayError() {
        onView(withId(R.id.userNameTextView)).perform(typeText("Marco"), closeSoftKeyboard())
        onView(withId(R.id.loginButton)).perform(click())
        onView(withId(R.id.userNameErrorView)).check(matches(not(isDisplayed())))
    }

    @Test
    fun loginWithEmptyPasswordShouldDisplayError() {
        onView(withId(R.id.passwordTextView)).perform(typeText(""), closeSoftKeyboard())
        onView(withId(R.id.loginButton)).perform(click())
        onView(withId(R.id.passwordErrorView)).check(matches(isDisplayed()))
    }

    @Test
    fun loginWithPasswordShouldntDisplayError() {
        onView(withId(R.id.userNameTextView)).perform(typeText(""), closeSoftKeyboard())
        onView(withId(R.id.passwordTextView)).perform(typeText("123456789"), closeSoftKeyboard())
        onView(withId(R.id.loginButton)).perform(click())
        onView(withId(R.id.passwordErrorView)).check(matches(not(isDisplayed())))
    }


    @Test
    fun loginWithIncorrectCredentialsShouldDisplayError() {
        onView(withId(R.id.userNameTextView)).perform(typeText("username"), closeSoftKeyboard())
        onView(withId(R.id.passwordTextView)).perform(typeText("password"), closeSoftKeyboard())
        onView(withId(R.id.loginButton)).perform(click())
        onView(withId(R.id.wrongCredential)).check(matches(isDisplayed()))
    }

    @Test
    fun successfulLoginShouldOpenMainScreen() {
        onView(withId(R.id.userNameTextView)).perform(typeText("Marco"), closeSoftKeyboard())
        onView(withId(R.id.passwordTextView)).perform(typeText("123456789"), closeSoftKeyboard())
        onView(withId(R.id.loginButton)).perform(click())
    }
}