package `16주차`

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    val t = readLine().toInt()

    for(i in 0 until t){
        val n = readLine().toInt()
        val arr = Array<Array<Int>>(2){ Array<Int>(n + 1){0}}
        for(i in 0 until 2){
            val st = readLine().split(" ")
            for(j in 1 .. n){
                arr[i][j] = st[j - 1].toInt()
            }
        }

        val res = Array<Array<Int>>(2){Array<Int>(n + 1){0} }
        res[0][1] = arr[0][1]
        res[1][1] = arr[1][1]

        for(i in 2 .. n){
            res[0][i] = max(res[1][i - 1], res[1][i - 2]) + arr[0][i];
            res[1][i] = max(res[0][i - 1], res[0][i - 2]) + arr[1][i];
        }

        println(max(res[0][n], res[1][n]))
    }
}