package com.lambdaschool.congressfragmentsproject.util

object CongresspersonStringConstruction {

    fun nameConstruction(firstName: String?, middleName: String?, lastName: String?): String {
        val array = Array<String?>(3) { "" }
        array[0] = lastName
        array[1] = firstName
        array[2] = middleName

        var fullName = ""

        for (i in 0 until array.size) {
            if (array[i] != "null") {
                when {
                    i == 0 -> fullName += "${array[i]},"
                    else -> fullName += " ${array[i]}"
                }
            }
        }

        return fullName
    }

    fun partyStateConstruction(congresspersonParty: String?, congresspersonState: String?): String? {
        var temp = ""
        val array = Array<String?>(2) { "" }
        array[0] = congresspersonParty
        array[1] = congresspersonState
        for (i in 0 until array.size) {
            if (array[i] != null) {
                when {
                    i == 0 -> temp += "($congresspersonParty)"
                    i == 1 -> temp += "-$congresspersonState"
                }
            }
        }
        return temp
    }

    fun votesMissedConstruction(congresspersonMissed: Double?): String {
        return "$congresspersonMissed%"
    }
}