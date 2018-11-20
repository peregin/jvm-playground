package study.sudoku


object SudoApp extends App  {

  //val ln1 = "1,2,3,4,5,6,7,8,9,2,3,4,5,6,7,8,9,1,3,4,5,6,7,8,9,1,2,4,5,6,7,8,9,1,2,3,5,6,7,8,9,1,2,3,4,6,7,8,9,1,2,3,4,5,7,8,9,1,2,3,4,5,6,8,9,1,2,3,4,5,6,7,9,1,2,3,4,5,6,7,8"
  val ln1 = "1,2,7,5,3,9,8,4,6,4,5,3,8,6,1,7,9,2,8,9,6,4,7,2,1,5,3,2,8,9,3,1,7,4,6,5,3,6,5,2,8,4,9,1,7,7,4,1,9,5,6,3,2,8,9,7,4,6,2,8,5,3,1,5,1,2,7,4,3,6,8,9,6,3,8,1,9,5,2,7,4"

  val result = for( ln <- Seq(ln1) ) yield check(ln)

  val appres = result.forall(_ == true)

  println(s"result is $appres")

  def check(line: String): Boolean = {
    // generate a 2 dimensional data structure Seq[Seq[Int]]
    val board = line.split(",").map(_.toInt).toSeq.sliding(9, 9).toSeq
    println(s"rows ${board.length}")

    def extractSubgrid(r: Int, c: Int): Seq[Int] = {
      for {i <- r until r+3
           j <- c until c+3} yield board(i)(j)
    }

    def invalid(a: Seq[Int]) = a.length != a.distinct.length // no duplicates
    def validate(arr: Seq[Seq[Int]]) = arr.filter(invalid).isEmpty

    val subgrids = for {r <- 0 until 9 by 3
                        c <- 0 until 9 by 3} yield extractSubgrid(r, c)
    val rows = board
    val columns = board.transpose

    validate(subgrids) && validate(rows) && validate(columns)
  }

}
