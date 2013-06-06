package study.actors

import akka.actor.{Actor, Props, ActorSystem}


object ActorFailureApp extends App {

  sealed trait AMessage
  case object DoSomething extends AMessage
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
      case DoSomething => {
        val message = "how do you do, sir? status=%s, from thread %s, instance %s".format(getSuspendedStatus, Thread.currentThread.getName, hashCode())
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


  def getMySuspendedStatus = true

  val myActor = system.actorOf(Props(new WorkerActor(getMySuspendedStatus)), "myactor")

  myActor ! DoSomething
  //println("reply %s" format Await.resultOrException(myActor ? DoSomething))
  myActor ! DoMess

  myActor ! DoSomething
  myActor ! DoMess
  myActor ! DoMess
  myActor ! DoMess
  myActor ! DoMess
  myActor ! DoMess
  //println("reply %s" format Await.resultOrException(myActor ? DoSomething))
  Thread.sleep(1000)

  myActor ! DoSomething
  myActor ! DoSomething
  //println("reply %s" format Await.resultOrException(myActor ? DoSomething))
  //println("reply %s" format Await.resultOrException(myActor ? DoSomething))

  Thread.sleep(1000)
  system.shutdown
}