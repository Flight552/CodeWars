class MutliSum {
    fun solution(number: Int): Int {
        var sum: Int = 0
        for(i in 0 until number) {
            if(i % 3 == 0 && i % 5 == 0) {
                sum += i
                continue
            }
            if(i % 3 == 0){
                sum += i
            }
            if(i % 5 == 0) {
                sum += i
            }
        }
        return sum
    }
}

// best solution
// fun solution(number: Int) = (1 until number).filter { it % 3 == 0 || it % 5 == 0 }.sum()