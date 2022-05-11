package `18주차`

private fun solution(board: Array<IntArray>, skill: Array<IntArray>): Int {
    var answer: Int = 0
    var sum = Array(board.size + 1){ IntArray(board[0].size + 1) }

    for(sk in skill){
        val degree = sk[5] * if(sk[0] == 1) -1 else 1
        sum[sk[1]][sk[2]] += degree
        sum[sk[1]][sk[4] + 1] += -degree
        sum[sk[3] + 1][sk[2]] += -degree
        sum[sk[3] + 1][sk[4] + 1] += degree
    }

    for(y in 1 until board.size){
        for(x in 0 until board[0].size){
            sum[y][x] += sum[y - 1][x]
        }
    }
    for(x in 1 until board[0].size){
        for(y in 0 until board.size){
            sum[y][x] += sum[y][x - 1]
        }
    }

    for(i in 0 until board.size){
        for(j in 0 until board[0].size){
            if(board[i][j] + sum[i][j] > 0)
                answer++
        }
    }


//    시간 초과
//    var _board = board
//    var check = Array<BooleanArray>(board.size){ BooleanArray(board[0].size) }
//
//    for(sk in skill){
//        if(sk[0] == 1){
//            for(x in sk[1] .. sk[3]){
//                for(y in sk[2] .. sk[4]){
//                    _board[x][y] -= sk[5]
//                    if(_board[x][y] <= 0 && !check[x][y]){
//                        check[x][y] = true
//                        answer--
//                    }
//                }
//            }
//        } else{
//            for(x in sk[1] .. sk[3]){
//                for(y in sk[2] .. sk[4]){
//                    _board[x][y] += sk[5]
//                    if(_board[x][y] > 0 && check[x][y]){
//                        check[x][y] = false
//                        answer++
//                    }
//                }
//            }
//        }
//    }

    return answer
}

private fun main(){
    val board: Array<IntArray> = arrayOf(intArrayOf(5,5,5,5,5), intArrayOf(5,5,5,5,5), intArrayOf(5,5,5,5,5), intArrayOf(5,5,5,5,5))
    val skill = arrayOf(intArrayOf(1,0,0,3,4,4), intArrayOf(1,2,0,2,3,2), intArrayOf(2,1,0,3,1,2), intArrayOf(1,0,1,3,3,1))

    val res = solution(board, skill)
    println(res)
}