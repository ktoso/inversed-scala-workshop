package pl.project13.scala.warsjawa


object StrucutralTypes {

  def close(canClose: { def close() }) = {
    canClose.close()
  }

}