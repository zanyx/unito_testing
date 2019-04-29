package it.reply.iriscube.unito

import org.junit.Test
import it.reply.iriscube.unito.Employee
import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
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
