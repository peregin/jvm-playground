package study.actors

import akka.actor.{Actor, Props, ActorSystem}


object ActorFailureApp extends App {

  case object DoSomething

  case object DoMess

  class WorkerActor(getStatus: => Boolean) extends Actor {
    def receive = {
      case DoSomething => {
        val message = "how do you do, sir? status=%s, from thread %s, instance %s".format(getStatus, Thread.currentThread.getName, hashCode())
        println(message)
        sender ! message
      }
      case DoMess => {
        val message = "boom, status=%s, from thread %s, instance %s".format(getStatus, Thread.currentThread.getName, hashCode())
        println(message)
        throw new IllegalStateException(message)
      }
      case what => println("unknown request %s" format what)
    }
  }

  val system = ActorSystem("test-system")


  def getMyStatus = true

  val myActor = system.actorOf(Props(new WorkerActor(getMyStatus)), "myactor")

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