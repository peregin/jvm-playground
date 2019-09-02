package study.alg.math

object DropNth extends App {

  def drop[A](kth: Int, list: List[A]): List[A] = {
    val ret = list.zipWithIndex.map{ case (a, i) => if (i% kth == 0) None else Some(a) }.flatten
     // case (v, i) => v
    //}//.collect
    //list
    ret
  }

  val res = drop(3, List('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k'))
  println(res)

  def mostFrequentWord(text: String): String = {
    "hello"
  }


}
