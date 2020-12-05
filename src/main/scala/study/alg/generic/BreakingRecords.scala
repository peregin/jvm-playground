package study.alg.generic

object BreakingRecords extends App {

  def count(arr: Array[Int]) = {
    var minCount = 0
    var maxCount = 0
    var min = Int.MaxValue
    var max = Int.MinValue
    for (i <- 0 until arr.length) {
      val a = arr(i)
      if (a < min) {
        minCount += 1
        min = a
      }
      if (a > max) {
        maxCount += 1
        max = a
      }
    }
    Array(minCount - 1, maxCount - 1)
  }

  val in = "10 5 20 20 4 5 2 25 1"
  val arr = in.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
  val result = count(arr)
  println(result.mkString(","))
}
