
object Hi extends App {
  for (i <- 0 to (10, 2)) println(i)
  println("hi----------")

  val pattern = """hello_(t_)(\d+)*(BON)*""".r

  //test("hello")
  test("hello_t_1234_bing_BONgola")

  def test(in: String): Unit = {
    pattern.findAllIn(in).matchData.foreach{m =>
      val gc = m.groupCount
      println(gc)
      for (i <- 1 to gc) println(m.group(i))
    }
  }

  def solve(A: Int): Array[Array[Int]]  = {
    def fac(n: Int): Int = (1 to n).fold(1)(_ * _)
    def cnk(n: Int, k: Int): Int = fac(n)/(fac(k)*fac(n-k))

    (0 until A).map(i =>
      (0 to i).map(j => cnk(i, j)).toArray
    ).toArray
  }

  println("-----")
  val res = solve(3)
  res.foreach(r => println(s"${r.mkString(",")}"))


}
