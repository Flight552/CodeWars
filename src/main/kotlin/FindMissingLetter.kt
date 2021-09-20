//#Find the missing letter
//
//Write a method that takes an array of
//consecutive (increasing) letters as input
//and that returns the missing letter in the array.
//
//You will always get an valid array.
//And it will be always exactly one letter
//be missing. The length of the array will always be at least 2.
//The array will always contain letters in only one case.
//
//Example:
//
//['a','b','c','d','f'] -> 'e' ['O','Q','R','S'] -> 'P'

object FindMissingLetter {
    fun findMissingLetter(array: CharArray): Char {
        val firstLetter: Char = array[0]
        val lastLetter: Char = array[array.size - 1]
        (firstLetter .. lastLetter).forEachIndexed {index,  missingLetter ->
            if(array[index] != missingLetter) {
                return missingLetter
            }
        }
        return ' '
    }
}

fun main(args: Array<String>) {
    println(FindMissingLetter.findMissingLetter(charArrayOf('a','b','c','d','f')))
    println(FindMissingLetter.findMissingLetter(charArrayOf('O','Q','R','S')))
}

// best solution
// fun findMissingLetter(array: CharArray) = (array.first()..array.last()).first { it !in array }