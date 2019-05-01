package it.reply.iriscube.unito

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers.hasData
import android.support.test.espresso.intent.matcher.IntentMatchers.hasExtraWithKey
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import it.reply.iriscube.unito.activity.LoginActivity
import it.reply.iriscube.unito.activity.WelcomeActivity
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test

/**
 * Created by Reply.
 */

class LoginActivityTest {

    @get:Rule
    val mIntentrule = IntentsTestRule<LoginActivity>(LoginActivity::class.java)

    @Test
    fun successfulLoginShouldOpenMainScreen() {
        onView(withId(R.id.userNameTextView)).perform(typeText("Marco"), closeSoftKeyboard())
        onView(withId(R.id.passwordTextView)).perform(typeText("123456789"), closeSoftKeyboard())
        onView(withId(R.id.loginButton)).perform(click())
        intended(allOf(
            hasExtraWithKey(LoginActivity.USERNAME)
        ))
    }
}