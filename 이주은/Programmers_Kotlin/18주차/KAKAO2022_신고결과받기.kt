package `18주차`
fun main(){
    val id_list = arrayOf("con", "ryan")
    val report = arrayOf("ryan con", "ryan con", "ryan con", "ryan con")
    val k = 3
    val arr = solution(id_list, report, k)

    println("${arr[0]}     ${arr[1]}")
}
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer: IntArray = IntArray(id_list.size, {0})
        val cnt = Array<Int>(id_list.size){0}
        val map = mutableMapOf<String, Int>()
        for(i in report){
            if(map.get(i) == 1)
                continue

            map.put(i, 1)
            val tmp = i.split(" ")
            println(tmp[1] + "  " + id_list.indexOf(tmp[1]))
            cnt[id_list.indexOf(tmp[1])]++
        }

        for(s in map.keys){
            val tmp = s.split(" ")
            if(cnt[id_list.indexOf(tmp[1])] >= k)
                answer[id_list.indexOf(tmp[0])]++
        }

        return answer
    }
