package pl.project13.scala.warsjawa

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers

class PropertiesSerializerTest extends FlatSpec
  with ShouldMatchers {

  behavior of "PropertiesSerializer"

  implicit val writes = ??? // todo provide instance of typeclass


  it should "write" in {
    // given
    import PropertiesSerializer._

    val map = Map(
      "value" -> "1",
      "test" -> "2"
    )

    // when
//    val got = map.toProperties // todo make this compile!

    // then
//    got should equal (
//      """|value=1
//         |test=2""".stripMargin)
  }

}
