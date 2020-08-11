package study.teachfp

import scalaz.Reader

object MonTest extends App {

  val fun = (i:Int) => i.toString
  val re = Reader(fun)
  val rrr = re(2)
  println(rrr)
  val res = re.run(2)
  println(res)
}
