package study.teachfp

import scalaz.{-\/, EitherT, \/-, \/}

import scala.concurrent.Future
import scalaz.syntax.std.ToOptionOps
import scalaz.syntax.std.option._


import scala.concurrent.ExecutionContext.Implicits.global

import scalaz._
import Scalaz._

abstract class Err(id: Int)
final case class NotFound(message: String) extends Err(404)
final object NoContent extends Err(204)


case class Activity(name: String)

object ErrorTest extends App with ToOptionOps {

  def find(name: String): EitherT[Err, Future, Activity] = for {
    res <- EitherT(
      lookup(name).map(_.toRightDisjunction(NotFound("what")).widen).map(_.widen[Err, Activity]) //.map(_.asInstanceOf[Err \/ Activity])
    )
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
