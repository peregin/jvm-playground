package study.teachfp

import scalaz.{Cord, Kleisli, Show}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
 * FP sessions + hands on
 * ======================
 *
 * various manifestations of polymorphism
 * type classes
 * for comprehensions
 * monoids
 * functors, applicatives
 * validations
 * monads
 * monad transformers (option, either)
 * kleisli
 * writer, state
 * io effects / zio
 * data structures (Nel, Nec, etc)
 */
object TeachFpTopics extends App {

  case class Pair[A](p1: A, p2: A) {
    @inline final def map[B](f: A => B) = Pair(f(p1), f(p2))
    @inline final def flatMap[B](f: A => Pair[B]) = f
  }
  val pair1 = Pair(1, 10)
  val pair2 = Pair("a", "b")

  val res = for {
    a1 <- pair1
    a2 <- pair2
  } yield
  println(s"pair res is = $res")

  // define some models used during the examples
  case class User(id: Long, name: String, age: Int)
  case class Car(id: Long, name: String)

  val user1 = User(1, "Gandalf", 100)
  val user2 = User(2, "Frodo", 12)
  val car1 = Car(1, "Honda")

  def listCarsFromDb(): Future[Seq[Car]] = Future(Seq(car1))
  def getCarFromDb(id: Long): Future[Option[Car]] = listCarsFromDb().map(_.find(_.id == id))
  def listUsersFromDb(): Future[Seq[User]] = Future(Seq(user1, user2))
  def getUserFromDb(id: Long): Future[Option[User]] = listUsersFromDb().map(_.find(_.id == id))

  // example with show
  def show[A: Show](a: A) = implicitly[Show[A]].show(a)
  implicit val carShow = new Show[Car] {
    override def show(f: Car): Cord = Cord.stringToCord(f.name)
  }
  implicit class ShowOps[A: Show](a: A) {
    def show: Cord = Show[A].show(a)
  }
  println(show(car1))
  println(car1.show)

  // make a serializer // json/google proto/thrift typeclasses 101
  import FutureInstances._

  val listUsers: Kleisli[Future, Unit, Seq[User]] = Kleisli(_ => listUsersFromDb())
  val listCars: Kleisli[Future, Seq[User], Seq[Car]] = Kleisli(users => listCarsFromDb())
  val pipeline = listUsers >==> listCars
  val result = pipeline.run
  println(s"res=$result")
}
