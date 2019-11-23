package study.alg.arrays

import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

object Socks {

  // Complete the sockMerchant function below.
  def sockMerchant(n: Int, ar: Array[Int]): Int = {
    ar.groupBy(identity).values.map(_.length / 2).sum
  }

  def main(args: Array[String]): Unit = {

    val ar = "10 20 20 10 10 30 50 10 20".split(" ").map(_.trim.toInt)
    val n = ar.length
    val result = sockMerchant(n, ar)

    println(result)
  }
}
