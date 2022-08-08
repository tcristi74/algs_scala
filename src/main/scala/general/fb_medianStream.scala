package general

import scala.collection.SortedSet
import scala.collection.mutable.ArrayBuffer

object fb_medianStream {

  def main(args: Array[String]) {
    // Call findMedian() with test cases here

    val arr = Array(5, 15, 1, 3)
    val output = findMedianBruteForce(arr)
    println(output.toList)
    val output2 = findMedianSortedMap(arr)
    println(output2.toList)
  }


  def findMedianSortedMap(arr: Array[Int]): Array[Double] = {
    // Write your code here
    val res: ArrayBuffer[Double] = ArrayBuffer.empty
    var sm: SortedSet[Int] = SortedSet.empty

    for (i <- 0 to (arr.length - 1)) {
      sm += arr(i)
      val med = getMedianFromSortedSet(sm)
      res += med
    }
    res.toArray
  }

  def findMedianBruteForce(arr: Array[Int]): Array[Double] = {
    // Write your code here
    val res: ArrayBuffer[Double] = ArrayBuffer.empty
    for (i <- 0 to (arr.length - 1)) {
      val tarr = arr.take(i + 1).sorted
      val med = getMedian(tarr)
      res += med
    }
    res.toArray

  }

  def getMedian(sortedArr: Array[Int]): Double = {

    val l = sortedArr.length

    if (l % 2 == 0) {
      (sortedArr(l / 2 - 1) + sortedArr(l / 2)) / 2
    }
    else {
      sortedArr((l) / 2)
    }
  }

  def getMedianFromSortedSet(set: SortedSet[Int]): Double = {
    set match {
      case x if x.size == 0 => 0
      case _ => {
        val l = set.size
        val ns = set.slice(l / 2 - 1, l / 2 + 1)
        ns match {
          case x if x.size == 1 => x.head
          case _ => (ns.last + ns.head) / 2
        }
      }
    }
  }
}
