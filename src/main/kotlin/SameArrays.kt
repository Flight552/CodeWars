class SameArrays {
    fun comp(a: IntArray?, b: IntArray?): Boolean {
        val number = a?.sortedArray()?.map { it * it }
        if(a == null && b == null)
            return true
        return number?.toList() == b?.sortedArray()?.toList()
    }
}

fun main() {
    val same = SameArrays()
//    val a = intArrayOf(121, 144, 19, 161, 19, 144, 19, 11)
//    val b = intArrayOf(121, 14641, 20736, 36100, 25921, 361, 20736, 361)
    val a: IntArray? = null
    val b: IntArray? = null
    same.comp(a, b)
}