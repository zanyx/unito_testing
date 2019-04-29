package it.reply.iriscube.unito

import junit.framework.Assert.assertNotNull
import org.junit.Test

class AssertNotNullUnitTest {

    fun getPropValue(key: String): String? {
        val appProps = mapOf("key1" to "value 1", "key2" to "value 2", "key3" to "value 3")

        return appProps.get(key)
    }

    @Test
    fun notNulltest() {
        val msnt = AssertNotNullUnitTest()
        assertNotNull(msnt.getPropValue("key1"))
    }

}