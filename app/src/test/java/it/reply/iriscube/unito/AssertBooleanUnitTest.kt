package it.reply.iriscube.unito

import org.junit.Assert.assertFalse
import org.junit.Test

class AssertBooleanUnitTest {

    @Test
    fun evenNumberTest() {
        val abut = AssertBooleanUnitTest()
        assertFalse(abut.isEvenNumber(3))
    }

    @Test
    fun oddNumberTest() {
        // TODO controllare se un numero è pari, usando l'assertion inversa all'esempio precedente
    }

    private fun isEvenNumber(number: Int): Boolean {
        var result = false
        if (number % 2 == 0) {
            result = true
        }
        return result
    }
}