package study.alg.generic

import java.io.PrintWriter

import scala.io.StdIn

object MigratoryBirds extends App {

  def migratoryBirds(arr: Array[Int]): Int = {
    val freq = arr.groupBy(identity).mapValues(_.size)
    val sorted = freq.toList.sortBy(aaa => aaa._2).reverse
    sorted.filter(_._2 == sorted.headOption.map(_._2).getOrElse(0)).map(_._1).min
  }

  val in = "1 2 3 4 5 4 3 2 1 3 4"
  val arr = in.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
  val result = migratoryBirds(arr)
  println(result)
}
