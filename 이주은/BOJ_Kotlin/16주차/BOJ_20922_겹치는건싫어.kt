package `16주차`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max
import java.util.*

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    val st = readLine().split(" ")
    val n = st[0].toInt()
    val m = st[1].toInt()

    val arr = readLine().split(" ")
    val check = Array<Int>(100001){0}
    var left = 0
    var right = 0
    var max = 0
    while(left <= right){
        if(right < n && check[arr[right].toInt()] < m){
            check[arr[right].toInt()]++
            right++
        } else if(check[arr[right].toInt()] == m){
            check[arr[left].toInt()]--
            left++
        }

        max = max(max, right - left)
        if(right == n)
            break
    }
    println(max)
}