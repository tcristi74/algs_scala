package general

// We don’t provide test cases in this language yet, but have outlined the signature for you. Please write your code below, and don’t forget to test edge cases!
object fb_lexico_smaller {

  def main(args: Array[String]) {
    // Call findMinArray() with test cases here
    val arr: Array[Int] = Array(8, 9, 11, 2, 1)
    val k: Int = 3
    val res = findMinArray(arr, k)
    println(res)
  }

  def findMinArray(arr: Array[Int], k: Int): Array[Int] = {
    // Write your code here
    val retArray: Array[Int] = arr.clone()
    var minIndex: Int = 0
    var minVal: Int = Int.MaxValue
    for (i <- 0 to (arr.length - 1); if i <= k) {
      if (minVal > arr(i)) {
        minVal = arr(i)
        minIndex = i
      }
    }
    if (minIndex > 0) {
      adjancentSwap(retArray, minIndex)
    }
    else {
      arr
    }
  }

  def adjancentSwap(arr: Array[Int], startIndex: Int): Array[Int] = {
    if (startIndex == 0) arr
    else {
      val left: Int = arr(startIndex - 1)
      arr(startIndex - 1) = arr(startIndex)
      arr(startIndex) = left
      adjancentSwap(arr, startIndex - 1)
    }
  }

}
