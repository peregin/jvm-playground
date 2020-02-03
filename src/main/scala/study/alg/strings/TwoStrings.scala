package study.alg.strings

import scala.collection.mutable

object TwoStrings extends App {

  // Complete the twoStrings function below.
  def twoStrings(s1: String, s2: String): String = {
    val chars = mutable.HashSet[Char]()
    for (a <- s1) chars += a
    val maybe = s2.find(chars.contains)
    maybe.map(_ => "YES").getOrElse("NO")
  }

  println(s"result ${twoStrings("hello", "wrd")}")
}
