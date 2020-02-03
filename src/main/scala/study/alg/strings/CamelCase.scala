package study.alg.strings

object CamelCase extends App {

  def camelcase(s: String): Int = {
    s.foldLeft(0)((accu, c) => if (c.isUpper) accu + 1 else accu) + 1
  }
}
