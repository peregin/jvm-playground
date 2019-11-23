package study.teachfp

import scalaz.Bind

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object FutureInstance {

  implicit val futureInstance = new Bind[Future] {
    override def bind[A, B](fa: Future[A])(f: A => Future[B]): Future[B] = fa.flatMap(f)
    override def map[A, B](fa: Future[A])(f: A => B): Future[B] = fa.map(f)
  }
}
