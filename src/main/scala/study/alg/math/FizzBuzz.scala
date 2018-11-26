package study.alg.math

class FizzBuzz {

  def fizzBuzz(A: Int): Array[String]  = {
    (1 to A).map(_ match {
      case x if x % 3 == 0 && x % 5 == 0 => "FizzBuzz"
      case y if y % 3 == 0 => "Fizz"
      case z if z % 5 == 0 => "Buzz"
      case n => n.toString
    }).toArray
  }
}
