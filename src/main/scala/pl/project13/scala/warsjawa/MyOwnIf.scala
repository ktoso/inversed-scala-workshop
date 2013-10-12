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
    def otherwise(block: => T): T = block
  }

  def ifAndOnlyIf[T](b: Boolean)(block: => T): HasOtherwise[T] =
    if (b) FirstCase(block) else SecondCase()


//  implicit def makeNothing[T](has: HasOtherwise[T]): T = has match {
//    case FirstCase(value) => value
//    case _ => null
//  }

  def makeMeCompile(b: Boolean) =
    ifAndOnlyIf(b) { "yes!" }

  def makeMeCompile2(b: Boolean): String =
    ifAndOnlyIf(b) { "yes!" } otherwise { "no!" }

}
