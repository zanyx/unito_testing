package it.reply.iriscube.unito

import org.junit.Assert.assertEquals
import org.junit.Test

class AssertEqualsUnitTest {

    @Test
    fun myStringEqualsTest() {
        val employee = Employee(1, "Yoda", 15000)
        val expectedName = "Yoda"

        assertEquals(expectedName, employee.getEmpNameWithHighestSalary())
    }

    @Test
    fun myObjectEqualsTest() {
        // TODO implementare i metodi necessari per poter fare la comparazione tra oggetti (expected == actual), sono data classes...
    }
}
