package pl.project13.scala.warsjawa

trait Writes[T] {
  def write(t: T): String
}

object PropertiesSerializer {

  implicit val writes = ???

  // ???
  class CanBeWritten[A](a: A) {

    def toProperties(implicit writes: Writes[A]): String = ???
  }

}
