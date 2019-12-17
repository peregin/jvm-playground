package study.teachfp

import scalaz.{Cord, Kleisli, Show}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


object FpTest extends App {

  // session 1 type classes
  // session 2 monoids
  // session 3 monads
  // session 4 monad transformers
  // session 5 kleisli
  // session 6 io effects

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
  val listCars: Kleisli[Future, Seq[User], Seq[Car]] = Kleisli(_ => listCarsFromDb())
  val pipeline = listUsers >==> listCars
}
