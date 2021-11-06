package study.alg.generic

import scala.util.Try

object ReverseInt extends App {

  // if reverse is going out of signed integer range then is 0
  def reverse(x: Int): Int = {
    val s = if (x < 0) -1 else 1
    Try(s * x.abs.toString.reverse.toInt).getOrElse(0)
  }

  println(reverse(-123))
}
