package study.alg.generic

object Anagrams extends App {

  def isAnagram(s: String, t: String): Boolean = {
    s.sorted == t.sorted
  }
}
