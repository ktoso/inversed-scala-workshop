package pl.project13.scala.warsjawa

import scala.collection.immutable.List
import scala.annotation.tailrec

//  https://gist.github.com/dholbrook/2967371
object TailTreeRecurrsion {

  trait Tree[+A] {

    import scala.annotation.tailrec

    def value: Option[A] = this match {
      case n: Node[A] => Some(n.v)
      case l: Leaf[A] => Some(l.v)
      case Empty      => None
    }

    def left: Option[Tree[A]] = this match {
      case n: Node[A] => Some(n.l)
      case l: Leaf[A] => None
      case Empty      => None
    }

    def right: Option[Tree[A]] = this match {
      case n: Node[A] => Some(n.r)
      case l: Leaf[A] => None
      case Empty      => None
    }

    /**
     * Represents a deferred evaluation of a node value
     */
    private case class Eval[A](v: A) extends Tree[A]

    /**
      * fold with inorder traversal (left, root, right)
      * tail recursive optimized
      *
      *        F
      *      /   \
      *    B       G
      *   / \       \
      *  A   D       I
      *     / \     /
      *    C   E   H
      *
      * head evaluate accumulator
      * ---- -------- -----------
      *              | (F)
      * F   | ()     | B::F::G::()
      * B   | ()     | A::B::D::(F,G)
      * A   | (A)    | (B,D,F,G)
      * B   | (B)    | (D,F,G)
      * D   | ()     | C::D::E::(F,G)
      * C   | (C)    | (D,E,F,G)
      * D   | (D)    | (E,F,G)
      * E   | (E)    | (F,G)
      * F   | (F)    | (G)
      * G   | ()     | G::I::()
      * G   | (G)    | (I)
      * I   | ()     | H::I::()
      * H   | (H)    | H
      * I   | (I)    | ()
      *
      * result
      * A,B,C,D,E,F,G,H,I
      */
     def foldInorder[B](z: B)(f: (B, A) => B): B = {
       foldLoop(List(this), z)(f) { (n, tl) => n.l :: Eval(n.v) :: n.r :: tl }
     }


    /**
      * represents common functionality of all traversal order folds
      */
     @tailrec
     private def foldLoop[A, B](a: List[Tree[A]], z: B)(f: (B, A) => B)(o: (Node[A], List[Tree[A]]) => List[Tree[A]]): B = a match {
       case (n: Node[A]) :: tl => foldLoop(o(n, tl), z)(f)(o) // never directly evaluate nodes, function o will create new accumulator
       case (l: Leaf[A]) :: tl => foldLoop(tl, f(z, l.v))(f)(o) // always evaluate Leaf
       case (e: Eval[A]) :: tl => foldLoop(tl, f(z, e.v))(f)(o) // always evaluate Eval
       case Empty :: tl        => foldLoop(tl, z)(f)(o) // ignore Empty
       case _                  => z // will be Nil (empty list)
     }


    /**
      * calls foldInorder
      */
     def fold[B](z: B)(f: (B, A) => B): B = foldInorder(z)(f)


    /**
      * P02
      * (*) Count the number of nodes in a binary tree.
      */
     def size: Int = fold(0) { (sum, v) => sum + 1 }

     /**
      * P03
      * (*) Determine the height of a binary tree.
      * Definition:  The height of a tree is the length of the path from the root to the deepest node in the tree. A (rooted) tree with only one node (the root) has a height of zero.
      */
     def height: Int = {
       def loop(t: Tree[A]): Int = t match {
         case l: Leaf[A] => 1
         case n: Node[A] => Seq(loop(n.left.get), loop(n.right.get)).max + 1
         case _          => 0
       }
       loop(this) - 1
     }
  }

  case class Node[A](v: A, l: Tree[A], r: Tree[A]) extends Tree[A]
  case class Leaf[A](v: A) extends Tree[A]
  case object Empty extends Tree[Nothing]

}
