package pl.project13.scala.warsjawa

object MyScalaTest {

  implicit class AnyMatcher[String](a: String) {
    def powinienByćRówny(b: String) =
      if (a == b)
        println("OK!")
      else
        throw new AssertionError(s"The value of [$a] did not equal [$b]")
  }

}
