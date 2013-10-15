package pl.project13.scala.warsjawa

import java.util.Properties
import java.io.{File, FileInputStream}

object MyConfig {

  trait Conf {
    def readFromFile: Properties = {
      val props = new Properties()
      props.load(new FileInputStream(new File("config.properties")))
      props
    }
  }

  trait MongoConfig {
    this: Conf =>

  }

  trait SQSConfig {
    this: Conf =>

  }

}

