package study.alg.fun

import scala.annotation.tailrec

object Fibonacci extends App {

  def fibonacci(x:Int):Int = {
    @tailrec
    def fib(i: Int, prevAccu: Int, accu: Int): Int = {
      if (i >= x - 1) accu
      else fib(i+1, accu, prevAccu + accu)
    }
    fib(0, 1, 0)
  }

  val solution = fibonacci(6)
  println(s"solution=$solution")
}
