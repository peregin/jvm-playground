package study.alg.math

object MostFrequentWord extends App {

  def find(text: String): String = {
    val arr = text.split(Array(' ', '.', ',', '\n', '\r', '\t')).map(_.trim).filter(_.nonEmpty)
    arr.groupBy(s => s).map{case (w, list) => (w, list.size)}.maxBy(_._2)._1
  }

  val input =
    """
      |Scala is functional. Scala is also a functional language in the sense that every function is a value.
      |Scala provides a lightweight syntax for defining anonymous functions, it supports higher-order functions,
      |it allows functions to be nested, and supports currying. Scala is a general-purpose programming language
      |providing support for functional programming and a strong static type system.
    """.stripMargin

  val word = find(input)
  println(s"most frequent word is [$word]")
}
