package general

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object array_largest_sum_subarray_k {
  /*  Largest sum subarray with at-least k numbers

  Difficulty Level : Hard
  Last Updated : 01 Sep, 2021

  Given an array, find the subarray (containing at least k numbers) which has the largest sum.
  Input : arr[] = {-4, -2, 1, -3}
  k = 2
  Output : -1
  The sub array is {-2, 1}

  Input : arr[] = {1, 1, 1, 1, 1, 1}
  k = 2
  Output : 6
  The sub array is {1, 1, 1, 1, 1, 1}*/

  def main(args: Array[String]) {
    val ar: Array[Int] = Array(1, 1, 1, 1, -4, -2, 1, 2, 3)
    val output = getLargestSubArray(2, ar).toList
    print(output)
  }

  def getLargestSubArray(k: Int, ar: Array[Int]): Array[Int] = {
    //order the array
    val qq = mutable.PriorityQueue.empty[Int]
    for (r <- ar) {
      qq.enqueue(r)
    }
    val ab: ArrayBuffer[Int] = ArrayBuffer.empty

    for (_ <- 0 until k) {
      ab += qq.dequeue()
    }
    var isZeroPlus = true
    while (!qq.isEmpty && isZeroPlus) {
      val x = qq.dequeue()
      isZeroPlus = x > 0
      if (isZeroPlus) {
        ab += x
      }

    }
    ab.toArray
    /*
  using sorted array
    val or  = ar.sorted(Ordering[Int].reverse)
    val arb=or.splitAt(k)._1.to(ArrayBuffer)
    var s = k

    while (or(s)>0 ){
      arb+=or(s)
      s+=1
    }
    arb.toArray
*/
  }


}
