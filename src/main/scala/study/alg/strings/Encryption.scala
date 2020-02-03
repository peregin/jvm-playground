package study.alg.strings

object Encryption extends App {

  def encryption(s: String): String = {
    val raw = s.replace(" ", "")
    val sqrt = math.sqrt(raw.length)
    val rows = sqrt.floor.toInt
    val cols = sqrt.ceil.toInt
//    println(s"raw = $raw")
//    println(s"matrix = \n${raw.sliding(cols, cols).mkString("\n")}")
//    println(s"rows=$rows, cols=$cols, raw=${raw.length}")
    val res = for (
      r <- 0 to rows;
      c <- 0 to cols
    ) yield c * cols + r
    val aa = res.map(ix => if (ix < raw.length) raw.charAt(ix) else ' ').mkString.split(" ").filter(_.trim.size > 0)
    aa.mkString(" ")
  }

  //val res = encryption("if man was meant to stay on the ground god would have given us roots")
  val res = encryption("feedthedog")
  println(s"result is [$res]")
}
