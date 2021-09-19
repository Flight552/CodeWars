import java.util.*

//Count the number of Duplicates
//Write a function that will return the
//count of distinct case-insensitive
//alphabetic characters and numeric
//digits that occur more than once in
//the input string. The input string
//can be assumed to contain only alphabets
//(both uppercase and lowercase) and numeric digits.

class Duplicated {
    fun duplicateCount(text: String): Int {
        var count = 0
        val mapOfChars = mutableMapOf<Char, Int>()
        val newText = text.toUpperCase()
        for (i in 0..255) {
            count = 0
            newText.forEach { ch ->
                if (ch.code == i) {
                    count++
                    if (count > 1) {
                        mapOfChars[ch] = count
                    }
                }
            }
        }
        return mapOfChars.size
    }
}

//fun duplicateCount(text: String) {
//    val size = text.groupBy(Char::toLowerCase).count { it.value.count() > 1 }
//}

fun main(args: Array<String>) {
    val dup = Duplicated()
    val text = "dA" + "c".repeat(10) + "b".repeat(100) + "a".repeat(1000)
    val size = dup.duplicateCount(text)
    println(size)
}
