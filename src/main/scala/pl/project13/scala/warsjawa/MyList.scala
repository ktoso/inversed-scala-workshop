//package pl.project13.scala.warsjawa
//
//object MyList {
//  def empty = MyNil
//}
//
//trait MyList[+A] {
//  def head: A = ???
//  def headOption: Option[A] = ???
//
//  def tail: MyList[A] = ???
//  def isEmpty: Boolean = ???
//
//  def foreach[B](f: A => B) = ???
////  def foreach[B](f: A => B) {
////    f(head)
////    tail foreach f
////  }
//
////  def ::[B >: A] (x: B): MyList[B] = new ::(x, this)
//
//}
//
//class ::[B](head: B, tail: MyList[B]) extends MyList[B] {
//
//}
//
//case object MyNil extends MyList[Nothing] {
//  override def isEmpty = ???
//  override def head: Nothing = ???
//  override def tail: List[Nothing] = ???
//}
//
