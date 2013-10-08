import sbt._
import Keys._

object Dependencies {

  val apacheIo  = "org.apache.commons" % "commons-io" % "1.3.2"
  val guava     = "com.google.guava"   % "guava"      % "14.0.1"

  val rogueVersion    = "2.2.0"
  val rogueField      = "com.foursquare" %% "rogue-field"         % rogueVersion intransitive()
  val rogueCore       = "com.foursquare" %% "rogue-core"          % rogueVersion intransitive()
  val rogueLift       = "com.foursquare" %% "rogue-lift"          % rogueVersion intransitive()

  val rogueIndex      = "com.foursquare" %% "rogue-index"         % "2.2.0" intransitive()
  val liftMongoRecord = "net.liftweb"    %% "lift-mongodb-record" % "2.5.1"

  val json4sJackson = "org.json4s" %% "json4s-jackson" % "3.2.4"

  // joda time
  val jodaTime        = "joda-time" % "joda-time"    % "2.1"
  val jodaTimeConvert = "org.joda"  % "joda-convert" % "1.2"

  val jsr305    = "com.google.code.findbugs" % "jsr305" % "1.3.9"

  // testing
  val scalaTest = "org.scalatest"  % "scalatest_2.10" % "1.9.1"
  val mockito   = "org.mockito"    % "mockito-all"    % "1.9.5"
  val fongo     = "com.foursquare" % "fongo"          % "1.2.0"
  
// groups of dependencies ---------------------------------------------------


  val mongoRogueAll = Seq(rogueField, rogueCore, rogueLift, rogueIndex, liftMongoRecord)

  val testingAll  = Seq(scalaTest, mockito) map { _ % "test" }
  val jodaTimeAll = Seq(jodaTime, jodaTimeConvert)

}
