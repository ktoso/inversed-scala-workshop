package pl.project13.scala.warsjawa

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class PartialFunctionsTest extends FlatSpec with ShouldMatchers {

  import PartialFunctions._


  it should "explode" in {
    val got = intercept[Exception] {
      partialFunc(23)
    }
  }
}
