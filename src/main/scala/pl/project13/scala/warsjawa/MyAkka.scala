package pl.project13.scala.warsjawa

import java.util.concurrent.Executors

abstract class MyActor {

  def recieve: PartialFunction[Any, Any]
}

class MyActorSystem {
  Executors.newFixedThreadPool(Runtime.getRuntime.availableProcessors)
}