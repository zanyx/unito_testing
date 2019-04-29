package it.reply.iriscube.unito

data class Employee(var id: Int, var name: String, var sal: Int) {

    companion object {
        fun getEmpList(): List<Employee> {
            val emps = ArrayList<Employee>()
            emps.add(Employee(1, "Yoda", 15000))
            emps.add(Employee(2, "Luke", 25000))
            emps.add(Employee(3, "Anakin", 5000))
            return emps
        }
    }

    fun getEmpNameWithHighestSalary(): String {
        /**
         * logic to get Highest paid employee
         */
        return "Yoda"
    }

    fun getHighestPaidEmployee(): Employee {
        /**
         * hiding logic to get highest paid employee
         */
        return Employee(1, "Yoda", 15000)
    }

}