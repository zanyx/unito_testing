package it.reply.iriscube.unito.app.activity

import android.content.ComponentName
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.intent.Intents
import android.support.test.espresso.intent.Intents.intended
import android.support.test.espresso.intent.matcher.IntentMatchers
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import it.reply.iriscube.unito.MockWebServerTestRule
import it.reply.iriscube.unito.R
import it.reply.iriscube.unito.app.activity.PersonDetailActivity.Companion.PERSON_ID_EXTRA
import it.reply.iriscube.unito.app.adapter.PeopleAdapter
import it.reply.iriscube.unito.assertion.RecyclerViewItemCountAssertion
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.Matchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.TimeUnit

/**
 * Created by Reply.
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class AddressBookActivityTest {

    @get:Rule
    val addressBookActivityRule: ActivityTestRule<AddressBookActivity> =
        ActivityTestRule(AddressBookActivity::class.java, false, false)

    @get:Rule
    val mockWebServerRule: MockWebServerTestRule =
        MockWebServerTestRule()

    private val mockWebServer: MockWebServer
        get() = mockWebServerRule.mockWebServer

    @Before
    fun setUp() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun successfulPeopleLoadingShouldPopulateRecyclerView() {
        // Preparing the response for the use case.
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(
                    """
                    {
                        "page": 1,
                        "per_page": 3,
                        "total": 12,
                        "total_pages": 4,
                        "data": [
                            {
                                "id": 1,
                                "first_name": "George",
                                "last_name": "Bluth",
                                "avatar": ""
                            },
                            {
                                "id": 2,
                                "first_name": "Janet",
                                "last_name": "Weaver",
                                "avatar": ""
                            },
                            {
                                "id": 3,
                                "first_name": "Emma",
                                "last_name": "Wong",
                                "avatar": ""
                            }
                        ]
                    }
                """.trimIndent()
                )
        )
        // Starting the desired activity.
        addressBookActivityRule.launchActivity(AddressBookActivity.newIntent(InstrumentationRegistry.getTargetContext()))
        // Checking that the information displayed by the summary are correct.
        onView(withId(R.id.recyclerView)).check(RecyclerViewItemCountAssertion(3))
    }

    @Test
    fun failingPeopleLoadingShouldNotDoAnything() {
        mockWebServer.enqueue(
            MockResponse().setResponseCode(500)
        )
        // Starting the desired activity.
        addressBookActivityRule.launchActivity(AddressBookActivity.newIntent(InstrumentationRegistry.getTargetContext()))
        // Checking that the information displayed by the summary are as expected.
        onView(withId(R.id.recyclerView)).check(RecyclerViewItemCountAssertion(0))
    }

    @Test
    fun selectingPersonShouldStartDetailIntent() {
        // Preparing the response for the use case.
        mockWebServer.enqueue(
            MockResponse()
                .setResponseCode(200)
                .setBody(
                    """
                    {
                        "page": 1,
                        "per_page": 3,
                        "total": 12,
                        "total_pages": 4,
                        "data": [
                            {
                                "id": 1,
                                "first_name": "George",
                                "last_name": "Bluth",
                                "avatar": ""
                            },
                            {
                                "id": 2,
                                "first_name": "Janet",
                                "last_name": "Weaver",
                                "avatar": ""
                            },
                            {
                                "id": 3,
                                "first_name": "Emma",
                                "last_name": "Wong",
                                "avatar": ""
                            }
                        ]
                    }
                """.trimIndent()
                )
                .setBodyDelay(2, TimeUnit.SECONDS)
        )
        // Starting the address book activity.
        addressBookActivityRule.launchActivity(
            AddressBookActivity.newIntent(InstrumentationRegistry.getTargetContext())
        )
        // Selecting a user from the list and verifying that the right intent is started.
        onView(withId(R.id.recyclerView))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<PeopleAdapter.ViewHolder>(1, click())
            )

        intended(
            allOf(
                IntentMatchers.hasComponent(
                    ComponentName.createRelative(
                        InstrumentationRegistry.getTargetContext(),
                        PersonDetailActivity::class.java.name
                    )
                ),
                IntentMatchers.hasExtraWithKey(PERSON_ID_EXTRA),
                IntentMatchers.hasExtra(PERSON_ID_EXTRA, 2L)
            )
        )
    }
}
