//Let us consider this example (array written in general format):
//ls = [0, 1, 3, 6, 10]
//
//Its following parts:
//
//ls = [0, 1, 3, 6, 10]
//ls = [1, 3, 6, 10]
//ls = [3, 6, 10]
//ls = [6, 10]
//ls = [10]
//ls = []
//The corresponding sums are (put together in a list): [20, 20, 19, 16, 10, 0]
//
//The function parts_sums (or its variants in other languages)
//will take as parameter a list ls and return
//a list of the sums of its parts as defined above.
//Notes
//Take a look at performance: some lists have thousands of elements.
//test2
//Log
//Arrays length between 200000 and 250000
//STDERR
//Execution Timed Out (16000 ms)
//Why did my code time out?
//Our servers are configured to only allow a certain amount of
//time for your code to execute. In rare cases the server may be taking on too
//much work and simply wasn't able to run your code efficiently enough.
//Most of the time though this issue is caused by inefficient algorithms.
//If you see this error multiple times you should try to optimize your code further.

object ArraySums {
    fun sumParts(ls: IntArray): IntArray {
        if (ls.isEmpty())
            return intArrayOf(0)
        val listOfSums = IntArray(ls.size + 1)
        var sum = ls.sum()
        var previousNumber = 0
        ls.forEachIndexed { index, previous ->
            if (index != 0) {
                sum -= previousNumber
                listOfSums[index] = sum
            } else {
                listOfSums[index] = sum
            }
            previousNumber = previous
        }
        return listOfSums
    }
}

fun main(args: Array<String>) {
    val array1 = intArrayOf(0, 1, 3, 6, 10)
    println(ArraySums.sumParts(array1).asList())
    //[20, 20, 19, 16, 10, 0]
    println(ArraySums.sumParts(intArrayOf()).asList())
    val array2 = intArrayOf(744125, 935, 407, 454, 430, 90, 144, 6710213, 889, 810, 2579358)
    println(ArraySums.sumParts(array2).asList())
    //     [10037855, 9293730, 9292795, 9292388, 9291934, 9291504, 9291414, 9291270, 2581057, 2580168, 2579358, 0]
}