package study.alg.math

object TrailingZeros extends App {

  def trailingZeroes(A: Int): Int = {
    val n = BigInt(A)
    val one = BigInt(1)
    val fac = (one to n).fold(one)(_ * _)
    val s = fac.toString.reverse
    val stripped = s.dropWhile(_ == '0')
    s.size - stripped.size
  }

  println(s"z = ${trailingZeroes(7860)}")
}
