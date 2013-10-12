package pl.project13.scala.warsjawa

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class MyOptionTest extends FlatSpec with ShouldMatchers {

  behavior of "MyOption"

  it should "be none for null" in {
    // given
    val option = MyOption(null)

    // when
    val exception = intercept[NullPointerException] {
      option.get
    }

    // then
    exception.getMessage should include ("None")
  }

}
