package pl.project13.scala.warsjawa

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class MyOwnIfTest extends FlatSpec with ShouldMatchers {
  
  behavior of "MyOwnIf"
  
  import MyOwnIf._

  def makeMeCompile(b: Boolean) =
    ifAndOnlyIf(b) { "yes!" }

  def makeMeCompile2(b: Boolean): String =
    ifAndOnlyIf(b) { "yes!" } otherwise { "no!" }

  it should "say yes when true" in {
    val value = ifAndOnlyIf(true) { "yes" }

    value.get should equal ("yes")
  }

  it should "say be empty for false" in {
    val value = ifAndOnlyIf(false) { "yes" }

    value should equal (SecondCase())
  }

  it should "say no! when false and otherwise given" in {
    val value = ifAndOnlyIf(false) { "yes" } otherwise { "no" }

    value should equal ("no")
  }

}
