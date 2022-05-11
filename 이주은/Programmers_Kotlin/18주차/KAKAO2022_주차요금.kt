package `18주차`

import java.util.Collections

fun solution(fees: IntArray, records: Array<String>): IntArray {

    val map = mutableMapOf<String, String>()
    val time = mutableMapOf<String, Int>()

    for(re in records){
        val tmp = re.split(" ")

        if(!map.containsKey(tmp[1])){
            map.put(tmp[1], tmp[0])
        }

        else{
            val inTime = map.get(tmp[1])!!.split(":")
            val outTime = tmp[0].split(":")

            val m = (outTime[0].toInt() - inTime[0].toInt()) * 60 + (outTime[1].toInt() - inTime[1].toInt())

            time.put(tmp[1], time.getOrDefault(tmp[1], 0) + m)

            map.remove(tmp[1])
        }
    }

    if(map.isNotEmpty()){
        for(s in map.keys){
            val inTime = map.get(s)!!.split(":")
            val m = (23 - inTime[0].toInt()) * 60 + (59 - inTime[1].toInt())

            time.put(s, time.getOrDefault(s, 0) + m)
        }
    }

    val list = time.keys.toList()
    Collections.sort(list)

    var answer: IntArray = IntArray(list.size)
    for(i in 0 until list.size){
        var money = fees[1]
        if(time.get(list.get(i))!! > fees[0]){
            val num = (time.get(list.get(i))!! - fees[0]) % fees[2]
            val fee = (time.get(list.get(i))!! - fees[0]) / fees[2]
            if(num != 0)
                money += (fee + 1) * fees[3]
            else
                money += fee * fees[3]
        }
        answer[i] = money;
    }

    return answer
}


fun main(){
    val fees: IntArray = intArrayOf(180, 5000, 10, 600)
    val records = arrayOf("05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT")

    val answer = solution(fees, records)
    for(a in answer){
        println(a)
    }

}