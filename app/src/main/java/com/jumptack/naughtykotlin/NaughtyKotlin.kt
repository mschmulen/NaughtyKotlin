package com.jumptack.naughtykotlin

import android.os.Handler
import kotlin.random.Random

class NaughtyKotlin {

    fun divideByZero() {
        println("XXXX CRASH divideByZero")
        val a = 2
        val b = 0
        val z = a/b
        println(2/0)
    }

    fun indexOutOfRange() {
        println("XXXX CRASH indexOutOfRange")
        val a = ("0")
        println(a[1])
    }

    fun recursiveStackOverflow() {
        println("XXXX ANR recursiveStackOverflow")
        recursiveStackOverflow()
    }

    fun nullPointerException() {
        println("XXXX CRASH nullPointerException")
        //throw null;
        throw NullPointerException()
    }

    fun runtimeException() {
        println("XXXX CRASH runtimeException")
        throw RuntimeException("runtime exception crash")
    }

    fun delayRuntimeException() {
        println("XXXX CRASH delay RuntimeException")
        Handler().postDelayed(
            {
                println( "XXXX This'll run 1 seconds later")
                throw RuntimeException("XXXX This is a crash")
            },
            1000
        )
        println("XXXX delay RuntimeException")
    }

    fun doANRBubleSort() {
        println("XXXX doANRBubleSort")
        var list:ArrayList<Int> = arrayListOf(9, 4, 10, 3, 9, 4, 10, 3, 22, 4, 10, 3, 8, 4, 10, 3, 19, 4, 10, 5)
        println("XXXX size: ${list.size}")

        var ran = Random(121398471923874)

        list.addAll( (1..100000).map { ran.nextInt() })
        println("XXXX size : ${list.size}")

        list.addAll( (1..100000).map { ran.nextInt() })
        println("XXXX size : ${list.size}")

        list.addAll( (1..100000).map { ran.nextInt() })
        println("XXXX size : ${list.size}")

        //println("XXXX Original: $list")
        println("XXXX start bubbleSort : ${list.size}")
        list.bubbleSort(true)
        println("XXXX end bubbleSort : ${list.size}")
        //println("XXXX Bubble sorted: $list")
        println("XXXX done doANRBubleSort")

    }
    
    // TODO allocate a bunch of stuff ...
    fun outOfMemory() {

    }
}

class CrashError @JvmOverloads constructor(msg: String? = "simulated crash") :
    Error(msg) {
    companion object {
        fun doCrash() {
            throw CrashError()
        }
    }
}


// bubble sort stuff
fun <T> ArrayList<T>.swapAt(first: Int, second: Int) {
    val aux = this[first]
    this[first] = this[second]
    this[second] = aux
}

fun <T : Comparable<T>> ArrayList<T>.bubbleSort(showPasses: Boolean = false) {
    if (this.size < 2) return
    for (end in (1 until this.size).reversed()) {
        var swapped = false
        for (current in 0 until end) {
            if (this[current] > this[current + 1]) {
                this.swapAt(current, current + 1)
                swapped = true
            }
        }
        if(showPasses) println(this)
        if (!swapped) return
    }
}