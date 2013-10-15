package pl.project13.scala.warsjawa

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class CurryThisStuffTest extends FlatSpec with ShouldMatchers {

  behavior of "Currying"
  
  import CurryThisStuff._
  
  it should "give me a function prepared to add 22 to something" in {
    // given
    val adds22: Int => Int = ??? // todo use CurryThisStuff.addThings

    // when
    val got = adds22(2)

    // then
    got should equal (24)
  }
  
}
