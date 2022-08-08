package general

object fb_uniformIntegers {

  def main(args: Array[String]) {
    val a = 1256
    val b = 563666
    val getCountForLength: (Int, Int) => Int = (a, b) => {
      val uniformList = for (g <- a.toString.length to b.toString.length; v <- 1 to 9) yield
        (for (x <- 0 until g) yield v).mkString("").toInt

      println(uniformList.toList)
      uniformList.count(p => p >= a && p <= b)
    }
    val output = getCountForLength(a, b)
    println(output)

  }


}
