package pl.project13.scala.warsjawa

import scala.runtime.Nothing$

object MyOwnIf {


  trait HasOtherwise[T] {
    def get: T = throw new Exception("Empty!")
    def otherwise(block: => T): T
  }

  case class FirstCase[T](t: T) extends HasOtherwise[T] {
    override def get = t
    def otherwise(block: => T): T = t
  }

  case class SecondCase[T]() extends HasOtherwise[T] {
    def otherwise(block: => T): T = ???
  }

//  todo implement me
//  def ifAndOnlyIf[T](???)(???): HasOtherwise[T] =
//    ???

}
