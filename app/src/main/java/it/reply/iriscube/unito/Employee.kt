package it.reply.iriscube.unito

data class Employee(var id: Int, var name: String, var sal: Int) {

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