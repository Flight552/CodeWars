//You have an array e.g [-2, 1, -3, 4, -1, 2, 1, -5, 4]
//You now have to find out which part of this array gives the biggest sum.
//In this case, it would be [4, -1, 2, 1] because 4 - 1 + 2 + 1 = 6.
//No other uninterrupted sequence in that array gives you a bigger sum.
//
//maxSequence(listOf(-2, 1, -3, 4, -1, 2, 1, -5, 4));
//// should be 6: listOf(4, -1, 2, 1)

object SumSubArray {
    fun maxSequence(arr: List<Int>): Int {
        val mutableArr = arr.toMutableList()
        var totalSum = arr.sum()
        while (mutableArr.size > 0) {
            var sum = 0
            mutableArr.forEachIndexed { index, i ->
                sum += i
                if (sum > totalSum) {
                    totalSum = sum
                }
            }
            mutableArr.removeAt(0)
        }
        return if (totalSum < 0) 0 else totalSum
    }
}

fun main(args: Array<String>) {
    val list = listOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    val total = SumSubArray.maxSequence(list)
    println(total)
}