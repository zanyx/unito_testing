package it.reply.iriscube.unito

import org.junit.Assert.assertArrayEquals
import org.junit.Before
import org.junit.Test


class ArrayEqualityUnitTest {

    private lateinit var expectedEmps: Array<Employee>

    @Before
    fun initInputs() {
        expectedEmps = arrayOf(
            Employee(1, "Yoda", 15000),
            Employee(2, "Luke", 25000),
            Employee(3, "Anakin", 5000)
        )
    }

    @Test
    fun compareEmployees() {
        /**
         * convert List of objects to array of objects
         */

        val testOutput = Employee.getEmpList().toTypedArray()
        assertArrayEquals(expectedEmps, testOutput)
    }

}