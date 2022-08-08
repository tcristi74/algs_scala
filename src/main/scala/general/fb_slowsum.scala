package general

// We don’t provide test cases in this language yet, but have outlined the signature for you. Please write your code below, and don’t forget to test edge cases!
object fb_slowsum {

  def main(args: Array[String]) {
    // Call getTotalTime() with test cases here
    val arr = Array(4, 2, 1, 3)
    val output = getTotalTime(arr)
    println(output)
  }

  def getTotalTime(arr: Array[Int]): Int = {
    // Write your code here
    arr match {
      case x if x.length == 0 => 0
      case x if x.length == 1 => x(0)
      case _ => {
        val ordArray = arr.sortBy(-_)
        var totalSum: Int = 0
        var prevSum = ordArray(0)
        for (i <- 1 to (ordArray.length - 1)) {
          prevSum = prevSum + ordArray(i)
          totalSum += prevSum
        }
        totalSum
      }
    }
  }
}
