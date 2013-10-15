package pl.project13.scala.warsjawa

trait Writes[T] {
  def write(t: T): String
}

object PropertiesSerializer {

  implicit val writes = new Writes[Map[String, String]] {
    def write(t: Map[String, String]): String = {
      t.map {
        case (key, value) =>
          s"""$key=$value"""
      } mkString("\n")
    }
  }

  implicit class CanBeWritten[A](a: A) {

    def toProperties(implicit writes: Writes[A]): String =
      writes.write(a)
  }

}
