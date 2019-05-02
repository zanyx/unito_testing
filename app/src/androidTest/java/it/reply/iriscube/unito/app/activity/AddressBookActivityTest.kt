package it.reply.iriscube.unito.app.activity

import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Reply.
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class AddressBookActivityTest {

    // TODO: add the rule to verify that the right intent will be launched when testing the detail screen

    @Test
    fun successfulPeopleLoadingShouldPopulateRecyclerView() {
        // TODO: (1) load the mock response for the test

        // TODO: (2) verify that the list is loaded and the RecyclerView is filled with the person list
    }

    @Test
    fun failingPeopleLoadingShouldNotDoAnything() {
        // TODO: (1) load the mock response that simulates a failure of the server

        // TODO: (2) verify that the list of person is not filled at all
    }

    @Test
    fun selectingPersonShouldStartDetailIntent() {
        // TODO: (1) load the mock response for the test

        // TODO: (2) verify that the list is loaded and the RecyclerView is filled with the person list

        // TODO: (3) select a person cell and verify if the right Intent is launched.
    }
}