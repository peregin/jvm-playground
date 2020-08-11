package study.alg.strings

object RepeatedStrings {

  def repeatedString(s: String, n: Long): Long = {
    val sLen = s.length
    s.count(_ == 'a') * (n/sLen) + s.take((n%sLen).toInt).count(_ == 'a')
  }

  def main(args: Array[String]) {
    println(s"solution is ${repeatedString("a", 1000000000000L)}")
  }
}
