package pl.project13.scala.warsjawa

object PartialFunctions {

  val part: PartialFunction[Int, String] = {
    case n if n > 0 => n.toString
    case n          => "too small!"
  }

  // todo compare with errors from a Map[Int, String]


}
