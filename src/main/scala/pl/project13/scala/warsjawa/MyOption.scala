package pl.project13.scala.warsjawa

object MyOption {
  def apply[A](in: A): MyOption[A] = ???
}

sealed trait MyOption[A] {
  def get: A = ???

  def isEmpty: Boolean = ???

  def isDefined: Boolean = ???

  def getOrElse(default: A): A = ???
  
  def map[B](f : scala.Function1[A, B]): MyOption[B] = ???

  def flatMap[B](f : A => MyOption[B]): MyOption[B] = ???
}

/* todo case */
class Some[A](t: A) // todo extends

/* todo object */
class None // todo extends

