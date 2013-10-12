package pl.project13.scala.warsjawa

object MyOption {
  def apply[A](in: A): MyOption[A] =
    if (in == null)
      None
    else
      new Some(in)
}

sealed trait MyOption[+A] {

  def get: A

  def isEmpty: Boolean

  def isDefined: Boolean = !isEmpty


  // call by name
  def getOrElse[B >: A](default: => B): B



  def map[B](f : A => B): MyOption[B]

  def filter(p: A => Boolean): MyOption[A]


  def flatMap[B](f : A => MyOption[B])
  : MyOption[B] = ???

}

/* todo case */
class Some[A](t: A) extends MyOption[A] {
  def get = t

  def isEmpty = false

  def getOrElse[B >: A](default: => B) = get

  def map[B](f: (A) => B): MyOption[B] = new Some(f(get))

  def filter(p: (A) => Boolean): MyOption[A] = if(p(t)) this else None
}

object None extends MyOption[Nothing]{
  def get = throw new NullPointerException("Was None!")

  def isEmpty = true

  def getOrElse[T](default: => T) = default

  def map[B](f: (Nothing) => B): MyOption[B] = this

  def filter(p: (Nothing) => Boolean): MyOption[Nothing] = None
}

