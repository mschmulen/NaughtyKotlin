package com.jumptack.naughtykotlin

import android.app.ActivityManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    val naughty = NaughtyKotlin()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btn_buttonCrashANRBubbleSort = findViewById(R.id.buttonCrashANRBubbleSort) as Button
        btn_buttonCrashANRBubbleSort.setOnClickListener {
            naughty.doANRBubleSort()
            //Toast.makeText(this@MainActivity, "button A.", Toast.LENGTH_SHORT).show()
        }

        val btn_buttonDivideByZero = findViewById(R.id.buttonDivideByZero) as Button
        btn_buttonDivideByZero.setOnClickListener {
            naughty.divideByZero()
        }

        val btn_buttonRecursiveStackOverflow = findViewById(R.id.buttonRecursiveStackOverflow) as Button
        btn_buttonRecursiveStackOverflow.setOnClickListener {
             naughty.recursiveStackOverflow()
        }

        val btn_button_nullPointerException = findViewById(R.id.button_nullPointerException) as Button
        btn_buttonRecursiveStackOverflow.setOnClickListener {
            naughty.nullPointerException()
        }

        // naughty.indexOutOfRange()
        // naughty.runtimeException()
        // naughty.delayRuntimeException()


        dumpMemStuff()

    }

    fun dumpMemStuff() {
        println("XXXX -------------------- dumpMemStuff stuff --------------------")
        val a = ActivityManager.isLowMemoryKillReportSupported()
        println("XXXX isLowMemoryKillReportSupported $a")
        val b = ActivityManager.isRunningInUserTestHarness()
        println("XXXX isRunningInUserTestHarness $b")
        val c = ActivityManager.isUserAMonkey()
        println("XXXX isUserAMonkey $c")

        val memoryInfo = ActivityManager.MemoryInfo()
        val activityManager =
                getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.getMemoryInfo(memoryInfo)

        println("XXXX availMem ${memoryInfo.availMem.toString()}")
        println("XXXX totalMem ${memoryInfo.totalMem.toString()}")
        val runtime = Runtime.getRuntime()
        println("XXXX maxMemory ${runtime.maxMemory()}")
        println("XXXX totalMemory ${runtime.totalMemory()}")
        println("XXXX freeMemory ${runtime.freeMemory()}")

        println("XXXX -------------------- dumpMemStuff stuff --------------------")
    }
}