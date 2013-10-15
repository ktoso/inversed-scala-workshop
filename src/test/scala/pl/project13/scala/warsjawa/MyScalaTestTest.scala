package pl.project13.scala.warsjawa

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class MyScalaTestTest extends FlatSpec with ShouldMatchers {

  import MyScalaTest._

  it should "throw an assertion error" in{
    val ex = intercept[AssertionError] {
//      "nietoperz" powinienByćRówny "bananowi" // todo make me compile
    }
  }

}
