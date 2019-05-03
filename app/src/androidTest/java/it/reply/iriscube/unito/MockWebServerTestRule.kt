package it.reply.iriscube.unito

import it.reply.iriscube.unito.datasource.api.APIClient
import okhttp3.mockwebserver.MockWebServer
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

/**
 * Created by Reply.
 */
class MockWebServerTestRule : TestRule {

    companion object {
        private const val MOCK_SERVER_PORT = 8000
    }

    lateinit var mockWebServer: MockWebServer

    override fun apply(base: Statement, description: Description): Statement {
        return MockWebServerStatement(base)
    }

    inner class MockWebServerStatement constructor(
        private val baseStatement: Statement
    ) : Statement() {

        override fun evaluate() {
            try {
                // Creating and starting the mock server.
                mockWebServer = MockWebServer()
                mockWebServer.start(MOCK_SERVER_PORT)
                // Updating the base url used by the app to
                // initialize the api client.
                APIClient.baseUrl = "http://localhost:$MOCK_SERVER_PORT/"
                // Calling the base statement to continue with the
                // test execution.
                baseStatement.evaluate()
            } finally {
                mockWebServer.shutdown()
            }
        }
    }

}