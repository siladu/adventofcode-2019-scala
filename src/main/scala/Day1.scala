object Day1 {

  private def partOne(input: Seq[Int]): Unit = {
    println(s"Part One = ${ input.map(calcFuel).sum }")
  }

  private def calcFuel(x: Int): Int = x.toInt / 3 - 2

  private def partTwo(input: Seq[Int]): Unit = {

    def calcFuelRec(in: Int): Int = {

      calcFuel(in) match {
        case res if (res <= 0) => 0
        case res => res + calcFuelRec(res)
      }

//      @scala.annotation.tailrec
//      def loop(i: Int, acc: Int): Int = {
//        if (calcFuel(i) <= 0) acc
//        else loop(calcFuel(i), acc + calcFuel(i))
//      }
//      loop(in, 0) //5180690
    }

    println(s"Part Two = ${ input.map(calcFuelRec).sum }") //10367833
  }

  def main(args: Array[String]): Unit = {

    def runParts(input: Seq[String]): Unit = {
      partOne(input.map(_.toInt))
      partTwo(input.map(_.toInt))
    }

    Runner.timedRun(1)(runParts)
  }
}