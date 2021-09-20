//Given a Divisor and a Bound ,
// Find the largest integer N , Such That ,
//
//Conditions :
//N is divisible by divisor
//
//N is less than or equal to bound
//
//N is greater than 0.
//
//Notes
//The parameters (divisor, bound) passed to the function are only positive values .
//It's guaranteed that a divisor is Found .

object MaxMutli {
    fun maxMultiple(d: Int, b: Int): Int {
        var N = 0
        for(i in 0 .. b) {
            if(i % d == 0) {
                N = i
            }
        }
        return N
    }
}

// best solution
// fun maxMultiple(d: Int, b: Int): Int = (b downTo d).first { it % d == 0 }
fun main(args: Array<String>) {

}