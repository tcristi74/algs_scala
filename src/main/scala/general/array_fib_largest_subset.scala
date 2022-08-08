package general

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

object array_fib_largest_subset {
  //Question: You are given an array with positive numbers. Explain how you will find the largest subset of the array containing elements that are Fibonacci numbers.
  def main(args: Array[String]): Unit = {

    val ar: ArrayBuffer[Long] = ArrayBuffer(4, 5, 1, 2)
    for (x <- 0 to 10000) {
      ar += new Random().nextLong(math.pow(10, 2).toLong)
    }
    val fibSet = getFibNumbersIntoMap(ar.maxBy(p => p))
    println(fibSet.toList)
    val t = getLargestSubset(fibSet, ar)
    println(t)
    var res = for (x <- t._1 to t._2) yield ar(x)
    println(res.toList)


  }

  def getLargestSubset(fibSet: Set[Long], ar: ArrayBuffer[Long]): (Int, Int) = {
    var startIndex: Int = 0
    var endIndex: Int = 0
    var tStart: Int = -1
    var tEnd: Int = -1
    for (e <- ar.indices) {
      if (fibSet(ar(e))) {
        if (tStart < 0) {
          tStart = e
        }
        tEnd = e
      }
      else {
        //cannot find it
        if (tEnd - tStart > endIndex - startIndex) {
          startIndex = tStart
          endIndex = tEnd
        }
        tStart = -1
        tEnd = -1

      }
    }
    if (tStart > 0 && tEnd - tStart > endIndex - startIndex) {
      startIndex = tStart
      endIndex = tEnd
    }
    startIndex -> endIndex

  }


  def getFibNumbersIntoMap(maxNo: Long): Set[Long] = {
    var ar: Set[Long] = Set(1)
    var prev = 1
    var cur = 1
    while (cur <= maxNo) {
      ar += cur + prev
      val t = cur
      cur = prev + cur
      prev = t
    }
    ar
  }


}
