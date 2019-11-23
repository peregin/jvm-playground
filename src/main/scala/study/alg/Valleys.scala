package study.alg

object Valleys {

  // Complete the countingValleys function below.
  def countingValleys(n: Int, s: String): Int = {
    var level = 0
    var valleys = 0
    for (c <- s) {
      c match {
        case 'U' if level == -1 =>
          valleys = valleys + 1
          level = level + 1
        case 'U' =>
          level = level + 1
        case 'D' =>
          level = level - 1
        case he =>
          throw new IllegalArgumentException(s"unexpected character $he")
      }
    }
    valleys
  }

  def main(args: Array[String]): Unit = {
    val s = "UDDDUDUU"
    val result = countingValleys(s.length, s)
    println(s"valleys = $result")
  }
}
