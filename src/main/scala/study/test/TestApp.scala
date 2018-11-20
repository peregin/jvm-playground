

object Main {

  def main(args: Array[String]) {

    val ln = "1496"
    val reversedDigits = ln.map(_.asDigit).reverse
    println(reversedDigits)
    val digitsWithDoubles = reversedDigits.zipWithIndex.map{ case (v, ix) => if (ix % 2 == 0) v else v * 2}
    println(digitsWithDoubles)
    val checksumText = digitsWithDoubles.flatMap(_.toString)
    println(checksumText)
    val checksum = checksumText.map(_.asDigit).sum
    println(checksum)
  }
}
