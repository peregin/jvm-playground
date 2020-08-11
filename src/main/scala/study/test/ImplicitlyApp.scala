package study.test

object ImplicitlyApp extends App {

  val x: Int = 3
  implicit val xx = x.toString

  val a = implicitly[String]

  test(a)

  def test(s: String): Unit = println(s)
}
