//A format for expressing an ordered list of
//integers is to use a comma separated list of either
//
//individual integers
//or a range of integers denoted by the
//starting integer separated from the end integer in
//the range by a dash, '-'. The range includes all
//integers in the interval including both endpoints.
//It is not considered a range unless it spans at least
//3 numbers. For example "12,13,15-17"
//Complete the solution so that it takes a
//list of integers in increasing order and returns a
//correctly formatted string in the range format.
//
//Example:
//
//solution([-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20]);
// returns "-6,-3-1,3-5,7-11,14,15,17-20"

object RangeExtraction {

    fun rangeExtraction(arr: IntArray): String {
        var listOfRangedNumbers = mutableListOf<Int>()
        var finalString = ""
        var rangeString = ""
        var isNext = false

        arr.forEachIndexed { index, i ->
            if (i <= 1) {
                val nextIndex: Int = try {
                    arr[index + 1]
                } catch (e: Exception) {
                    arr[index]
                }
                if (i == nextIndex - 1) {
                    isNext = true
                    listOfRangedNumbers.add(i)
                } else {
                    if (isNext)
                        listOfRangedNumbers.add(i)
                    if (listOfRangedNumbers.size > 2) {
                        rangeString =
                            rangeString.plus("${listOfRangedNumbers[0]}-${listOfRangedNumbers[listOfRangedNumbers.size - 1]},")
                        finalString = finalString.plus(rangeString)
                        rangeString = ""
                        listOfRangedNumbers = mutableListOf()
                    } else {
                        listOfRangedNumbers.forEach {
                            finalString = finalString.plus("$it,")

                        }
                        listOfRangedNumbers = mutableListOf()
                    }
                }
            }
            if (i > 1) {
                val nextIndex: Int = try {
                    arr[index + 1]
                } catch (e: Exception) {
                    0
                }
                if (i == nextIndex - 1) {
                    isNext = true
                    listOfRangedNumbers.add(i)
                } else {
                    if (isNext)
                        listOfRangedNumbers.add(i)
                    if (listOfRangedNumbers.size > 2) {
                        rangeString =
                            rangeString.plus("${listOfRangedNumbers[0]}-${listOfRangedNumbers[listOfRangedNumbers.size - 1]},")
                        finalString = finalString.plus(rangeString)
                        rangeString = ""
                        listOfRangedNumbers = mutableListOf()
                    } else {
                        listOfRangedNumbers.forEach {
                            finalString = finalString.plus("$it,")

                        }
                        listOfRangedNumbers = mutableListOf()
                    }
                }
            }
            if (!isNext) {
                finalString = finalString.plus("$i,")
            }
        }
        finalString = finalString.dropLast(1)
        println(finalString)
        return finalString
    }

}


fun main(args: Array<String>) {
    val array = intArrayOf(-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20)
    RangeExtraction.rangeExtraction(array)
}

//best solution

fun rangeExtraction(
    arr: IntArray
): String = arr.fold(emptyList<Pair<Int, Int>>())
{ rs, x ->
    rs.lastOrNull().run {
        if (this != null && x - second == 1)
            rs.dropLast(1) + (first to x)
        else rs + (x to x)
    }
}.joinToString(",")
{ (x, y) ->
    if (y - x > 1) "$x-$y" else (x..y).joinToString(",")
}
