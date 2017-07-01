package i_introduction._9_Extension_Functions

import syntax.properties.size

fun main(args: Array<String>) {

    // higher-order function
    fun <T> let(t: T, body: (T) -> Unit) {
        body(t)
    }

    let(2 + 3, { x -> println(x * x) })

    let(2 + 3) { x ->
        println(x * x)
    }

    //Extensions functions
    fun String.lastSecondChar(): Char = when {
        this.size > 1 -> this[this.size - 2]
        else -> throw Exception("not right string")
    }

    println("abc".lastSecondChar())
    println("c".lastSecondChar())


}