class Sum {
  fun solution3(num: Int, total: Int): IntArray {

    var answer: IntArray = IntArray(num)
    val sum = num * (1 + num) / 2
    val start = (total - sum) / num
    for (i in 1..num) {
      answer[i - 1] = i + start;
    }

    return answer
  }
}