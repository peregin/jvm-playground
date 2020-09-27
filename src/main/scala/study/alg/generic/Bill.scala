package study.alg.generic

object Bill {

  // Complete the bonAppetit function below.
  def bonAppetit(bill: Array[Int], k: Int, b: Int): Int = {
    val res = b - bill.zipWithIndex.filter(_._2 != k).map(_._1).sum / 2
    if (res == 0) System.out.println("Bon Appetit")
    else System.out.println(res)
    res
  }

  def main(args: Array[String]) {
    val res = bonAppetit(Array(3, 10, 2, 9), 1, 12) // 5
    println(s"bill is $res")
  }
}
