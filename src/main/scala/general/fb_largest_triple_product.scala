package general

import scala.collection.SortedSet

// We don’t provide test cases in this language yet, but have outlined the signature for you. Please write your code below, and don’t forget to test edge cases!
object fb_largest_triple_product {

  def main(args: Array[String]) {
    // Call findMaxProduct() with test cases here
    val arr: Array[Int] = Array(1, 2, 3, 4, 5)
    val ret = findMaxProduct(arr)
    println(ret.toList)
  }

  def findMaxProduct(arr: Array[Int]): Array[Int] = {
    // Write your code here
    require(arr.length > 2)
    var ss: SortedSet[Int] = SortedSet(arr(0), arr(1))(Ordering[Int].reverse)
    var clone: Array[Int] = Array(-1, -1)
    var clone2: Array[Int] = Array(-1, -1)
    for (i <- 2 to arr.length - 1) {
      ss += arr(i)
      clone = clone :+ get3Max(arr.take(i + 1))
      clone2 = clone2 :+ ss.slice(0, 3).reduce((a, b) => a * b)
    }

    clone

  }

  def get3Max(spliArr: Array[Int]): Int = {
    val sArray = spliArr.sortBy(_.toInt).reverse
    sArray(0) * sArray(1) * sArray(2)

  }

}
