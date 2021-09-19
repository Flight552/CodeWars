//Create a function that takes a Roman numeral
//as its argument and returns its value as a
//numeric decimal integer.
//You don't need to validate the form of the Roman numeral.
//
//Modern Roman numerals are written by
//expressing each decimal digit of the
//number to be encoded separately, starting
//with the leftmost digit and skipping any
//0s. So 1990 is rendered "MCMXC"
//(1000 = M, 900 = CM, 90 = XC) and
//2008 is rendered "MMVIII" (2000 = MM, 8 = VIII). T
//he Roman numeral for 1666, "MDCLXVI",
//uses each letter in descending order.

//Example:
//
//decode("XXI") // should return 21

class RomanNumerals {

    fun decode(str: String): Int {
        var counterMills: Int = 0
        var counterHundrs: Int = 0
        var counterDecs: Int = 0
        var counterDigs: Int = 0
        var isTrue = false
        var isFourHundred = false
        var isNineHundred = false
        var isSixHundred = false
        var afterV = false
        var isFour = false
        var isSixty = false
        var isNinety = false
        var isForty = false
        var afterI = false
        val listNumbers = mutableListOf<Int>(0, 0, 0, 0)

        if (str.isEmpty()) {
            listNumbers.add(0, 0)
        }
        str.forEachIndexed { index, ch ->
            if ((ch == 'M' || ch == 'm') && !isNineHundred) {
                counterMills++
                listNumbers[0] = counterMills
            } else if ((ch == 'D' || ch == 'd') && !isFourHundred) {
                listNumbers[1] = 5
                isTrue = true
                try {
                    if (str[index + 1] == 'C') {
                        isSixHundred = true
                        isTrue = false
                    }
                } catch (e: StringIndexOutOfBoundsException) {}
            } else if ((ch == 'C' || ch == 'c') && !isTrue && !isNinety) {
                var hasNumberD = false
                var hasNumberM = false
                try {
                    hasNumberD = str[index + 1] == 'D'
                } catch (e: StringIndexOutOfBoundsException) {
                }
                try {
                    hasNumberM = str[index + 1] == 'M'
                } catch (e: StringIndexOutOfBoundsException) {
                }

                if (hasNumberD) {
                    listNumbers[1] = 4
                    isFourHundred = true
                } else if (hasNumberM) {
                    listNumbers[1] = 9
                    isNineHundred = true
                } else {
                    if (!isSixHundred) {
                        listNumbers[1] = ++counterHundrs
                        isFourHundred = false
                        isNineHundred = false
                    } else {
                        listNumbers[1] = 5 + ++counterHundrs
                    }
                }
            } else if ((ch == 'L' || ch == 'l') && !isSixty && !isForty) {
                listNumbers[2] = 5
                try {
                    if (str[index + 1] == 'X') {
                        listNumbers[2] = 6
                        isSixty = true
                    }
                } catch (e: StringIndexOutOfBoundsException) {
                }
            } else if ((ch == 'X' || ch == 'x')) {
                if (!afterI) {
                    counterDecs++
                    listNumbers[2] = counterDecs
                }
                if (!isNinety && !isForty) {
                    try {
                        if (str[index + 1] == 'C') {
                            listNumbers[2] = 9
                            isNinety = true
                        }
                    } catch (e: StringIndexOutOfBoundsException) {
                    }
                    try {
                        if (str[index + 1] == 'L') {
                            listNumbers[2] = 4
                            isForty = true
                        }
                    } catch (e: StringIndexOutOfBoundsException) {
                    }
                }
                if (isSixty) {
                    listNumbers[2] = 6 + counterDecs - 1
                }

            } else if ((ch == 'I' || ch == 'i') && !afterV) {
                counterDigs++
                listNumbers[3] = counterDigs
                try {
                    if (str[index + 1] == 'V') {
                        listNumbers[3] = 4
                        isFour = true
                    }
                } catch (e: StringIndexOutOfBoundsException) { }
                try {
                    if (str[index + 1] == 'X') {
                        listNumbers[3] = 9
                        afterI = true
                    }
                } catch (e: StringIndexOutOfBoundsException) { }
            } else if ((ch == 'V' || ch == 'v') && !isFour) {
                listNumbers[3] = 5
                afterV = true
                counterDigs = 0
                try {
                    if (str[index + 1] == 'I') {
                        for (i in index until str.length - 1) {
                            counterDigs++
                            listNumbers[3] = 5 + counterDigs
                        }
                    }
                } catch (e: StringIndexOutOfBoundsException) { }
            }
        }

        return listNumbers.joinToString("", "", "").toInt()
    }

}

fun main(args: Array<String>) {
    val converter = RomanNumerals()
    val year = converter.decode("MMXIX")
    println("Year $year")
}