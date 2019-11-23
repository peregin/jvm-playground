package study.alg.math

object Palindrome extends App {

  def isPalindrome(x: Int): Boolean = {
    val s = x.toString
    s == s.reverse
  }

  def check(test: Array[Int]): Unit = {
    test.foreach(i => println(s"$i is palindrome: ${isPalindrome(i)}"))
  }

  check(Array(1, 2, 123, 121, 10000, 100001))

  println(s"is palindrome number: ${isPalindrome(121)}")
}
