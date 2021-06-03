package study.alg.generic

object HammingWeight extends App {

  // you need treat n as an unsigned value
  def hammingWeight(n: Int): Int = {
    var x = n
    var c = 0
    while (x > 0) {
      c += x % 2
      x >>>= 1
    }
    c
  }

  val n = 5
  println(s"$n = ${hammingWeight(n)}")
}
