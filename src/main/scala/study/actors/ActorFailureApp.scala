package study.actors

import akka.actor.Actor


class ActorFailureApp extends App {

  case object DoSomething
  case object DoMess

  class WorkerActor extends Actor {
    def receive = {
      case DoSomething => {
        val message = "how do you do, sir? from thread %s" format Thread.currentThread.getName
        println(message)
        sender ! message
      }
      case DoMess => {
        val message = "boom, from thread %s" format Thread.currentThread.getName
        println(message)
        throw new IllegalStateException(message)
      }
      case what => println("unknown request %s" format what)
    }
  }
}