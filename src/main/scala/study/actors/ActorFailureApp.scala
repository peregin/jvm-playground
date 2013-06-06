package study.actors

import akka.actor.{Actor, Props, ActorSystem}
import java.util.concurrent.atomic.AtomicInteger


object ActorFailureApp extends App {

  sealed trait AMessage
  case class DoSomething(number: Int) extends AMessage
  case object DoMess extends AMessage

  trait SuspendableActor extends Actor {
    def isSuspended: Boolean
    def process: PartialFunction[Any, Unit]

    final def receive = {
      case whatever if (!isSuspended) => process(whatever)
    }
  }

  class WorkerActor(getSuspendedStatus: => Boolean) extends SuspendableActor {

    def isSuspended = getSuspendedStatus

    def process = {
      case DoSomething(number) => {
        val message = "how do you do, sir(%d)? status=%s, from thread %s, instance %s".format(number, getSuspendedStatus, Thread.currentThread.getName, hashCode())
        println(message)
        sender ! message
      }
      case DoMess => {
        val message = "boom, status=%s, from thread %s, instance %s".format(getSuspendedStatus, Thread.currentThread.getName, hashCode())
        println(message)
        throw new IllegalStateException(message)
      }
      case what => println("unknown request %s" format what)
    }
  }

  val system = ActorSystem("test-system")


  val counter = new AtomicInteger(0)
  def getMySuspendedStatus = {
    counter.incrementAndGet < 3
  }

  val myActor = system.actorOf(Props(new WorkerActor(getMySuspendedStatus)), "myactor")

  myActor ! DoSomething(1)
  myActor ! DoMess

  myActor ! DoSomething(2)
  myActor ! DoSomething(3)
  myActor ! DoMess
  Thread.sleep(1000)

  myActor ! DoSomething(4)
  myActor ! DoSomething(5)

  Thread.sleep(1000)
  system.shutdown
}