package pl.project13.scala.warsjawa

// the typeclass
trait Writes[T] {
  def write(t: T): String
}

object PropertiesSerializer {

  // todo ???
  class CanBeWritten[A](a: A) {

    def toProperties(implicit writes: Writes[A]): String =
      ??? // todo use writes
  }

}
