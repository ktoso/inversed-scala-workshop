package pl.project13.scala.warsjawa

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class HelloWorldTest extends FlatSpec with ShouldMatchers {

  it should "add two numbers" in {
    (1 + 2) should equal (3)
  }
}

