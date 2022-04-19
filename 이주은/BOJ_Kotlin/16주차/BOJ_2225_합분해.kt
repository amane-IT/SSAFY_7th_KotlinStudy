package `16주차`

import java.io.BufferedReader
import java.io.InputStreamReader

fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    val dp = Array<Array<Long>>(201){Array<Long>(201){0} }

    val st = readLine().split(" ")
    val n = st[0].toInt()
    val m = st[1].toInt()

    for(i in 1 .. 200){
        dp[i][0] = 1;
        dp[1][i] = 1;
        dp[2][i] = (i + 1).toLong()
    }

    for(i in 3 .. 200){
        for(j in 1 .. 200){
            for(k in 0 .. j){
                dp[i][j] += dp[i - 1][j - k] % 1_000_000_000
            }
        }
    }

    println(dp[m][n] % 1_000_000_000)
}