object MaxArea {
    fun maxArea(
        h: Int,
        w: Int,
        horizontalLinesY: IntArray,
        verticalLinesX: IntArray
    ): Long {
        var valueY = h - horizontalLinesY.maxOrNull()!!
        var valueW = w - verticalLinesX.maxOrNull()!!
        for(i in 0 until horizontalLinesY.size - 1) {
            for(c in horizontalLinesY.indices) {
                if(c - i > valueY) {
                    valueY = c - i
                }
            }
        }
        for(i in 0 until verticalLinesX.size - 1) {
            for(c in verticalLinesX.indices) {
                if(c - i > valueW) {
                    valueW = c - i
                }
            }
        }

        return (valueY * valueW).toLong()
    }
}

fun main() {
    val area = MaxArea.maxArea(5, 4, intArrayOf(3,2,1), intArrayOf(2,3))
    println(area)
}