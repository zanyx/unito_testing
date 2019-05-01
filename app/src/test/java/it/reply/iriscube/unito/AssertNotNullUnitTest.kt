package it.reply.iriscube.unito

import org.junit.Assert.assertNotNull
import org.junit.Test

class AssertNotNullUnitTest {

    @Test
    fun notNullTest() {
        assertNotNull(getPropValue("key1"))
    }

    private fun getPropValue(key: String): String? {
        val appProps = mapOf(
            "key1" to "value 1",
            "key2" to "value 2",
            "key3" to "value 3"
        )
        return appProps[key]
    }
}
