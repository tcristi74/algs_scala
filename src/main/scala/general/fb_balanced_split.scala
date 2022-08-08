package general

object fb_balanced_split {

  def main(args: Array[String]) {
    // Call balancedSplitExists() with test cases here
    val arr: Array[Int] = Array(1, 5, 7, 1, 4, 4, 8)
    val ret = balancedSplitExists(arr)
    require(ret == true)
    println(ret)
  }

  def balancedSplitExists(arr: Array[Int]): Boolean = {
    //order
    val ar1 = arr.sorted.clone()
    val arrSum: Int = ar1.reduce((x, y) => x + y)
    if (arrSum % 2 > 0) {
      //element sum is odd
      false
    }
    else {
      //find middle
      var tsum: Int = 0
      var index: Int = -1
      for (x <- 0 until (ar1.length - 1); if arrSum / 2 > tsum) {
        tsum += ar1(x)
        index = x
      }
      if (tsum != arrSum / 2) {
        false
      }
      else {
        println(ar1.splitAt(index + 1)._1.toList)
        println(ar1.splitAt(index + 1)._2.toList)
        true

      }
    }
  }
}
