//Sheldon, Leonard, Penny,
// Rajesh and Howard are in the queue for a
// "Double Cola" drink vending machine; there are no
// other people in the queue. The first one in the queue
// (Sheldon) buys a can, drinks it and doubles! The resulting
// two Sheldons go to the end of the queue. Then the next in the queue
// (Leonard) buys a can, drinks it and gets to the end of the queue as two Leonards, and so on.
//
//For example, Penny drinks the third can of cola and the queue will look like this:
//
//Rajesh, Howard, Sheldon, Sheldon, Leonard, Leonard, Penny, Penny
//Write a program that will return the name of the person who will drink the n-th cola.


object WhoIs {
    fun whoIsNext(names: List<String>, n: Int): String {
        val pairNames = mutableMapOf<String, IntRange>()
        var finalName = ""
        var index = 1
        var position = names.size * (index) + 1
        if (n <= names.size) {
            return names[n - 1]
        } else {
            while (position <= n) {
                index *= 2
                for ((value, counter) in (1..names.size).withIndex()) {
                    pairNames[names[value]] = position + index * value until position + (index * counter)
                }
                position += names.size * (index)
            }
        }
        pairNames.forEach { (t, u) ->
            val isTrue = u.contains(n)
            if (isTrue) {
                finalName = t
            }
        }
        return finalName
    }
}

fun main(args: Array<String>) {
    val names = listOf("Sheldon", "Leonard", "Penny", "Rajesh", "Howard")
    val names2 = listOf(
        "Daisuke Aramaki",
        "Motoko Kusanagi",
        "Batou",
        "Togusa",
        "Ishikawa",
        "Saito",
        "Pazu",
        "Borma",
        "Azuma",
        "Yano",
        "Proto"
    )
    println(WhoIs.whoIsNext(names2, 467))
}

//best solution
//fun whoIsNext(names: List<String>, n: Int): String =
//    names[generateSequence(n) { (it - names.lastIndex) / 2 }.takeWhile { it > 0 }.last() - 1]
