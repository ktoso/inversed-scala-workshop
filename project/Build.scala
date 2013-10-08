import sbt._
import sbt.Keys._

import com.typesafe.sbt.SbtScalariform._
import scalariform.formatter.preferences
import scalariform.formatter.preferences.PreferencesImporterExporter

import Dependencies._

import net.virtualvoid.sbt._

import org.sbtidea.SbtIdeaPlugin._

trait Formatting {
  val scalariformSettings =
    defaultScalariformSettings ++ Seq(
      ScalariformKeys.preferences <<= baseDirectory.apply(getScalariformPreferences)
    )

  def getScalariformPreferences(dir: File): scalariform.formatter.preferences.IFormattingPreferences = {
    val inProject = dir / "scalaFormatter.properties"

      if (inProject.exists)
        PreferencesImporterExporter.loadPreferences(inProject.getPath)
      else
        getScalariformPreferences(dir.getParentFile)
  }
}

object ApplicationBuild extends Build with Formatting {

  val appName         = "wars-jawa"
  val appVersion      = "1.0-SNAPSHOT"
  val appScalaVersion = "2.10.3"

  val generalDependencies = Seq(
    jsr305, guava,
    json4sJackson
  ) ++ jodaTimeAll

  val defaultSettings = Seq(
    scalaVersion := appScalaVersion
  ) ++ scalariformSettings

  val root = Project("wars-jawa", file("."))
  .settings(defaultSettings: _*)
  .settings(
    libraryDependencies ++= generalDependencies ++ testingAll,
    ideaExcludeFolders := ".idea" :: ".idea_modules" :: Nil
  )

}
