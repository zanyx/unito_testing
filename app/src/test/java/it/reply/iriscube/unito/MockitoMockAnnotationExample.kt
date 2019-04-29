package it.reply.iriscube.unito

import org.junit.Before
import org.junit.Test
import org.mockito.Mock

/**
 * Created by Reply.
 */
class MockitoMockAnnotationExample {

    @Mock
    lateinit var list: List<String>

    @Before
    fun setUp() {
        TODO("Initialize the @Mock annotated fields")
    }

    @Test
    fun test_listContains() {
        TODO("Test that the initialized list contains the element 'Unito' using mocking APIs.")
    }
}