package it.reply.iriscube.unito

import junit.framework.Assert.assertFalse
import org.junit.Test

class AssertBooleanUnitTest {

    fun isEvenNumber(number: Int): Boolean {

        var result = false
        if (number % 2 == 0) {
            result = true
        }
        return result
    }

    @Test
    fun evenNumberTest() {
        val abut = AssertBooleanUnitTest()
        assertFalse(abut.isEvenNumber(3))
    }

    @Test
    fun oddNumberTest() {
        // TODO controllare se un numero è pari, usando l'assertion inversa all'esempio precedente
    }

}