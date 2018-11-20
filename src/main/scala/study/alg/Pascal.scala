package study.alg


object Pascal extends App {

  def solve1(A: Int): Array[Array[Int]]  = {
    def fac(n: Long): Long = (1L to n).fold(1L)(_ * _)
    def cnk(n: Int, k: Int): Long = ((n - k + 1) to n).fold(1)(_ * _) / fac(k)

    (0 until A).map(i =>
      (0 to i).map(j => cnk(i, j)).map(_.toInt).toArray
    ).toArray
  }

  def getRow(A: Int): Array[Int]  = {
    val tri = new scala.collection.mutable.ArrayBuffer[scala.collection.mutable.ArrayBuffer[Int]]
    (0 to A+1).map { i =>
      val line = scala.collection.mutable.ArrayBuffer.fill(i)(1)
      if (i > 2) {
        for (j <- 1 until i - 1) {
          val prev = tri(i-1)
          line(j) = prev(j - 1) + prev(j)
        }
      }
      tri += line
    }
    tri.last.toArray
  }

  def solve(A: Int): Array[Array[Int]] = {
    val tri = new scala.collection.mutable.ArrayBuffer[scala.collection.mutable.ArrayBuffer[Int]]
    (0 to A).map { i =>
      val line = scala.collection.mutable.ArrayBuffer.fill(i)(1)
      if (i > 2) {
        for (j <- 1 until i - 1) {
          val prev = tri(i-1)
          line(j) = prev(j - 1) + prev(j)
        }
      }
      tri += line
    }
    tri.map(_.toArray).filter(_.size > 0).toArray
  }

  println("-----")
  val res = getRow(3)
  println(s"res=${res.mkString(",")}")

}
