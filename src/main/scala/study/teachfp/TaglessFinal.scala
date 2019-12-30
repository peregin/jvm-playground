package study.teachfp

import scalaz.{Monad, OptionT}
import scalaz.syntax.std.option._
import study.teachfp.FutureInstances.monadInstance

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

trait Storage[M[_]] {
  def store(): M[Boolean]
  def find(): M[Option[Long]]
}

class DemoStorage[M[_]: Monad] extends Storage[M] {
  override def store(): M[Boolean] = Monad[M].point(true)
  override def find(): M[Option[Long]] = Monad[M].point(42L.some)
}

object TaglessFinal extends App {

  val s1 = new DemoStorage[Future]
  val s2 = new DemoStorage[Future]
  val resOT = for {
    f1 <- OptionT(s1.find())
    f2 <- OptionT(s2.find())
  } yield f1+f2

  val res = Await.result(resOT.run, 30.seconds).mkString

  println(s"result is $res ...")
}
