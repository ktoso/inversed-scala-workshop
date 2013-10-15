package pl.project13.scala.warsjawa

object MyOption {

  /** go from a nullable value, into an Option, so it can be either Some(value) or None */
  def apply[A](in: A): MyOption[A] =
    ???
}

trait MyOption[+A] {

  /** get the value, or blow up if None*/
  def get: A = ???

  /** true if has some value inside */
  def isEmpty: Boolean = ???

  /** opposite of isEmpty, true if no value inside */
  def isDefined: Boolean = ???


  /** get the value inside for Some, or for None, return the default */
  def getOrElse[B >: A](default: => B): B = ??? // todo what about getOrElse { throw new Exception("Boom!") }


  // more functional things

  /** Map to a different value, what to do with None? */
  def map[B]    (f : A =>          B): MyOption[B] = ???

  /** given a function that can fail, return a None or Some here */
  def flatMap[B](f : A => MyOption[B]): MyOption[B] = ???

  /** if precicate applies, keep Some, else return a None */
  def filter(p: A => Boolean): MyOption[A] = ???

}

/* todo case */
class Some[A](value: A) extends MyOption[A] {

  // todo implement stuff here!
}

//class None[A] extends MyOption[A] { // todo what Type do we need here?
//  // todo implement this stuff
//}

