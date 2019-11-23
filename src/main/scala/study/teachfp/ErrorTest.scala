package study.teachfp

import scalaz.{-\/, EitherT, \/-}

import scala.concurrent.Future
import FutureInstance._
import scalaz.syntax._
import scalaz._
import scalaz.std.either._
import syntax.std.option._

import scala.concurrent.ExecutionContext.Implicits.global

abstract class Err(id: Int)
final case class NotFound(message: String) extends Err(404)
final object NoContent extends Err(204)

case class Activity(name: String)

object ErrorTest extends App {

  def find(name: String): EitherT[Future, NotFound, Activity] = for {
    res <- EitherT{
      lookup(name)
        .map(
          _.flatMap(ac => Some(ac)).toRightDisjunction(NotFound("what"))
        )
    }
  } yield res

  val test = find("uetliberg")

  test.run.map{ _ match {
    case -\/(err) => println(s"err is $err")
    case \/-(act) => println(s"activity is $act")
  }
  }

  def lookup(name: String): Future[Option[Activity]] = {
    if (name.isEmpty) Future(None)
    else Future(Some(Activity("uetliberg")))
  }
  println("hello")
}
