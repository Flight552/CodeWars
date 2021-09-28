import java.sql.Time
import java.util.*

//A friend of mine takes the sequence of all numbers from 1 to n (where n > 0).
//Within that sequence, he chooses two numbers, a and b.
//He says that the product of a and b should be equal
// to the sum of all numbers in the sequence, excluding a and b.
//Given a number n, could you tell me the numbers he excluded from the sequence?
//The function takes the parameter: n (n is always strictly greater than 0)
// and returns an array or a string (depending on the language) of the form:
//
//[(a, b), ...] or [[a, b], ...] or {{a, b}, ...} or or [{a, b}, ...]
//with all (a, b) which are the possible removed numbers in the sequence 1 to n.
//
//[(a, b), ...] or [[a, b], ...] or {{a, b}, ...} or ...
// will be sorted in increasing order of the "a".
//
//It happens that there are several possible (a, b).
// The function returns an empty array (or an empty string) if
// no possible numbers are found which will prove that my
// friend has not told the truth! (Go: in this case return nil).
//
//Examples:
//removNb(26) should return [(15, 21), (21, 15)]
//or
//removNb(26) should return { {15, 21}, {21, 15} }
//or
//removeNb(26) should return [[15, 21], [21, 15]]
//or
//removNb(26) should return [ {15, 21}, {21, 15} ]
//or
//removNb(26) should return "15 21, 21 15"
//or
//
//in C:
//removNb(26) should return  {{15, 21}{21, 15}} tested by way of strings.
//Function removNb should return a pointer to an allocated

object NSequence {
    fun removNb(n: Long): Array<LongArray> {
        val list = mutableListOf<Long>()
        val totalSum = ((n * (n + 1)) / 2)
        for (first in n downTo n / 2) {
            val second = (totalSum - first) / (first + 1)
            if (first * second == totalSum - first - second) {
                list.add(second)
                list.add(first)
            }
        }
        val array = Array(list.size / 2) {
            LongArray(2)
        }
        var newArr1 = LongArray(2)
        var counter = 0
        var secondCounter = 0
        list.forEachIndexed { index, l ->
            newArr1[secondCounter] = l
            secondCounter++
            if (index % 2 != 0) {
                array[counter] = newArr1
                newArr1 = LongArray(2)
                counter++
                secondCounter = 0
            }
        }

        return if (array.isEmpty()) emptyArray() else array
    }
}

fun main(args: Array<String>) {
    // 550320, 908566
    //500002041120
    val result = NSequence.removNb(101)
    result.forEach { n ->
        n.forEach {
            print("$it ")
        }
        println()
    }
}

// Best solution
//fun removNb(n: Long) = (1..n).fold(ArrayList<LongArray>()) { result, a ->
//    val sum = (n * (n + 1)) / 2
//    val b = (sum - a) / (a + 1)
//    if (sum - b - a == b * a && b <= n) result.add(arrayOf(a, b).toLongArray())
//    result
//}.toTypedArray()