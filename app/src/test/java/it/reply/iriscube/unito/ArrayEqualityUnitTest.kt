package it.reply.iriscube.unito

import org.junit.Assert.assertArrayEquals
import org.junit.Before
import org.junit.Test


class ArrayEqualityUnitTest {

    var expectedEmps = arrayOfNulls<Any>(3)

    @Before
    fun initInputs() {
        expectedEmps[0] = Employee(1, "Yoda", 15000)
        expectedEmps[1] = Employee(2, "Luke",  25000)
        expectedEmps[2] = Employee(3, "Anakin", 5000)
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