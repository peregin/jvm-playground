package study.teachfp

import scalaz._
import scalaz.Scalaz._
//import scalaz.syntax.validation._

object ValTest extends App {

  type ExceptionValidation[T] = Validation[NonEmptyList[Exception], T]

  val v1 = "ok 1".successNel[String]
  //val v2 = new IllegalArgumentException("nope").failureNel[Exception]
  val v2 = "doh".failureNel[String]
  //val v2 = "yuppie".successNel[String]
  val v3 = "ok 3".successNel[String]

  val appls = v1 |@| v2 |@| v3
  val aggr = appls { _ + _ + _ }
  println(aggr)
}
