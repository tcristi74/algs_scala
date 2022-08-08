package general

// We don’t provide test cases in this language yet, but have outlined the signature for you. Please write your code below, and don’t forget to test edge cases!
object fb_pairSums {

  def main(args: Array[String]) {
    // Call numberOfWays() with test cases here
    var arr: Array[Int] = Array(2, 4, 9, 2, 5, 2, 0)
    var k: Int = 4
    val cnt1 = if (arr.length > 1) numberOfWays(arr, k) else 0
    require(cnt1 == 4)
    arr = Array(1, 5, 3, 3, 3)
    k = 6
    val cnt2 = if (arr.length > 1) numberOfWays(arr, k) else 0
    require(cnt2 == 4)
  }

  def numberOfWays(arr: Array[Int], k: Int): Int = {
    var pairs: Int = 0
    for (i <- 0 to arr.length - 1) {
      val valToFind = k - arr(i)
      pairs = pairs + (i + 1 to arr.length - 1).count(x => arr(x) == valToFind)
    }
    println(pairs)
    pairs
  }
}
