package pl.project13.scala.warsjawa

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class MyOptionTest
  extends FlatSpec
  with ShouldMatchers {

  behavior of "MyOption"

  it should "be none for null" in {
    // given
    val option = MyOption.apply(null)

    // when
    val exception = intercept[NullPointerException] {
      option.get
    }

    // then
    exception.getMessage should include ("None")
  }

  it should "be empty for null" in {
    // when
    val option = MyOption(null)

    // then
    option should be ('empty)
    option.isEmpty should be (true)
  }

  it should "getOrElse the value from inside" in {
    // given
    val thing = MyOption(null)

    // when
//    thing getOrElse {
//      throw new Exception("AAAA")
//    }

    // then
//    got should equal ("Banana")
  }

  it should "map a value" in {
    // given
    val opt = MyOption(22)

    // when
    val thing = opt.map(_ * 2)

    // then
    thing.get should equal (44)
  }

  it should "ignore mapping a value" in {
    // given
    val opt: MyOption[java.lang.Integer] = MyOption(null)

    // when
    val thing = opt.map(_ * 2)

    // then
    thing.isEmpty should be (true)
  }

  it should "filter out a value" in {
    // given
    val want = 2

    val opt = MyOption(5)

    // when
    val got = opt filter { _ == want}

    // then
    got.isEmpty should be (true)
  }

}
