package pl.project13.scala.warsjawa

object PartialFunctions {

  val func = (a: Int) => a * 2

  val partialFunc: PartialFunction[Int, Int] = {
    case a if a < 0 => -a
  }

  // Map as a partial function

  val map = Map[String, Int](
    "1" -> 1,
    "2" -> 2,
    "3" -> 3
  )

}
