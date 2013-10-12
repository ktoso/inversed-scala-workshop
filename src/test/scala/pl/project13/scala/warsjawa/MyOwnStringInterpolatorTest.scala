package pl.project13.scala.warsjawa

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FlatSpec

class MyOwnStringInterpolatorTest extends FlatSpec with ShouldMatchers {

  import MyOwnStringInterpolator._

  it should "make a map" in {
    val thing: Map[String, String] = properties"""thing=banana"""

    thing should contain key ("thing")
  }

}
