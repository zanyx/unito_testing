package it.reply.iriscube.unito

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
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
    fun verifyFieldValidation() {

        onView(withId(R.id.userNameTextView)).check(matches(not(withText(""))))
        onView(withId(R.id.passwordTextView)).check(matches(not(withText(""))))


    }
}