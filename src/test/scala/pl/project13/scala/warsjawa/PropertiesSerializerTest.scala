package pl.project13.scala.warsjawa

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class PropertiesSerializerTest extends FlatSpec
  with ShouldMatchers {

  behavior of "PropertiesSerializer"

  it should "write" in {
    // given
    import PropertiesSerializer._

    val map = Map(
      "value" -> "1",
      "test" -> "2"
    )

    // when
    val got = map.toProperties

    // then
    got should equal (
      """|value=1
         |test=2
         |""".stripMargin)
  }

}
