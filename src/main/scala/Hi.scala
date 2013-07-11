

object Hi extends App {
  for (i <- 0 to (10, 2)) println(i)
  println("hi----------")

  val pattern = """hello_(t_)(\d+)*(BON)*""".r

  //test("hello")
  test("hello_t_1234_bing_BONgola")

  def test(in: String) {
    pattern.findAllIn(in).matchData.foreach{m =>
      val gc = m.groupCount
      println(gc)
      for (i <- 1 to gc) println(m.group(i))
    }
  }
}
