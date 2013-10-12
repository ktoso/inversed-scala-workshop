package pl.project13.scala.warsjawa

object MyOwnStringInterpolator {

  implicit class PropertiesHelper(val sc: StringContext) extends AnyVal {

    def properties(args: Any*): Map[String, String] = {
      val strings = sc.parts.iterator
      val expressions = args.iterator

      val buf = new StringBuffer(strings.next)
      while (strings.hasNext) {
        buf append expressions.next
        buf append strings.next
      }

      val keyValuePairs = for {
        line <- buf.toString.split("\n")
        pos = line.indexOf('=')
        if pos > 0
        key = line.substring(0, pos)
        value = line.substring(pos, line.length - 1)
      } yield key -> value

      keyValuePairs.toMap
    }
  }


}
