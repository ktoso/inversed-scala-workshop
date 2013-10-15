package pl.project13.scala.warsjawa

import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer
import scala.collection.immutable.List
import scala.List

abstract class MyList[+A] {

  def head: A
  def headOption: Option[A]

  def tail: MyList[A]
  def isEmpty: Boolean

  def foreach(f: A => Unit) {
    f(head)
    tail foreach f
  }

  def contains(Check: A): Boolean =
    head == Check || tail.contains(Check)

}

class ::[+A](hd: A, tl: MyList[A]) extends MyList[A] {
  override def head : A = hd

  override def tail : MyList[A] = tl

  override def isEmpty: Boolean = false
}

//case object MyNil extends MyList[Nothing] {
//  override def isEmpty = true
//}

