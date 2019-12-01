import scala.io.{BufferedSource, Source}

object Runner {

  def timedRun(day: Int)(run: Seq[String] => Unit) {
    val start = System.nanoTime()
    val inputFile = s"src/main/resources/day$day-input.txt"

    try {
      val file: BufferedSource = Source.fromFile(inputFile)
      val input: Seq[String] = file.getLines().toSeq
      run(input)
      file.close()
    } catch {
      case e: Throwable =>
        println(e)
        run(Nil)
    }

    val timeInNanos = System.nanoTime() - start
    println(s"Time in nanos: $timeInNanos")
    println("Time in millis: " + timeInNanos / Math.pow(10.0, 6.0))
    println("Time in seconds: " + timeInNanos / Math.pow(10.0, 9.0))
  }
}